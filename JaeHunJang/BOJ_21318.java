import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 피아노 체조 / 120분
public class BOJ_21318 {
    static int N, Q, dp[], list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (i > 1) {
                dp[i] = dp[i-1];
                if (list[i] < list[i - 1]) {
                    dp[i]++;
                }
            }
        }
        dp[N] = dp[N-1];

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int answer = dp[end] - dp[start];
            if (end < N && list[end] < list[end-1]) {
                answer--;
            }
            if (start > 0 && start < N && list[start] < list[start-1]) {
                answer++;
            }
            System.out.println(answer);
        }
    }
}