package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static int N, M;
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] visited;
    static int[][] matrix;
    static int[][] deltas = {{0,-1}, {1,0}, {0,1}, {-1,0}};

    static int stoi(String s)
    {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                matrix[i][j] = s.charAt(j)-'0';
            }
        }
        bfs(new Point(0, 0));
        System.out.println(matrix[N-1][M-1]);
    }

    public static void bfs(Point p) {
        visited[p.x][p.y] = true;
        q.offer(p);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur.x + deltas[i][0];
                int ny = cur.y + deltas[i][1];

                if (isIn(nx, ny) && matrix[nx][ny]!=0 && !visited[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    matrix[nx][ny] = matrix[cur.x][cur.y] + 1;
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
