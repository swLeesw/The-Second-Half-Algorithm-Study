import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][M];
        int dp[][] = new int[N][M];
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0;m<M;m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        int max = Integer.MIN_VALUE;
        for(int n=1;n<N;n++){
            dp[n][0] = dp[n-1][0]+map[n][0];
        }
        for(int m=1;m<M;m++){
            dp[0][m] = dp[0][m-1]+map[0][m];
        }
        for(int n=1;n<N;n++){
            for(int m=1;m<M;m++){
                dp[n][m]=dp[n-1][m]+dp[n][m-1]+map[n][m]-dp[n-1][m-1];
            }
        }
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                max = Math.max(max,dp[n][m]);
            }
        }
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                for(int nk=n;nk>=0;nk--){
                    for(int mk=m;mk>=0;mk--){
                        if(nk==n&&mk==m)continue;
                        if(nk==0||mk==0||nk==n|mk==m) max=Math.max(max,dp[n][m]-dp[nk][mk]);
                        else{
                            max = Math.max(dp[n][m]-dp[nk][m]-dp[n][mk]+dp[nk][mk],max);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
