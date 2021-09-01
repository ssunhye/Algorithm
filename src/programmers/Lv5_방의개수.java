package programmers;

import java.util.HashSet;
import java.util.Set;

public class Lv5_방의개수 {
    public static int[][] deltas = {{0,-1}, {1,-1}, {1,0}, {1,1}, {0,1},{-1,1}, {-1,0},{-1,-1}};
    public static Set<Point> point = new HashSet<>();
    public static Set<Edge> edge = new HashSet<>();
    public static int n;

    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(solution(arrows));
    }

    public static int solution(int[] arrows) {
        n = arrows.length;
        int answer = 0;
        int x = 0;
        int y = 0;

        point.add(new Point(x, y));

        for (int i=0; i<n; i++) {
            int d = arrows[i];
            x += deltas[d][0];
            y += deltas[d][1];

            Point cur = new Point(x, y);

            if (edge.contains(new Edge(x-deltas[d][0], y, x, y-deltas[d][1], d))) {
                continue;
            }
            if (point.contains(cur)) {
                answer++;
            } else {
                point.add(cur);
            }


        }

        return answer;
    }

    static class Edge {
        int x1, y1;
        int x2, y2;
        int d;

        public Edge(int x1, int y1, int x2, int y2, int d) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.d = d;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
