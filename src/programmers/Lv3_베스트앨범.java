package programmers;

import java.util.*;

public class Lv3_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new LinkedList<>();
        int n = genres.length;
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keyList = new LinkedList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        for (String key : keyList) {
            System.out.println(map.get(key));
            List<Music> list = new LinkedList<>();

            for (int i=0; i<n; i++) {
                if (key.equals(genres[i])) {
                    list.add(new Music(i, plays[i]));
                }
            }
            Collections.sort(list);

            for (int j=0; j<list.size(); j++) {
                if (j>1) break;
                answerList.add(list.get(j).idx);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static class Music implements Comparable<Music>{
        int idx;
        int play;

        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            if (this.play == o.play) return this.idx - o.idx;
            return o.play - this.play;
        }
    }
}
