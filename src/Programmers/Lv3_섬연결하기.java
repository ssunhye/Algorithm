package programmers;

import java.util.PriorityQueue;

public class Lv3_섬연결하기 {
    public static int[] parent;
    public static PriorityQueue<Edge> adj;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};

        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int len = costs.length;

        parent = new int[n];
        adj = new PriorityQueue<>();

        for (int i=0; i<len; i++) {
            Edge edge = new Edge(costs[i]);
            adj.offer(edge);
        }

        for (int i=0; i<n; i++) {
            parent[i] = i;
        }

        while(!adj.isEmpty()) {
            Edge edge = adj.poll();

            if (find(edge.from) == find(edge.to)) continue;
            else {
                union(edge.from, edge.to);
                answer += edge.cost;
            }
        }
        return answer;
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootB] = rootA;
    }

    public static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;

        public Edge(int[] costs) {
            this.from = costs[0];
            this.to = costs[1];
            this.cost = costs[2];
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
