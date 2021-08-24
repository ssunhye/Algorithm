package programmers;

import java.util.Arrays;

public class Lv2_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = solution(citations);
        System.out.println(answer);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
