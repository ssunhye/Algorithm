package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv3_가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        int answer = solution(n, edge);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] edge) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        boolean[][] matrix = new boolean[n+1][n+1];

        for (int i=0; i<edge.length; i++) {
            matrix[edge[i][0]][edge[i][1]] = true;
            matrix[edge[i][1]][edge[i][0]] = true;
        }

        ans = bfs(1, q, visited, matrix);

        return ans;
    }

    public static int bfs(int start, Queue<Integer> q, boolean[] visited, boolean[][] matrix) {
        int ans = 0;
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int cur = q.poll();
                for (int j=0; j<visited.length; j++) {
                    if (matrix[j][cur] && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
            }
            ans = size;
        }

        return ans;
    }
}
