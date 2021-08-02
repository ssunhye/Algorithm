package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for (int i=0; i<answers.length; i++) {
            if (p1[i%5] == answers[i]) score[0]++;
            if (p2[i%8] == answers[i]) score[1]++;
            if (p3[i%10] == answers[i]) score[2]++;
        }
        int[] sortScore = score.clone();
        Arrays.sort(sortScore);

        List<Integer> list = new ArrayList();

        for (int i=0; i<score.length; i++) {
            if (score[i] == sortScore[2]) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println(answer[0]);
        return;
    }
}
