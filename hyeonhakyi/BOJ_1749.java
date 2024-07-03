package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n+1][m+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }

        long max = Long.MIN_VALUE;
        for(int n1 = 1; n1 <= m; n1++){
            for(int n2 = n1; n2 <= m; n2++){
                long last = 0;
                for(int m1 = 1; m1 <= n; m1++){
                    long sum = arr[m1][n2] - arr[m1][n1 - 1] - arr[m1 - 1][n2] + arr[m1 - 1][n1 - 1];

                    last = Math.max(last + sum, sum);

                    max = Math.max(max, last);
                }
            }
        }

        System.out.println(max);
    }//main end
}//class end
