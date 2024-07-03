import java.io.*;
import java.util.*;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] board = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + board[i][j];
            }
        }

        long max = Long.MIN_VALUE;
        for (int c1 = 1; c1 <= M; c1++) {
            for (int c2 = c1; c2 <= M; c2++) {
                long last = 0;
                for (int r = 1; r <= N; r++) {
                    long sum = board[r][c2] - board[r][c1 - 1] - board[r - 1][c2] + board[r - 1][c1 - 1];
                    last = Math.max(last + sum, sum);
                    max = Math.max(max, last);
                }
            }
        }
        System.out.println(max);
    }
}