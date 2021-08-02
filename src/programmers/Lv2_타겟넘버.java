package programmers;

public class Lv2_타겟넘버 {
    static int answer;

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(0, target, 0, numbers);
        System.out.println(answer);
    }

    public static void dfs(int cnt, int target, int sum, int[] numbers) {
        if (cnt == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(cnt+1, target, sum+numbers[cnt], numbers);
        dfs(cnt+1, target, sum-numbers[cnt], numbers);
    }
}
