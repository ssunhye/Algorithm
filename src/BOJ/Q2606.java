package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {
    static int N, M;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static Node[] adj;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());

        visited = new boolean[N+1];
        adj = new Node[N+1];

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            adj[u] = new Node(v, adj[u]);
            adj[v] = new Node(u, adj[v]);
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int n) {
        int cnt = 0;
        visited[n] = true;
        q.offer(n);

        while(!q.isEmpty()) {
            int x = q.poll();

            for (Node node=adj[x]; node!=null; node=node.next) {
                if (!visited[node.n]) {
                    q.offer(node.n);
                    visited[node.n] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Node {
        int n;
        Node next;

        public Node(int n, Node next) {
            this.n = n;
            this.next = next;
        }
    }

}
