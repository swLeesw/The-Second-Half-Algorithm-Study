import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i - 1];
            if (arr[i] < arr[i - 1]) {
                sum[i] += 1;
            }
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(sum[y] - sum[x]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}