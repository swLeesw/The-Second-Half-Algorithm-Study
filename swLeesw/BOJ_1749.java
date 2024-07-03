import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {

    static int n, m, sol;
    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sol = Integer.MIN_VALUE;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sol = Math.max(sol, arr[i][j]);
            }
        }

        makeComSum();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                solve(i, j);
            }
        }

        System.out.println(sol);
    }

    static void solve(int y, int x) {
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                sol = Math.max(sol, dp[y][x] - dp[i - 1][x] - dp[y][j - 1] + dp[i - 1][j - 1]);
            }
        }


    }

    static void makeComSum() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1];
            }
        }

    }

}
