import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 동전 게임 / 60분
public class BOJ_9079 {
    static int minCnt, map[][];
    static int deltasR[][] = {{0,0},{0,1},{0,2}};
    static int deltasC[][] = {{0,0},{1,0},{2,0}};
    static StringBuilder sb = new StringBuilder();
    static class Game {
        int map[][], cnt;

        public Game(int[][] map, int cnt) {
            this.map = map;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            map = new int[3][3];
            minCnt = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    if (st.nextToken().equals("H")) map[j][k] = 1; // 앞면
                    else map[j][k] = 0; // 뒷면
                }
            }
            if(isPossible()) {
                bfs(copyArr(map));
            } else minCnt = -1;
            System.out.println(minCnt);
//            sb.append(minCnt).append("\n");
        }
//        System.out.println(sb.toString());
    }

    static int[][] copyArr(int[][] map) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    static void printArr(int[][] map) {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static void bfs(int map[][]) {
        Queue<Game> q = new ArrayDeque<>();
        q.offer(new Game(map, 0));

        while (!q.isEmpty()) {
            Game now = q.poll();
//            System.out.println(now.cnt);
//            printArr(now.map);
            if(isValid(now.map)) {
                minCnt = Math.min(minCnt, now.cnt);
                return;
            }

            for (int d = 0; d < deltasR.length; d++) {
                q.offer(new Game(reverse(1, d, now.map), now.cnt+1));
            }
            for (int d = 0; d < deltasC.length; d++) {
                q.offer(new Game(reverse(2, d, now.map), now.cnt+1));
            }
            for (int d = 0; d < 2; d++) {
                q.offer(new Game(reverse(3, d, now.map), now.cnt+1));
            }
        }
    }

    static boolean isPossible() {
        int cnt1=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) continue;
                if (map[i][j] == 1) cnt1++; // 중앙빼고 홀수 체크
            }
        }

        return cnt1 % 2 == 0;
    }

    static boolean isValid(int[][] map) {
        int flag = map[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (flag != map[i][j]) return false;
            }
        }
        return true;
    }

    static int[][] reverse(int type, int position, int[][] copy) {
        int[][] map = copyArr(copy);
        if (type == 1) { // 가로
            int nr = deltasC[position][0];
            int nc = deltasC[position][1];
            for (; nc < 3; nc++) {
                map[nr][nc] = (map[nr][nc] + 1) % 2;
            }
        }
        if (type == 2) { // 세로
            int nr = deltasR[position][0];
            int nc = deltasR[position][1];
            for (; nr < 3; nr++) {
                map[nr][nc] = (map[nr][nc] + 1) % 2;
            }
        }
        if (type == 3) { // 대각선
            int nr = 1;
            int nc = 1;
            if (position == 0) { // 좌상 우하
                map[nr][nc] = (map[nr][nc] + 1) % 2;
                map[nr-1][nc-1] = (map[nr-1][nc-1] + 1) % 2;
                map[nr+1][nc+1] = (map[nr+1][nc+1] + 1) % 2;
            }
            if (position == 1) { // 좌하 우상
                map[nr][nc] = (map[nr][nc] + 1) % 2;
                map[nr+1][nc-1] = (map[nr+1][nc-1] + 1) % 2;
                map[nr-1][nc+1] = (map[nr-1][nc+1] + 1) % 2;
            }
        }
        return map;
    }
}