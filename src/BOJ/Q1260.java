package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    static int N, M, V;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    public static void bfs(int s) {
        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i=1; i<=N; i++) {
                if (matrix[cur][i]==1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int i=1; i<=N; i++) {
            if (matrix[cur][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
