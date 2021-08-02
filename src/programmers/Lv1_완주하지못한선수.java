package programmers;

import java.util.Arrays;

public class Lv1_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                System.out.println(answer);
            }
        }
        answer = participant[participant.length-1];
        System.out.println(answer);
        return;
    }
}
