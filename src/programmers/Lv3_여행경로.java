package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv3_여행경로 {
    public static boolean[] visited;
    public static int n;
    public static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n];

        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(answer);

        return  answer.get(0).split(" ");
    }

    public static void dfs(String city, String routes, int idx, String[][] tickets) {
        if (idx == n) {
            answer.add(routes);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] == false && tickets[i][0].equals(city)) {
                visited[i] = true;
                dfs(tickets[i][1], routes+" "+tickets[i][1], idx+1, tickets);
                visited[i] = false;
            }
        }
    }
}
