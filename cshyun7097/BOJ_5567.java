import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567 {
    static List<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        visited[1] = true;
        dfs(1, 0);

        int ans = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int start, int depth) {
        if (depth == 2) {
            return;
        }
        for (int i = 0; i < arr[start].size(); i++) {
            int next = arr[start].get(i);
            visited[next] = true;
            dfs(next, depth + 1);
        }
    }
}
