import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 저울 / 90분
public class BOJ_10159 {
    static int N, M, map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N +1][N +1];

        int from, to;
        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (map[i][j] == 0 && map[j][i] == 0) count++;
            }
            System.out.println(count);
        }
    }
}