import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_101159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int compare = Integer.parseInt(st.nextToken());
            map[cur][compare] = 1;
            map[compare][cur] = -1;

        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][k]==1&&map[k][j]==1){
                        map[i][j] = 1;
                    }
                    if(map[i][k]==-1&&map[k][j]==-1){
                        map[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <=N ; j++) {
                if(map[i][j]==0) count++;
            }
            System.out.println(count-1);
        }
    }
}
