package programmers;

import java.util.Arrays;

public class Lv1_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] newArray = new int[end-start+1];
            int cnt = 0;
            for (int s=start-1; s<end; s++) {
                newArray[cnt++] = array[s];
            }
            Arrays.sort(newArray);
            answer[i] = newArray[k-1];
        }

        System.out.println(answer);
        return;
    }
}
