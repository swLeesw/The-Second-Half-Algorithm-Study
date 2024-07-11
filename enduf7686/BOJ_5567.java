import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {

    private static int N, M;
    private static boolean[][] graph;

    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        bfs();

        printAnswer();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] depth = new int[N + 1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 1; next <= N; next++) {
                if (!graph[current][next]) {
                    continue;
                }

                if (visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
                depth[next] = depth[current] + 1;
            }
        }

        answer = (int) Arrays.stream(depth)
                .filter(num -> num == 1 || num == 2)
                .count();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = true;
            graph[to][from] = true;
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
