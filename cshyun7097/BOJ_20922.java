import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0, start = 0, end = 0;
        int[] cnt = new int[100001];
        while (end < N) {
            while (end < N && cnt[arr[end]] + 1 <= K) {
                cnt[arr[end++]]++;
            }

            int len = end - start;
            res = Math.max(res, len);

            cnt[arr[start++]]--;
        }
        System.out.println(res);
    }
}
