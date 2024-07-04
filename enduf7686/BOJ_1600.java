import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int K;
    private static int W;
    private static int H;

    private static int[][] map;
    private static boolean[][][] visited;

    private static int[] dy = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dx = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        init();
        bfs();

        for (int k = 0; k <= K; k++) {
            if (visited[H - 1][W - 1][k]) {
                System.out.println(map[H - 1][W - 1]);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(0, 0, 0));
        Arrays.fill(visited[0][0], true);
        map[0][0] = 0;

        while(!queue.isEmpty()) {
            Location location = queue.poll();

            int y = location.getY();
            int x = location.getX();
            int horseMoveCount = location.getHorseMoveCount();

            for (int i = 0; i < 4; i++) {
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Y < 0 || Y >= H || X < 0 || X >= W || visited[Y][X][horseMoveCount] || map[Y][X] == -1) {
                    continue;
                }

                queue.offer(new Location(Y, X, horseMoveCount));
                visited[Y][X][horseMoveCount] = true;
                map[Y][X] = map[y][x] + 1;

                if (Y == H - 1 && X == W - 1) {
                    return;
                }
            }

            if (horseMoveCount < K) {
                for (int i = 4; i < 12; i++) {
                    int Y = y + dy[i];
                    int X = x + dx[i];

                    if (Y < 0 || Y >= H || X < 0 || X >= W || visited[Y][X][horseMoveCount + 1] || map[Y][X] == -1) {
                        continue;
                    }

                    queue.offer(new Location(Y, X, horseMoveCount + 1));
                    visited[Y][X][horseMoveCount + 1] = true;
                    map[Y][X] = map[y][x] + 1;

                    if (Y == H - 1 && X == W - 1) {
                        return;
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int y = 0; y < H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < W; x++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1) {
                    map[y][x] = -1;
                } else {
                    map[y][x] = 0;
                }
            }
        }

        visited = new boolean[H][W][K + 1];
    }

    private static class Location {

        private int y;
        private int x;
        private int horseMoveCount;

        public Location(int y, int x, int horseMoveCount) {
            this.y = y;
            this.x = x;
            this.horseMoveCount = horseMoveCount;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getHorseMoveCount() {
            return horseMoveCount;
        }
    }
}

