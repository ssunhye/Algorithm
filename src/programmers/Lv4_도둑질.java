package programmers;

public class Lv4_도둑질 {
    public static int n;

    public static void main(String[] args) {
        int[] money = {1,2,3,1};

        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        n = money.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = money[0];
        arr1[1] = money[0];
        arr2[0] = 0;
        arr2[1] = money[1];

        for (int i=2; i<n-1; i++) {
            arr1[i] = Math.max(arr1[i-2]+money[i], arr1[i-1]);
            arr2[i] = Math.max(arr2[i-2]+money[i], arr2[i-1]);
        }

        arr2[n-1] = Math.max(arr2[n-3]+money[n-1], arr2[n-2]);

        return Math.max(arr1[n-2], arr2[n-1]);
    }
}
