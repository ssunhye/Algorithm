package Programmers;

public class Lv1_test2 {
    public static void main(String[] args) {
        long answer = 0;

        int a = 3;
        int b = 5;

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        for (int i=min; i<=max; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}
