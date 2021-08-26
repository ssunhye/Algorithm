package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Lv3_디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = solution(jobs);
        System.out.println(answer);
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        int n = jobs.length;
        int cnt = 0, cur = 0, answer = 0;

        List<Job> list = Arrays.stream(jobs)
                .map(Job::new)
                .sorted((a,b) -> a.start-b.start)
                .collect(Collectors.toList());

        while (cnt < n) {
            while (list.size() > 0 && list.get(0).start <= cur) {
                pq.add(list.remove(0));
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                answer += job.time + (cur-job.start);
                cur += job.time;
                cnt++;
            } else {
                cur++;
            }
        }

        return answer/n;
    }

    static class Job implements Comparable<Job> {
        int start;
        int time;

        public Job(int[] job) {
            this.start = job[0];
            this.time = job[1];
        }

        @Override
        public int compareTo(Job o) {
            return this.time - o.time;
        }
    }
}
