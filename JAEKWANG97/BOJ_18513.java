import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static List<Long> waterList;
    private static Long totalDist;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        waterList = new ArrayList<>();
        totalDist = 0L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            waterList.add(Long.parseLong(st.nextToken()));
        }
    }

    private static void solve() throws IOException {
        Queue<Long> q = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            q.add(waterList.get(i));
            visited.add(waterList.get(i));
        }

        long dist = 1L;
        int count = 0;


        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Long cur = q.poll();
                boolean left = false;
                boolean right = false;

                if (!visited.contains(cur + dist)) {
                    count++;
                    totalDist += dist;
                    visited.add(cur + dist);
                    if (confirm(count)) return;
                } else {
                    right = true;
                }

                if (!visited.contains(cur - dist)) {
                    count++;
                    totalDist += dist;
                    visited.add(cur - dist);
                    if (confirm(count)) return;
                } else {
                    left = true;
                }

                if (!left || !right) {
                    q.add(cur);
                }

            }
            dist++;
        }
        System.out.println(totalDist);
    }

    private static boolean confirm(int count) {
        if (count == K) {
            System.out.println(totalDist);
            return true;
        }
        return false;
    }

}
