import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1}, hy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int K, W, H;
    static int[][] map;

    static class XY {
        int x, y, cnt;

        public XY(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<XY> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[K + 1][H][W];
        visited[0][0][0] = true;
        queue.offer(new XY(0, 0, 0));
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while (size-- > 0) {
                XY cur = queue.poll();
                int curX = cur.x;
                int curY = cur.y;
                int curCnt = cur.cnt;

                if (curX == H - 1 && curY == W - 1) {
                    System.out.println(time - 1);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];
                    if (!isIn(nx, ny) || visited[curCnt][nx][ny] || map[nx][ny] == 1) continue;
                    visited[curCnt][nx][ny] = true;
                    queue.offer(new XY(nx, ny, curCnt));
                }

                if (curCnt == K) continue;

                for (int d = 0; d < 8; d++) {
                    int nx = curX + hx[d];
                    int ny = curY + hy[d];
                    if (!isIn(nx, ny) || visited[curCnt + 1][nx][ny] || map[nx][ny] == 1) continue;
                    visited[curCnt + 1][nx][ny] = true;
                    queue.offer(new XY(nx, ny, curCnt + 1));
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
