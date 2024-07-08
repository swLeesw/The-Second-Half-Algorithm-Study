import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_9079 {

    private static int T;
    private static String[][][] testCases;

    public static void main(String[] args) throws IOException {
        init();

        for (int t = 0; t < T; t++) {
            System.out.println(bfs(testCases[t]));
        }
    }

    private static int bfs(String[][] coins) {
        int result = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[512];

        int start = convertCoinMap(coins);

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == 0 || current == 511) {
                    return result;
                }

                for (int next : flip(current)) {
                    if (visited[next]) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                }
            }

            result++;
        }

        return -1;
    }

    private static List<Integer> flip(int current) {
        List<Integer> list = new ArrayList<>();

        String binaryString = String.format("%9s", Integer.toBinaryString(current)).replace(' ', '0');
        String[][] coins = makeCoinMap(binaryString);

        for (int y = 0; y < 3; y++) {
            String[][] temp = clone(coins);

            for (int x = 0; x < 3; x++) {
                temp[y][x] = temp[y][x].equals("1") ? "0" : "1";
            }

            list.add(convertCoinMap(temp));
        }

        for (int x = 0; x < 3; x++) {
            String[][] temp = clone(coins);

            for (int y = 0; y < 3; y++) {
                temp[y][x] = temp[y][x].equals("1") ? "0" : "1";
            }

            list.add(convertCoinMap(temp));
        }

        String[][] temp = clone(coins);
        temp[0][0] = temp[0][0].equals("1") ? "0" : "1";
        temp[1][1] = temp[1][1].equals("1") ? "0" : "1";
        temp[2][2] = temp[2][2].equals("1") ? "0" : "1";
        list.add(convertCoinMap(temp));

        String[][] temp2 = clone(coins);
        temp2[0][2] = temp2[0][2].equals("1") ? "0" : "1";
        temp2[1][1] = temp2[1][1].equals("1") ? "0" : "1";
        temp2[2][0] = temp2[2][0].equals("1") ? "0" : "1";
        list.add(convertCoinMap(temp2));

        return list;
    }

    private static String[][] makeCoinMap(String binaryString) {
        String[][] coins = new String[3][3];

        int index = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                coins[y][x] = String.valueOf(binaryString.charAt(index));
                index++;
            }
        }

        return coins;
    }

    private static String[][] clone(String[][] coins) {
        String[][] temp = new String[3][3];

        for (int i = 0; i < 3; i++) {
            temp[i] = coins[i].clone();
        }

        return temp;
    }

    private static int convertCoinMap(String[][] coins) {
        return Integer.parseInt(
                Arrays.stream(coins)
                        .flatMap(Arrays::stream)
                        .collect(Collectors.joining()), 2
        );
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        testCases = new String[T][3][3];

        for (int t = 0; t < T; t++) {
            for (int y = 0; y < 3; y++) {
                st = new StringTokenizer(br.readLine());

                for (int x = 0; x < 3; x++) {
                    testCases[t][y][x] = st.nextToken().equals("H") ? "1" : "0";
                }
            }
        }
    }
}
