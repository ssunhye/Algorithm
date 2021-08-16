package Programmers;

import java.util.Arrays;

public class Lv2_카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int answer[] = solution(brown, yellow);
        System.out.println(answer);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int k = 3;

        outer: for (int height=3; k*height <= brown+yellow; height++) {
            for (int width=3; width*height <= brown+yellow; width++) {
                if ((width-2)*(height-2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break outer;
                }
            }
            k++;
        }

        return answer;
    }
}
