import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {
    static int C,N;
    static int[][] cost;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cost = new int[N+1][2];
        dp = new int[C+101];//고객의 수 별 비용
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = cost[i][1]; j < C+101; j++) {
                if(dp[j-cost[i][1]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-cost[i][1]]+cost[i][0],dp[j]);
                }

            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = C; i <C+101 ; i++) {
            answer = Math.min(answer,dp[i]);
        }
        System.out.println(answer);




    }
}
