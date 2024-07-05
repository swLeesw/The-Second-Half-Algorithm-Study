import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }

        int answer = 0;
        for (int i = 0; i < W; i++) {
            int left, right;
            left = right = Integer.MIN_VALUE;

            for (int j = i; j >= 0; j--) {
                left = Math.max(left, arr[j]);
            }
            for (int j = i; j < W; j++) {
                right = Math.max(right, arr[j]);
            }
            answer += Math.min(left, right) - arr[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}