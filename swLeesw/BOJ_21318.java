import java.io.*;
import java.util.*;

public class BOJ_21318 {

    static int n, q; //n : 악보의 개수, q : 질문의 개수
    static int arr[]; //악보의 난이도(최대 10억)
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getnujeock();

        q = Integer.parseInt(br.readLine());


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(x, y) + "\n");

        }


        System.out.println(sb.toString());

    }

    static int solve(int sIdx, int eIdx) {
        return dp[eIdx] - dp[sIdx];
    }

    static void getnujeock() {
        // i > i + 1이면 현재 실수
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] < arr[i - 1]) {
                dp[i]++;
            }
        }
    }

}
