package programmers;

import java.util.ArrayList;
import java.util.List;

public class Lv1_모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        int[] answer = solution(answers);
        System.out.println(answer);
    }

    public static int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for (int i=0; i<answers.length; i++) {
            if (p1[i%5] == answers[i]) score[0]++;
            if (p2[i%8] == answers[i]) score[1]++;
            if (p3[i%10] == answers[i]) score[2]++;
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        List<Integer> list = new ArrayList();

        for (int i=0; i<score.length; i++) {
            if (score[i] == max) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
