import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {

    private static final int MAX_SIZE = 1101;
    private static final int MAX_VALUE = 1000000;

    private static int C, N;
    private static Promotion[] promotions;

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();

        makeDPTable();

        printAnswer();
    }

    private static void makeDPTable() {
        dp = new int[MAX_SIZE];
        Arrays.fill(dp, MAX_VALUE);

        for (int i = 0; i < N; i++) {
            Promotion promotion = promotions[i];
            dp[promotion.getValue()] = Math.min(dp[promotion.getValue()], promotion.getCost());
        }

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j < N; j++) {
                Promotion promotion = promotions[j];
                dp[i + promotion.getValue()] = Math.min(dp[i + promotion.getValue()], dp[i] + promotion.getCost());
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        promotions = new Promotion[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            promotions[i] = new Promotion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    private static void printAnswer() {
        System.out.println(Arrays.stream(dp, C, 1101).min().getAsInt());
    }

    private static class Promotion {

        private int cost;
        private int value;

        public Promotion(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }

        public int getCost() {
            return cost;
        }

        public int getValue() {
            return value;
        }
    }
}
