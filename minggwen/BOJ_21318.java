import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        int dp[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n=1;n<=N;n++){
            arr[n] = Integer.parseInt(st.nextToken());
            if(arr[n]-arr[n-1]<0)dp[n]=dp[n-1]+1;
            else dp[n]=dp[n-1];
        }
        int Q = Integer.parseInt(br.readLine());
        for(int q=1;q<=Q;q++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end]-dp[start]);
        }
    }
}
