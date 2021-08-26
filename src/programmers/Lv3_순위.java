package programmers;

public class Lv3_순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};

        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n][n];

        for(int i = 0; i < results.length; i++) {
            int win = results[i][0]-1;
            int lose = results[i][1]-1;
            map[win][lose] = 1;
            map[lose][win] = -1;
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n ; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j || map[i][j]!=0) continue;
                    if(map[i][k] == map[k][j]){
                        map[i][j] = map[i][k];
                    }
                }
            }
        }

        loop : for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0 && i!=j ) continue loop;
            }
            answer++;
        }
        return answer;
    }
}
