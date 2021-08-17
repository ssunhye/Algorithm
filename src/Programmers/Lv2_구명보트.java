package Programmers;

import java.util.Arrays;

public class Lv2_구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = solution(people, limit);
        System.out.println(answer);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int pointer = 0;

        Arrays.sort(people);

        for (int i=people.length-1; i>=pointer; --i) {
            if (people[pointer] + people[i] <= limit) pointer++;
            answer++;
        }

        return answer;
    }
}
