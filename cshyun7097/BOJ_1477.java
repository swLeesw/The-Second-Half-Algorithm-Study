import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] restArea = new int[N + 2];
        restArea[0] = 0;
        restArea[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                restArea[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(restArea);
        int left = 1;
        int right = L - 1;

        int res = 0;

        while (left <= right) {
            int dist = (left + right) / 2;
            int cnt = count(dist, restArea);
            if (cnt > M) {
                left = dist + 1;
            } else {
                right = dist - 1;
                res = dist;
            }
        }
        System.out.println(res);
    }

    private static int count(int dist, int[] restArea) {
        int cnt = 0;
        for (int i = 0; i <= restArea.length - 2; i++) {
            int tmp = restArea[i + 1] - restArea[i];
            cnt += (tmp) / dist;

            if (tmp % dist == 0) {
                cnt--;
            }
        }
        return cnt;
    }
}
