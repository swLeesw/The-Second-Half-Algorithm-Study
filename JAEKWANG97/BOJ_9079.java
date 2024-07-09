import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N;
    private static String[][] arr;
    private static int minCount;
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        initVar();
        for (int i = 0; i < N; i++) {
            initArr();
            bfs();
            System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
        }
    }

    private static void initVar() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void initArr() throws IOException {
        arr = new String[3][3];
        minCount = Integer.MAX_VALUE;
        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = st.nextToken();
            }
        }
    }

    private static void bfs() {
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(arr, 0));
        set.add(arrayToString(arr));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            String[][] cur = state.board;
            int count = state.count;

            if (confirm(cur)) {
                minCount = Math.min(minCount, count);
                continue;
            }

            for (int j = 0; j < 3; j++) {
                flipRow(cur, j);
                addQueue(queue, cur, count + 1);
                flipRow(cur, j);

                flipCol(cur, j);
                addQueue(queue, cur, count + 1);
                flipCol(cur, j);
            }

            flipDiagonalLeftToRight(cur);
            addQueue(queue, cur, count + 1);
            flipDiagonalLeftToRight(cur);

            flipDiagonalRightToLeft(cur);
            addQueue(queue, cur, count + 1);
            flipDiagonalRightToLeft(cur);
        }
    }

    private static void addQueue(Queue<State> queue, String[][] tmp, int count) {
        String key = arrayToString(tmp);
        if (!set.contains(key)) {
            queue.add(new State(deepCopy(tmp), count));
            set.add(key);
        }
    }

    private static void flipRow(String[][] tmp, int row) {
        for (int i = 0; i < 3; i++) {
            tmp[row][i] = tmp[row][i].equals("H") ? "T" : "H";
        }
    }

    private static void flipCol(String[][] tmp, int col) {
        for (int i = 0; i < 3; i++) {
            tmp[i][col] = tmp[i][col].equals("H") ? "T" : "H";
        }
    }

    private static void flipDiagonalLeftToRight(String[][] tmp) {
        for (int i = 0; i < 3; i++) {
            tmp[i][i] = tmp[i][i].equals("H") ? "T" : "H";
        }
    }

    private static void flipDiagonalRightToLeft(String[][] tmp) {
        for (int i = 0; i < 3; i++) {
            tmp[i][2 - i] = tmp[i][2 - i].equals("H") ? "T" : "H";
        }
    }

    private static boolean confirm(String[][] tmp) {
        String target = tmp[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!tmp[i][j].equals(target)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String arrayToString(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : arr) {
            for (String cell : row) {
                sb.append(cell);
            }
        }
        return sb.toString();
    }

    private static String[][] deepCopy(String[][] original) {
        String[][] copy = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, 3);
        }
        return copy;
    }

    static class State {
        String[][] board;
        int count;

        State(String[][] board, int count) {
            this.board = board;
            this.count = count;
        }
    }
}
