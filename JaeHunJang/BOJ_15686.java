import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 치킨 배달 / 40분
public class BOJ_15686 {
    static int N, M, min, map[][], selected[];
    static Pos[] store, home;
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int r, c, dist;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
            dist = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selected = new int[M];
        min = Integer.MAX_VALUE;

        int hcnt = 0, scnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) hcnt++;
                if (map[i][j] == 2) scnt++;
            }
        }

        store = new Pos[scnt];
        home = new Pos[hcnt];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) home[--hcnt] = new Pos(i, j);
                if (map[i][j] == 2) store[--scnt] = new Pos(i, j);
            }
        }

        combi(0, 0);
        System.out.println(min);
    }

    static void combi(int cnt, int start) {
        if (cnt == M) {
            sumChickenLoad();
            return;
        }

        for (int i = start; i < store.length; i++) {
            selected[cnt] = i;
            combi(cnt+1, i+1);
        }
    }

    static void sumChickenLoad() {
        int totalDist = 0;
        for (int i = 0; i < home.length; i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < selected.length; j++) {
                minDist = Math.min(minDist, calcDistance(home[i], store[selected[j]]));
            }
            totalDist += minDist;
        }
        min = Math.min(min, totalDist);
    }

    static int calcDistance(Pos a, Pos b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
}