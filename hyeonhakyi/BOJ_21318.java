package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] melodies = new int[n+1];
        int[] sum = new int[n+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            melodies[i] = Integer.parseInt(st.nextToken());
            if(melodies[i - 1] > melodies[i]){
                sum[i] += sum[i-1] + 1;
            }else{
                sum[i] = sum[i-1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start]).append("\n");
        }
        System.out.println(sb);
    }//main end
}//class end
