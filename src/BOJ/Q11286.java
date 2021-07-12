package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {

    static int N;
    static PriorityQueue<Number> queue = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());
        for (int i=0; i<N; i++) {
            int x = stoi(br.readLine());
            Number n = new Number(x, Math.abs(x));

            if (x == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(queue.poll().rawX).append("\n");
                }
            } else {
                queue.offer(n);
            }
        }
        System.out.println(sb);
    }

    static class Number implements Comparable<Number> {
        int rawX;
        int absX;

        public Number(int rawX, int absX) {
            this.rawX = rawX;
            this.absX = absX;
        }

        @Override
        public int compareTo(Number o) {
            if (this.absX == o.absX) return this.rawX-o.rawX;
            return this.absX - o.absX;
        }
    }
}
