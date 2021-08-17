package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv3_네트워크 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(n, computers);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] computers) {
        int ans = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                ans++;
            }
        }

        return ans;
    }

    public static void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i=node+1; i<computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
