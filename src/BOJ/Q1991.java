package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {

    static int N;
    static Node arr[] = new Node[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<26; i++) {
            arr[i] = new Node(Character.toString((char)(i+'A')));
        }

        for (int i=0; i<N; i++) {
            char n, l, r;
            String s = br.readLine();
            n = s.charAt(0);
            l = s.charAt(2);
            r = s.charAt(4);
            if (l!='.') {
                arr[n-'A'].left = l-'A';
                arr[l-'A'].parent = n-'A';
            }
            if (r!='.'){
                arr[n-'A'].right = r-'A';
                arr[r-'A'].parent = n-'A';
            }
        }

        // 전위 순회
        preOrder(0);
        sb.append("\n");
        // 중위 순회
        inOrder(0);
        sb.append("\n");
        // 후위 순회
        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    static void preOrder(int node) {
        sb.append(arr[node].s);
        if (arr[node].left > -1) preOrder(arr[node].left);
        if (arr[node].right > -1) preOrder(arr[node].right);
    }

    static void inOrder(int node) {
        if (arr[node].left > -1) inOrder(arr[node].left);
        sb.append(arr[node].s);
        if (arr[node].right > -1) inOrder(arr[node].right);
    }

    static void postOrder(int node) {
        if (arr[node].left > -1) postOrder(arr[node].left);
        if (arr[node].right > -1) postOrder(arr[node].right);
        sb.append(arr[node].s);
    }

    static class Node {
        String s;
        int parent;
        int left;
        int right;

        public Node(String s) {
            this.s = s;
            this.parent = this.right = this.left = -1;
        }
    }

}
