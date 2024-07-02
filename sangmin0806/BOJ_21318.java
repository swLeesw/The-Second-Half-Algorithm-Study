import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] level = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }
        int[] mistake = new int[N];
        int pre = level[0];
        for (int i = 1; i < N; i++) {
            int cur = level[i];
            if(cur<pre){
                mistake[i]=mistake[i-1]+1;
            }
            else {
                mistake[i] = mistake[i-1];
            }
            pre = cur;
        }

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(mistake[y-1]-mistake[x-1]);
        }
    }
}
