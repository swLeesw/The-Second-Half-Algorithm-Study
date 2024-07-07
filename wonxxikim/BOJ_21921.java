import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] nusum = new int[N+1];
        st=  new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N ; i++){
            int x = Integer.parseInt(st.nextToken());
            nusum[i] = nusum[i-1]+x;
        }
        int max = 0;
        int cnt = 0;
        for(int i = X ; i<=N ; i++) {
            if (max < (nusum[i] - nusum[i - X])) {
                max = nusum[i] - nusum[i - X];
                cnt = 1;

            }
            else if(max==(nusum[i]-nusum[i-X])) cnt++;
        }
        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(cnt);
        }


    }
}
