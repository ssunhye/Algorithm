package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lv3_단어변환 {
    static Queue<Node> q = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        if(!Arrays.stream(words).filter(word -> word.equals(target)).findAny().isPresent()) {
            return 0;
        }
        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    public static int bfs(String begin, String target, String[] words) {
        q.offer(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int i=0; i<words.length; i++) {
                if (visited[i]) continue;

                if (CanChange(cur.word, words[i])) {
                    if (words[i].equals(target)) return cur.cnt+1;
                    q.offer(new Node(words[i], cur.cnt+1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    public static boolean CanChange(String from, String to) {
        int diff = 0;

        for (int i=0; i<from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) diff++;
        }

        if (diff==1) return true;
        return false;
    }

    static class Node {
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
