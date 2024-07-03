import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수
        int k = Integer.parseInt(st.nextToken()); // 사건의 전후 관계의 개수
        int[][] dp = new int[n+1][n+1];
        for(int i = 0 ; i< k ; i++){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            dp[before][after] = -1;
            dp[after][before] = 1;
        }
        for(int i = 1 ; i<=n ; i++){
            for(int j = 1 ; j<=n ; j++){
                for(int e = 1 ; e<=n ; e++){
                    if(dp[j][i]==1 && dp[i][e] == 1) dp[j][e] = 1;
                    if(dp[j][i]==-1 && dp[i][e]==-1) dp[j][e] = -1;
                }
            }
        }
        int s = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<s ; i++){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            System.out.println(dp[before][after]);
        }

    }


}
