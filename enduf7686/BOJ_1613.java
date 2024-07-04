import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1613 {

    private static final int INF = 100_000_000;

    private static int N, K, S;
    private static boolean[][] upGraph;
    private static boolean[][] downGraph;
    private static Query[] queries;

    private static int[][] answer;

    public static void main(String[] args) throws IOException {
        init();

        floydWarshall();

        printAnswer();
    }

    private static void floydWarshall() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(answer[i], INF);
        }

        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++) {
                if (upGraph[from][to]) {
                    answer[from][to] = -1;
                }

                if (downGraph[from][to]) {
                    answer[from][to] = 1;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (answer[from][k] == -1 && answer[k][to] == -1) {
                        answer[from][to] = -1;
                    }

                    if (answer[from][k] == 1 && answer[k][to] == 1) {
                        answer[from][to] = 1;
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        upGraph = new boolean[N + 1][N + 1];
        downGraph = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            upGraph[from][to] = true;
            downGraph[to][from] = true;
        }

        S = Integer.parseInt(br.readLine());
        queries = new Query[S];
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int event1 = Integer.parseInt(st.nextToken());
            int event2 = Integer.parseInt(st.nextToken());

            queries[i] = new Query(event1, event2);
        }

        answer = new int[N + 1][N + 1];
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (Query query : queries) {
            sb.append(answer[query.getEvent1()][query.getEvent2()] == INF ? 0 : answer[query.getEvent1()][query.getEvent2()]).append('\n');
        }

        System.out.println(sb);
    }

    private static class Query {

        private int event1;
        private int event2;

        public Query(int event1, int event2) {
            this.event1 = event1;
            this.event2 = event2;
        }

        public int getEvent1() {
            return event1;
        }

        public int getEvent2() {
            return event2;
        }
    }
}
