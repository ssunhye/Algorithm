package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963 {
    static int N, M;
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] visited;
    static int[][] matrix;
    static int[][] deltas = {{0,-1}, {1,0}, {0,1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());

            if (N==0 && M==0) break;

            int ans = 0;
            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++) {
                    matrix[i][j] = stoi(st.nextToken());
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (matrix[i][j]!=0) {
                        bfs(new Point(i, j));
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(Point p) {
        q.offer(p);
        matrix[p.x][p.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i=0; i<8; i++) {
                int nx = cur.x + deltas[i][0];
                int ny = cur.y + deltas[i][1];

                if (isIn(nx, ny) && matrix[nx][ny]!=0) {
                    q.offer(new Point(nx, ny));
                    matrix[nx][ny] = 0;
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
