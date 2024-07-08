import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 3;
    private static final int[][] DIRECTION = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    static int helper(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(Arrays.toString(start));

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentShape = queue.poll();

                if (isAllSame(currentShape)) {
                    return count;
                }

                for (int[] dir : DIRECTION) {
                    int[] nextShape = currentShape.clone();
                    for (int idx : dir) {
                        nextShape[idx] = 1 - nextShape[idx];
                    }

                    String nextState = Arrays.toString(nextShape);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.add(nextShape);
                    }
                }
            }

            count++;
        }

        return -1;
    }

    static boolean isAllSame(int[] board) {
        int shape = board[0];
        for (int val : board) {
            if (shape != val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] board = new int[SIZE * 3];
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < SIZE; j++) {
                    board[i * SIZE + j] = st.nextToken().charAt(0) == 'H' ? 1 : 0;
                }
            }

            sb.append(helper(board)).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
