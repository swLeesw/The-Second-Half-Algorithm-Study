import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18513 {
    static int N, K;
    static int[] map;
    static Queue<Node> queue;
    static HashSet<Integer> visited;
    static long res = 0;
    static int[] dx = {-1, 1};

    static class Node {
        int x;
        int cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new HashSet<>();
        
        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            queue.offer(new Node(map[i], 0)); 
            visited.add(map[i]);
        }
        bfs();
        System.out.println(res);
    }

    public static void bfs() {
        int cnt2 = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int cnt = cur.cnt;
            res += cnt;

            for (int dir = 0; dir < 2; dir++) {
                int nx = x + dx[dir];
                if (visited.contains(nx)) continue;
                if (cnt2 >= K) continue;
                visited.add(nx);
                queue.offer(new Node(nx, cnt + 1));
                cnt2++;
            }
        }
    }
}
