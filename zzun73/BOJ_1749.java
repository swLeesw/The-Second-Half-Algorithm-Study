import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + map[i][j] - sum[i - 1][j - 1];
            }
        }

        long answer = Long.MIN_VALUE;
        for (int x1 = 1; x1 <= N; x1++) {
            for (int y1 = 1; y1 <= M; y1++) {
                for (int x2 = x1; x2 <= N; x2++) {
                    for (int y2 = y1; y2 <= M; y2++) {
                        answer = Math.max(answer,
                                sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}