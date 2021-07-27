package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {

    static int N, M, K;
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static int[][] deltas = {{0,-1}, {1,0}, {0,1}, {-1,0}};

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = stoi(st.nextToken());
            M = stoi(st.nextToken());
            K = stoi(st.nextToken());

            matrix = new int[N][M];
            visited = new boolean[N][M];
            int cnt = 0;
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());

                matrix[u][v] = 1;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (matrix[i][j]==1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];

            if (isIn(nx, ny) && matrix[nx][ny]==1) {
                matrix[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}

