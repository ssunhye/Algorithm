package Programmers;

import java.util.Arrays;

public class Lv2_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = solution(citations);
        System.out.println(answer);
    }

    public static int solution(int[] citations) {
        int h = citations.length;
        Arrays.sort(citations);

        while (true) {
            int cnt = 0;
            for (int i=citations.length-1; i>=0; --i) {
                if (h <= citations[i]) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (h <= cnt) {
                break;
            } else {
                --h;
            }
        }

        return h;
    }
}
