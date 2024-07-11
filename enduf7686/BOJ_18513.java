import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18513 {

    private static int N, K;
    private static Set<Integer> lakes;

    private static int[] dx = {-1, 1};
    private static long answer;

    public static void main(String[] args) throws IOException {
        init();

        bfs();

        printAnswer();
    }

    private static void bfs() {
        Queue<Location> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>(lakes);

        for (int lake : lakes) {
            queue.offer(new Location(lake, 0));
        }

        int count = 0;
        long sum = 0;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 2; i++) {
                int next = current.getLocation() + dx[i];

                if (visited.contains(next)) {
                    continue;
                }

                count++;
                if (count > K) {
                    answer = sum;
                    return;
                }

                queue.offer(new Location(next, current.getDistance() + 1));
                visited.add(next);
                sum += current.getDistance() + 1;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lakes = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lakes.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }

    private static class Location {

        private int location;
        private int distance;

        public Location(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        public int getLocation() {
            return location;
        }

        public int getDistance() {
            return distance;
        }
    }
}
