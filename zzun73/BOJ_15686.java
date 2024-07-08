import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static List<int[]> homes, chickens;
    static int answer;

    private static void helper(int count, int start, List<int[]> path) {
        if (count == M) {
            int sum = 0;
            for (int[] home : homes) {
                sum += calcDistance(home, path);
            }
            answer = Math.min(sum, answer);

            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            int nx = chickens.get(i)[0];
            int ny = chickens.get(i)[1];

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                path.add(new int[]{nx, ny});
                helper(count + 1, i, path);
                path.remove(path.size() - 1);
                visited[nx][ny] = false;
            }
        }

    }

    private static int calcDistance(int[] home, List<int[]> path) {
        int cur = Integer.MAX_VALUE;
        for (int[] target : path) {
            cur = Math.min(cur, Math.abs(home[0] - target[0]) + Math.abs(home[1] - target[1]));
        }
        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    homes.add(new int[]{i, j});
                } else if (val == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        answer = Integer.MAX_VALUE;
        helper(0, 0, new ArrayList<>());

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
