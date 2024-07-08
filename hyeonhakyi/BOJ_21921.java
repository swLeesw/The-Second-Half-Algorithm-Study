package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < x; i++){
            sum += arr[i];
        }

        int max = sum;
        int maxCount = 1;
        for(int i = x; i < n; i++){
            sum += arr[i] - arr[i-x];
            if(sum == max){
                maxCount++;
            }else if(sum > max){
                max = sum;
                maxCount = 1;
            }
        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCount);
    }//main end
}//class end
