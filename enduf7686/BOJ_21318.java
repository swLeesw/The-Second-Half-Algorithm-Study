import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318 {

    private static int N, Q;
    private static int[] difficulty;
    private static Query[] queries;

    private static int[] sum;

    public static void main(String[] args) throws IOException {
        init();

        makePrefixSumArray();

        printAnswer();
    }

    private static void makePrefixSumArray() {
        sum = new int[N];

        if (N == 1) {
            sum[0] = 0;
            return;
        }

        if (difficulty[0] > difficulty[1]) {
            sum[0] = 1;
        }

        for (int i = 1; i < N - 1; i++) {
            if (difficulty[i] > difficulty[i + 1]) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        sum[N - 1] = sum[N - 2];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        difficulty = new int[N];
        for (int i = 0; i < N; i++) {
            difficulty[i] = Integer.parseInt(st.nextToken());
        }

        Q = Integer.parseInt(br.readLine());
        queries = new Query[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = new Query(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }
    }

    private static void printAnswer() {
        for (Query query : queries) {
            if (query.getStart() == query.getEnd()) {
                System.out.println(0);
                continue;
            }

            if (query.getStart() == 0) {
                System.out.println(sum[query.getEnd() - 1]);
                continue;
            }

            System.out.println(sum[query.getEnd() - 1] - sum[query.getStart() - 1]);
        }
    }

    private static class Query {

        private int start;
        private int end;

        public Query(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
