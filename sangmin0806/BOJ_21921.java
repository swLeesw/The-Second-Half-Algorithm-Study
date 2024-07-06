import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = new int[N];
        int  window= 0;
        for (int i = 0; i < X; i++) {
            window += arr[i];
        }
        int max = window;
        temp[X-1] = max;
        for (int i = X; i < N; i++) {
            window-=arr[i-X];
            window+=arr[i];
            max = Math.max(max,window);
            temp[i] = window;
        }
        if(max ==0){
            System.out.println("SAD");
            return;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(temp[i]==max) count++;

        }
        System.out.println(max);
        System.out.println(count);
    }
}
