package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Lv1_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String answer = solution(participant, completion);

        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        /* 첫번째 풀이
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
        }
        answer = participant[participant.length - 1];
        return answer;
        */

        /* 두번째 풀이
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i<completion.length; i++) {
            if (participant[i].equals(completion[i])) {
                continue;
            } else {
                return participant[i];
            }
        }

        return participant[participant.length-1];
        */

        // 세번째 풀이
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0)+1);
        }

        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
