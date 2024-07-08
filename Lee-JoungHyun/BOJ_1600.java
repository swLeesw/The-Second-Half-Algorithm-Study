import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

    static int mx[] = new int[]{0, 1, 0, -1};
    static int my[] = new int[]{1, 0, -1, 0};
    static int hx[] = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    static int hy[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
        boolean[][][] visited = new boolean[K+1][Y][X];
        int[][] map = new int[Y][X];
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        if (X == 1 && Y == 1) {
            System.out.println(0);
            return;
        }
        visited[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        // hcnt, y, x
        queue.add(new int[]{0, 0, 0});
        int action = 1;
        int now[], nx, ny, nh;
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            while (qsize-- > 0) {
                now = queue.poll();
                // 1. 원숭이 move
                for (int d = 0; d < 4; d++) {
                    nh = now[0]; ny = now[1] + my[d]; nx = now[2] + mx[d];
                    if (isIn(nh, ny, nx, Y, X, map, visited)) {
                        // 도착 체크
                        if (ny == Y-1 && nx == X-1) {
                            System.out.println(action);
                            return;
                        }
                        visited[nh][ny][nx] = true;
                        queue.add(new int[]{nh, ny, nx});
                    }
                }
                // 2. 말 move
                for (int d = 0; d < 8; d++) {
                    nh = now[0]+1; ny = now[1] + hy[d]; nx = now[2] + hx[d];
                    if (nh > K) break;
                    if (isIn(nh, ny, nx, Y, X, map, visited)) {
                        // 도착 체크
                        if (ny == Y-1 && nx == X-1) {
                            System.out.println(action);
                            return;
                        }
                        visited[nh][ny][nx] = true;
                        queue.add(new int[]{nh, ny, nx});
                    }
                }
            }
            action++;
        }
        System.out.println(-1);
    }

    static boolean isIn(int hcnt, int y, int x, int Y, int X, int[][] map, boolean[][][] visited) {
        if (0 <= y && y < Y && 0 <= x && x < X && map[y][x] == 0 && !visited[hcnt][y][x])
            return true;
        return false;
    }
}
