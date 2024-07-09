import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int N, M, numbers[], chickenCnt;
    static int sum = Integer.MAX_VALUE;
    static List<chicken> chickens = new ArrayList<chicken>();
    static List<home> homes = new ArrayList<>();

    static class chicken {
        int x, y;

        public chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //거리구하기
        int getDistance(int x, int y) {
            return Math.abs(x - this.x) + Math.abs(y - this.y);
        }
    }

    static class home {
        int x, y;

        public home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    chickenCnt++;
                    chickens.add(new chicken(i, j));
                } else if (tmp == 1) {
                    homes.add(new home(i, j));
                }
            }
        }

        numbers = new int[M];
        comb(0, 0);
        System.out.println(sum);
    }

    private static void comb(int start, int cnt) {
        int chickenDistance = 0;
        if (cnt == M) {
            for (int home = 0; home < homes.size(); home++) {
                int distance = Integer.MAX_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    distance = Math.min(distance, chickens.get(numbers[i]).getDistance(homes.get(home).x, homes.get(home).y));
                }
                chickenDistance += distance;
            }
            sum = Math.min(sum, chickenDistance);
            return;
        }
        for (int i = start; i < chickenCnt; i++) {
            numbers[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }
}
