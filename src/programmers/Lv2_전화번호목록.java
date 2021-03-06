package programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv2_전화번호목록 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean answer = solution(phone_book);

        System.out.println(answer);
    }

    public static boolean solution(String[] phone_book) {
        /* 첫번째 풀이
        boolean answer = true;

        Map<String, Integer> hm = new HashMap<>();
        for (int i=0; i<phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        for (int i=0; i<phone_book.length; i++) {
            for (int j=0; j<phone_book[i].length(); j++) {
                if (hm.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
         */

        int n = phone_book.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(phone_book[i], i);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<phone_book[i].length(); j++) {
                String str = phone_book[i].substring(0, j);
                if (map.containsKey(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
