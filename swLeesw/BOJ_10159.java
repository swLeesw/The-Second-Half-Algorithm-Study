import java.io.*;
import java.util.*;

public class BOJ_10159 {

    static int n, m, grid[];
    static List<Integer> graph[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        grid = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(n - (grid[i]));
        }

    }

    static void bfs(int start) {
        int cnt =  0;
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    grid[next]++;
                    visited[next] = true;
                }
            }

        }

        grid[start] += cnt;
    }

}



