import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {

    private static int N, X;
    private static int[] visitors;

    private static int answer;
    private static int count;

    public static void main(String[] args) throws IOException {
        init();

        slidingWindow();

        slidingWindow2();

        printAnswer();
    }

    private static void slidingWindow() {
        int window = 0;

        for (int i = 0; i < X; i++) {
            window += visitors[i];
        }
        answer = Math.max(answer, window);

        if (visitors.length == 1) {
            return;
        }

        for (int i = 1; i <= N - X; i++) {
            window += (visitors[i + X - 1] - visitors[i - 1]);
            answer = Math.max(answer, window);
        }
    }

    private static void slidingWindow2() {
        int window = 0;

        for (int i = 0; i < X; i++) {
            window += visitors[i];
        }

        if (answer == window) {
            count++;
        }

        if (visitors.length == 1) {
            return;
        }

        for (int i = 1; i <= N - X; i++) {
            window += (visitors[i + X - 1] - visitors[i - 1]);
            if (answer == window) {
                count++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void printAnswer() {
        if (answer == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(answer);
        System.out.println(count);
    }
}
