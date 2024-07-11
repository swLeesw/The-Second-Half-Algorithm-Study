import java.io.*;
import java.util.*;

public class BOJ_5567 {
    static List<Integer>[] list;
    static boolean[] visited;

    private static void helper(int cur, int depth) {
        if (depth == 2) {
            return;
        }
        for (int next : list[cur]) {
            visited[next] = true;
            helper(next, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        visited[1] = true;
        helper(1, 0);

        int answer = -1;
        for (boolean vis : visited) {
            if (vis) answer++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
