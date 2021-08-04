package programmers;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Lv2_더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = solution(scoville, K);

        System.out.println(answer);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(pq.peek() < K) {
            if (pq.size()<2) {
                return -1;
            } else {
                pq.offer(pq.poll() + pq.poll()*2);
                answer++;
            }

        }

        return answer;
    }
}
