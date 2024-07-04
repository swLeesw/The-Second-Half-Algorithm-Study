import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1613 {
    static int INF = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int map[][] = new int[N+1][N+1];
        for(int m[]:map) Arrays.fill(m, INF);
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = -1;
            map[b][a] = 1;
        }
        for(int k=0; k<=N; k++) {
            for(int i=0; i<=N; i++) {
                for(int j=0; j<=N; j++) {
                    if(map[i][j] == INF&&map[i][k]==map[k][j]) {
                        map[i][j] = map[i][k];
                    }
                }
            }
        }
        int S = Integer.parseInt(br.readLine());
        for(int s=0;s<S;s++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(map[a][b]);
        }
    }

}
