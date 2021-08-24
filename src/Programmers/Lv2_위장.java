package programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv2_위장 {
    static int answer;

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "face"},{"bluesunglasses", "face"},{"green_turban", "face"}};
        answer = solution(clothes);
        System.out.println(answer);
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        }
        int ans = 1;
        for (Integer value : hm.values()) {
            ans *= value;
        }
        return ans-1;
    }
}
