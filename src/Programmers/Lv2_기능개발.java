package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lv2_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = solution(progresses, speeds);
        System.out.println(answer);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            q.offer((int)Math.ceil((100.0-progresses[i])/speeds[i]));
            System.out.println(Math.ceil((100-progresses[i])/speeds[i]));
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && cur >= q.peek()) {
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
