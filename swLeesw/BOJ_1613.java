import java.util.*;
import java.io.*;

public class BOJ_1613 {
    static int n, k, s;
    //선후 관계 그래프 u -> v : v가 먼저 일어난 사건
    static List<Integer> graph[];
    //방문 체크 배열
    static boolean visited[];
    //map[a][b] : a가 일어난 후 b가 일남(순서 x )
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //1 2 : 1번이 먼저 일어난 사건
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            //back --> front :
            graph[back].add(front);
        }

        for (int i = 1; i <= n; i++) {
            initRelation(i);
        }

        s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            sb.append(solve(front, back)).append("\n");
        }
        System.out.println(sb);
    }

    static void initRelation(int start) {
        visited = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                    map[next][start] = 1;
                }
            }

        }
    }

    //n <= 400, k <= 50000, s <= 50000
    static int solve(int front, int back) {
        if (map[front][back] == 1) {
            return -1;
        } else if (map[back][front] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
