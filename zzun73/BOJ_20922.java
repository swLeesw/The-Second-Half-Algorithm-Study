import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] count = new int[100001];
        int left = 0, right = 0;
        int maxLen = 0, curLen = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (left < N && right < N) {
            if (count[arr[right]] + 1 > K) {
                count[arr[left++]]--;
                curLen--;
            } else {
                count[arr[right++]]++;
                curLen++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        bw.write(String.valueOf(maxLen));

        br.close();
        bw.close();
    }
}