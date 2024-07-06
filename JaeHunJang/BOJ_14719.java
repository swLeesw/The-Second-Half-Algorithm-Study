import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물 / 90분
public class BOJ_14719 {
    static int H, W, walls[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        walls = new int[W];
        for (int i = 0; i < W; i++) {
            walls[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 1; i < W-1; i++) {
            int start = 0, end = 0;

            for (int j = 0; j < i; j++) {
                start = Math.max(walls[j], start);
            }
            for (int j = i+1; j < W; j++) {
                end = Math.max(walls[j], end);
            }
            if (walls[i] < start && walls[i] < end) {
                sum += Math.min(start,end) - walls[i];
            }
        }

        System.out.println(sum);
    }

}