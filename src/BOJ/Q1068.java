package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1068 {

    static int N;
    static int[] parents;
    static int removeNode;
    static boolean[] visited;
    static boolean[] leaves;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        parents = new int[N];
        visited = new boolean[N];
        leaves  = new boolean[N];
        Arrays.fill(leaves, true);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            parents[i] = stoi(st.nextToken());
        }

        removeNode = stoi(br.readLine());
        if (parents[removeNode] == -1) {
            System.out.println(0);
            return;
        }

        delete(removeNode);

        for (int i=0; i<N; i++) {
            if (parents[i] == -1) continue;
            if (!visited[i]) {
                leaves[parents[i]] = false;
            }
        }
        
        int ans = 0;
        for (int i=0; i<N; i++) {
            if (leaves[i]) ans++;
        }
        System.out.println(ans);
    }

    static void delete(int node) {
        visited[node] = true;
        leaves[node] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i=0; i<N; i++) {
                if (cur == parents[i] && !visited[i]) {
                    visited[i] = true;
                    leaves[i] = false;
                    queue.offer(i);
                }
            }
        }
    }
}
/*
4
-1 0 1 2
2
 */
