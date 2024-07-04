import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 역사 / 90분
public class BOJ_1613 {
    static int N, K, S, map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N +1][N +1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], 20000000);
            map[i][i] = 0;
        }

        int from, to;
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            map[from][to] = -1;
            map[to][from] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                    else if (map[i][k] == -1 && map[k][j] == -1) map[i][j] = -1;
                }
            }
        }

        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (map[from][to] != 20000000) answer = map[from][to];
            System.out.println(answer);
        }

    }

    static void printArr() {
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}