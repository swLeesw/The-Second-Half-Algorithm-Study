import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int prev = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = prev + Integer.parseInt(st.nextToken());
            prev = arr[i];
        }

        int answer = arr[X - 1], count = 1;
        for (int i = 0; i < N - X; i++) {
            int cur = arr[i + X] - arr[i];
            if (answer < cur) {
                answer = arr[i + X] - arr[i];
                count = 1;
            } else if (answer == cur) {
                count++;
            }
        }

        if (answer == 0) {
            sb.append("SAD");
        } else {
            sb.append(answer).append("\n").append(count);
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}