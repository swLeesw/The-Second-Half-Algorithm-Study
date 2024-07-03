import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int answer =Integer.MIN_VALUE;
        for(int i = 1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer,map[i][j]);
            }
        }
        dp = new int[N+1][M+1];
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=M ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1]+map[i][j]-dp[i-1][j-1];
            }
        }
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=M ; j++){
                answer = Math.max(answer,find(i,j));
            }
        }
        System.out.println(answer);

    }
    static int find(int i , int j){
        int result = Integer.MIN_VALUE;
        for(int x = 1 ;x<i ; x++){
            for(int y = 1 ; y<j ; y++){
                int thisresult = dp[i][j]+dp[x][y]-dp[x][j]-dp[i][y];
                result = Math.max(result,thisresult);
            }
        }
        return result;
    }

}
