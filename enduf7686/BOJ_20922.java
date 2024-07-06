import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {

    private static int N, K;
    private static int[] arr;

    private static int[] count;
    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        twoPointer();

        printAnswer();
    }

    private static void twoPointer() {
        int start = 0;
        int end = 0;

        count[arr[start]]++;
        answer = 1;

        while (end != N - 1) {
            if (count[arr[end]] > K) {
                count[arr[start++]]--;
            } else {
                count[arr[++end]]++;
                answer = Math.max(answer, end - start + (count[arr[end]] > K ? 0 : 1));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = new int[100001];
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
