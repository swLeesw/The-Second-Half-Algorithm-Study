import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int H, W;
    private static int[] arr;

    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        calculate();

        printAnswer();
    }

    private static void calculate() {
        for (int i = 1; i < W - 1; i++) {
            calculate(i);
        }
    }

    private static void calculate(int index) {
        int left = Arrays.stream(arr, 0, index)
                .max()
                .getAsInt();

        int right = Arrays.stream(arr, index + 1, W)
                .max()
                .getAsInt();

        if (arr[index] < left && arr[index] < right) {
            answer += (Math.min(left, right) - arr[index]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}

