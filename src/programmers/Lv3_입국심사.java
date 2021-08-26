package programmers;

import java.util.Arrays;

public class Lv3_입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = solution(n, times);
        System.out.println(answer);
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = (long)times[0] * (n/times.length);
        long right = (long)times[times.length-1] * (n/times.length+1);
        long answer = right;

        while (left <= right) {
            long mid = (left+right)/2;
            long tmp = 0;
            for (int i=0; i<times.length; i++) {
                tmp += mid/times[i];
            } if (tmp >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
