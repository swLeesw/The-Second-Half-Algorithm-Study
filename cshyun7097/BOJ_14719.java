import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    static int H, W;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 1; i < W - 1; i++) {
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                l = Math.max(map[j], l);
            }

            for (int j = i + 1; j < W; j++) {
                r = Math.max(map[j], r);
            }

            if (map[i] < l && map[i] < r) res += Math.min(l, r) - map[i];
        }
        System.out.println(res);
    }
}
