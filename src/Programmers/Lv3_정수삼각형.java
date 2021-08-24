package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Lv3_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = solution(triangle);
        System.out.println(answer);
    }

    public static int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len+1][len+1];
        dp[1][1] = triangle[0][0];
        for (int i=2; i<=len; i++) {
            for (int j=1; j<=i; j++) {
                dp[i][j] = triangle[i-1][j-1] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        return Arrays.stream(dp[len]).max().getAsInt();
    }
}
