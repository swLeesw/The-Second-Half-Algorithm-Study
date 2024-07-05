package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(n,0);
        System.out.println(minValue + " " + maxValue);
    }//main end

    private static void dfs(int n, int count) {
        count += countSingle(n);
        if(n / 10 == 0){
            maxValue = Math.max(maxValue,count);
            minValue = Math.min(minValue,count);
        }else if(n / 100 == 0){
            int next = n / 10;
            next += n % 10;
            dfs(next,count);
        }else{
            String str = String.valueOf(n);
            for(int i = 0; i < str.length() - 2; i++){
                for(int j = i+1; j < str.length() - 1; j++){
                    int next = Integer.parseInt(str.substring(0,i+1));
                    next += Integer.parseInt(str.substring(i+1,j+1));
                    next += Integer.parseInt(str.substring(j+1));
                    dfs(next,count);
                }
            }
        }
    }//dfs end

    private static int countSingle(int n) {
        int count = 0;
        while(n > 0){
            int next = n % 10;
            if(next % 2 == 1){
                count++;
            }
            n /= 10;
        }
        return count;
    }
}//class end
