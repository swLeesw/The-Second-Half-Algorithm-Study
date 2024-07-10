import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 결혼식 / 20분
public class BOJ_5567 {
    static int n, m;
    static List<Integer> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new List[n+1];
        int from, to;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if (list[from] == null) list[from] = new ArrayList<>();
            list[from].add(to);
            if (list[to] == null) list[to] = new ArrayList<>();
            list[to].add(from);
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean visited[] = new boolean[m+1];
        visited[1] = true;

        int cnt = 0, count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (list[now] == null) continue;
                for (int next : list[now]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
            if (cnt == 2) {
                break;
            }
        }
        System.out.println(count);
    }
}