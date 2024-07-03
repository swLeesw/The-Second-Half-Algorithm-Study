import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점수따먹기 / 90분
public class BOJ_1749 {
    static int N, M;
    static long dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        long answer = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int n = i; n <= N; n++) {
                    for (int m = j; m <= M; m++) {
                        long sum = dp[n][m] - dp[i-1][m] - dp[n][j-1] + dp[i-1][j-1];
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}