package programmers;

public class Lv2_주식가격 {
    static int[] answer;

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        answer = solution(prices);
        System.out.println(answer);
    }

    public static int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        int time = 0;

        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j< prices.length; j++) {
                time++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            ans[i] = time;
            time = 0;
        }

        return ans;
    }
}
