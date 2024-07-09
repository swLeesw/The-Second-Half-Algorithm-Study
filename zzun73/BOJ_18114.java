import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C, answer;
    static int[] arr;

    static void helper() {
        if (answer == 1) {
            return;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == C) {
                answer = 1;
                return;
            } else if (sum < C) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int sum = arr[i] + arr[j];
                if (sum >= C) {
                    break;
                }
                int target = C - sum;
                if (Arrays.binarySearch(arr, j + 1, N, target) >= 0) {
                    answer = 1;
                    return;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int W = Integer.parseInt(st.nextToken());
            arr[i] = W;
            if (W == C) {
                answer = 1;
            }
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}