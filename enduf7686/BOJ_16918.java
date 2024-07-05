import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
    
    private static int r, c, n;
    private static char[][] map;
    private static Queue<Location> q = new LinkedList<>();

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                for (int k = 0; k < r; k++) {
                    for (int j = 0; j < c; j++) {
                        if (map[k][j] == 'O') {
                            q.add(new Location(k, j));
                        }
                    }
                }

                for (char[] m : map) {
                    Arrays.fill(m, 'O');
                }

                bfs();
            }

        }


        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Location location = q.poll();
            int x = location.getX();
            int y = location.getY();
            map[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }

    private static void printAnswer() {
        if (n % 2 == 0) {
            for (char[] m : map) {
                Arrays.fill(m, 'O');
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static class Location {

        private int y;
        private int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
