import java.io.*;
import java.util.*;

public class BOJ_1600 {
    static class Point {
        int x, y, distance, countK;

        public Point(int x, int y, int distance, int countK) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.countK = countK;
        }
    }

    static int K, W, H, answer;
    static int[][] map;
    static boolean[][][] visited;
    static Deque<Point> deque;
    static int[] hx = new int[]{-1, -2, 1, 2, -2, -1, 1, 2};
    static int[] hy = new int[]{-2, -1, -2, -1, 1, 2, 2, 1};
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};


    static void helper() {
        deque.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.distance;
            int k = cur.countK;

            if (x == H - 1 && y == W - 1) {
                answer = d;
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[k][nx][ny] || map[nx][ny] == 1) {
                    continue;
                }
                visited[k][nx][ny] = true;
                deque.add(new Point(nx, ny, d + 1, k));
            }

            if (k < K) {
                for (int i = 0; i < hx.length; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];
                    if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[k + 1][nx][ny] || map[nx][ny] == 1) {
                        continue;
                    }
                    visited[k + 1][nx][ny] = true;
                    deque.add(new Point(nx, ny, d + 1, k + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[K + 1][H][W];
        deque = new ArrayDeque<>();
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        helper();

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        br.close();
        bw.close();
    }
}