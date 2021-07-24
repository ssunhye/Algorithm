package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1991 {

    static int N;
    static Map<Character, Node> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            map.put((char)('A'+i), new Node((char)('A'+i)));
        }

        for (int i=0; i<N; i++) {
            char n, l, r;
            String s = br.readLine();
            n = s.charAt(0);
            l = s.charAt(2);
            r = s.charAt(4);
            if (l != '.') {
                map.get(n).left = map.get(l);
            }
            if (r != '.'){
                map.get(n).right = map.get(r);
            }
        }

        // 전위 순회
        preOrder(map.get('A'));
        sb.append("\n");
        // 중위 순회
        inOrder(map.get('A'));
        sb.append("\n");
        // 후위 순회
        postOrder(map.get('A'));
        sb.append("\n");

        System.out.println(sb);
    }

    static void preOrder(Node node) {
        sb.append(node.ch);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node.left != null) inOrder(node.left);
        sb.append(node.ch);
        if (node.right != null) inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.ch);
    }

    static class Node {
        char ch;
        Node left;
        Node right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

}
