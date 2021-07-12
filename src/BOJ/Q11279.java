package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11279 {

    static int N;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());
        for (int i=0; i<N; i++) {
            int x = stoi(br.readLine());

            if (x == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(queue.poll()*-1).append("\n");
                }
            } else {
                queue.offer(x*-1);
            }
        }
        System.out.println(sb);
    }
}
