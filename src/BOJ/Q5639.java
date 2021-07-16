package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5639 {

    static Node root;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(stoi(br.readLine()));

        // 노드 생성 트리 생성
        String n;
        while(true) {
            n = br.readLine();
            if (n == null || n.equals("")) break;
            Node node = new Node(stoi(n));
            connectNode(root, node);
        }

        // 후위 순위
        postOrder(root);
        System.out.println(sb);
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.num).append("\n");
    }

    static void connectNode(Node cur, Node next) {
        if (next.num < cur.num) {
            if (cur.left != null) {
                connectNode(cur.left, next);
            } else {
                cur.left = next;
            }
        } else {
            if (cur.right != null) {
                connectNode(cur.right, next);
            } else {
                cur.right = next;
            }
        }
    }

    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }
    }
}
