import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C, N;
    static Deque<Point> deque;
    static char[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void explode() {
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            map[cur.x][cur.y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || map[nx][ny] == '.') {
                    continue;
                }
                map[nx][ny] = '.';
            }
        }
    }

    static void findBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    deque.add(new Point(i, j));
                }
            }
        }
    }

    static void installBomb() {
        for (char[] row : map) {
            Arrays.fill(row, 'O');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int time = 1;
        while (time++ <= N) {
            if (time % 2 == 1) {
                findBomb();
                installBomb();
            } else {
                explode();
            }
        }

        for (char[] row : map) {
            for (char ch : row) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
