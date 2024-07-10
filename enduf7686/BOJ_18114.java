import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18114 {

    private static int N, C;
    private static int[] goods;

    private static boolean answer;

    public static void main(String[] args) throws IOException {
        init();

        check();

        printAnswer();
    }

    private static void check() {
        for (int i = 0; i < N; i++) {
            if (goods[i] == C) {
                answer = true;
                return;
            }
        }

        combination(new int[2], 0, 0);
    }

    private static void combination(int[] comb, int start, int count) {
        if (count == 2) {
            if (comb[0] + comb[1] == C) {
                answer = true;
                return;
            }

            if (Arrays.binarySearch(goods, C - (comb[0] + comb[1])) >= 0
                    && C - (comb[0] + comb[1]) != comb[0]
                    && C - (comb[0] + comb[1]) != comb[1]) {
                answer = true;
                return;
            }

            return;
        }

        for (int i = start; i < N; i++) {
            comb[count] = goods[i];
            combination(comb, i + 1, count + 1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        goods = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            goods[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(goods);
    }

    private static void printAnswer() {
        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
