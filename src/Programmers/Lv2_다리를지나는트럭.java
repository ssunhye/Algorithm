package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_다리를지나는트럭 {
    static int answer;

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        answer = solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int time = bridge_length;
        int curWeight = 0;

        for (int i=0; i<truck_weights.length; i++) {
            while(true) {
                if (q.isEmpty()) {
                    q.offer(truck_weights[i]);
                    curWeight += truck_weights[i];
                    time++;
                    break;
                }

                if (bridge_length == q.size()) {
                    curWeight -= q.poll();
                } else if (curWeight + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    curWeight += truck_weights[i];
                    time++;
                    break;
                } else {
                    q.offer(0);
                    time++;
                }
            }
        }

        return time;
    }
}
