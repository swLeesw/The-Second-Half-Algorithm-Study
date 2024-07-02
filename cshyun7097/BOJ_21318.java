import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318 {

    static int N, Q;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        sum = new int[N + 1];

        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
            if (arr[i - 1] > arr[i]) {
                sum[i] += sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int start, end;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}