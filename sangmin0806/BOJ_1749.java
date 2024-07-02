import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {
    static int N,M;
    static int[][]map;
    static int[][]dp;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = map[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=M ; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];

            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                Max(i,j);
            }
        }
        System.out.println(answer);
    }
    public static void Max(int row, int col){
        for (int i = row; i <= N; i++) {
            for (int j = col; j <= M; j++) {
                answer = Math.max(dp[i][j]-dp[row-1][j]-dp[i][col-1]+dp[row-1][col-1],answer);

            }

        }
    }
}
