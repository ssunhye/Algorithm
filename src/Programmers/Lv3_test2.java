package Programmers;

import java.util.Arrays;
import java.util.List;

public class Lv3_test2 {
    public static void main(String[] args) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int answer = solution(a);
        System.out.println(answer);
    }

    public static int solution(int[] a) {
        int answer = 2;
        int len = a.length;

        for (int i=1; i<len-1; i++) {
            int cur = i;

            int[] arrLeft = new int[i];
            int[] arrRight = new int[len-i-1];
            int leftMin = a[0];
            int rightMin = a[len-1];


            for (int j=0; j<len; j++) {
                if (j<cur) {
                    arrLeft[j] = a[j];
                    leftMin = Math.min(a[j], leftMin);
                } else if (j>cur){
                    arrRight[j - cur -1] = a[j];
                    rightMin = Math.min(a[j], rightMin);
                }
            }

            if (a[cur] > leftMin && a[cur] > rightMin) {
                continue;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
