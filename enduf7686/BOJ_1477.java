import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477 {

    private static int N, M, L;
    private static int[] locations;

    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        binarySearch();

        printAnswer();
    }

    private static void binarySearch() {
        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int dist = (left + right) / 2;
            int count = countRest(dist);

            if (count > M) {
                left = dist + 1;
            } else {
                right = dist - 1;
                answer = dist;
            }
        }
    }

    private static int countRest(int dist) {
        int count = 0;

        for (int i = 0; i <= N; i++) {
            int temp = locations[i + 1] - locations[i];

            count += temp / dist;

            if (temp % dist == 0) {
                count--;
            }
        }

        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        locations = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }
        locations[0] = 0;
        locations[N + 1] = L;

        Arrays.sort(locations);
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
