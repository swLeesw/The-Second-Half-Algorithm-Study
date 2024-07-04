import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            map[first][next] = 1;
            map[next][first] = -1;
        }
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][m]==1&&map[m][j]==1){
                        map[i][j] = 1;
                    }
                    if(map[i][m]==-1&&map[m][j]==-1){
                        map[i][j] = -1;
                    }
                }
            }
        }
        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < s; q++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(map[num1][num2]==1){
                sb.append(-1).append("\n");
            }else if(map[num1][num2]==-1){
                sb.append(1).append("\n");
            }else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
