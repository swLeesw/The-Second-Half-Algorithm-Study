import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cost = new int[N];
        int[] customer = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C + 100];
        Arrays.fill(dp, 100_000_000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = customer[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}