import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10159 {

    private static final int INF = 100_000_000;

    private static int N, M;
    private static boolean[][] upGraph;
    private static boolean[][] downGraph;
    private static int[] answer;
    
    public static void main(String[] args) throws IOException {
        init();

        floydWarshall();

        printAnswer();
    }

    private static void floydWarshall() {
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++) {
                if (from == to) {
                    dist[from][to] = 0;
                    continue;
                }

                if (upGraph[from][to]) {
                    dist[from][to] = 1;
                } else if (downGraph[from][to]) {
                    dist[from][to] = -1;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (dist[from][k] == 1 && dist[k][to] == 1) {
                        dist[from][to] = 1;
                    } else if (dist[from][k] == -1 && dist[k][to] == -1) {
                        dist[from][to] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) {
                    count++;
                }
            }

            answer[i] = count;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        upGraph = new boolean[N + 1][N + 1];
        downGraph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            upGraph[from][to] = true;
            downGraph[to][from] = true;
        }

        answer = new int[N + 1];
    }

    private static void printAnswer() {
        Arrays.stream(answer, 1, N + 1).forEach(System.out::println);
    }
}
