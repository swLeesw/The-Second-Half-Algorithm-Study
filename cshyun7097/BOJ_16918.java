import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int R, C, N;
    static int[][] bomb;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'O') {
                    bomb[i][j] = 3;
                }
            }
        }
        int time = 0;
        while (time++ < N) {
            if (time % 2 == 0) {
                putBomb(time);
            } else {
                bombBomb(time);
            }
        }
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

    }

    private static void bombBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == time) {
                    map[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (isOut(ni, nj)) continue;
                        if (map[ni][nj] == 'O' && bomb[ni][nj] != time) {
                            map[ni][nj] = '.';
                            bomb[ni][nj] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void putBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bomb[i][j] = time + 3;
                }
            }
        }
    }

    private static boolean isOut(int ni, int nj) {
        return ni < 0 || nj < 0 || ni >= R || nj >= C;
    }
}