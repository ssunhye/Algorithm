package programmers;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Lv2_소수찾기 {
    static String n;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "17";

        int answer = solution(numbers);

        System.out.println(set.size());
    }

    public static int solution(String numbers) {
        n = numbers;
        int[] arr = new int[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        perm("", 0);

        return set.size();
    }

    public static void perm(String str, int cnt) {
        if (cnt == n.length()) {
            if (str.length()>0 && isPrime(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
            return;
        }

        for (int i=0; i<n.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(str+n.charAt(i), cnt+1);
                perm(str, cnt+1);
                visited[i] = false;
            }

        }
    }

    public static boolean isPrime(int num) {
        if (num<2) {
            return false;
        }
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
