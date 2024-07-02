import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {

    private static int N, M;
    private static int[][] matrix;
    private static int[][] sum;

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        makePrefixSumArray();

        findMinimumValue();

        printAnswer();
    }

    private static void makePrefixSumArray() {
        int[][] temp = new int[N][M];

        for (int x = 0; x < M; x++) {
            temp[0][x] = matrix[0][x];
        }

        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                temp[y][x] = temp[y - 1][x] + matrix[y][x];
            }
        }

        sum = new int[N][M];

        for (int y = 0; y < N; y++) {
            sum[y][0] = temp[y][0];
        }

        for (int y = 0; y < N; y++) {
            for (int x = 1; x < M; x++) {
                sum[y][x] = sum[y][x - 1] + temp[y][x];
            }
        }
    }

    private static void findMinimumValue() {
        for (int startY = 0; startY < N; startY++) {
            for (int startX = 0; startX < M; startX++) {

                for (int endY = startY; endY < N; endY++) {
                    for (int endX = startX; endX < M; endX++) {
                        answer = Math.max(answer, calculateSubMatrixSum(startY, startX, endY, endX));
                    }
                }
            }
        }
    }

    private static int calculateSubMatrixSum(int startY, int startX, int endY, int endX) {
        if (startY == 0 && startX == 0) {
            return sum[endY][endX];
        }

        if (startY == 0) {
            return sum[endY][endX] - sum[endY][startX - 1];
        }

        if (startX == 0) {
            return sum[endY][endX] - sum[startY - 1][endX];
        }

        return sum[endY][endX] - sum[endY][startX - 1] - sum[startY - 1][endX] + sum[startY - 1][startX - 1];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
