import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블로그 / 20분
public class BOJ_21921 {
    static int X, N, list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0, sum = 0, count = 1;
        for (int i = 0; i < X; i++) {
            sum += list[i];
        }
        max = sum;

        for (int i = X; i < N; i++) {
            sum -= list[i-X];
            sum += list[i];
            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}