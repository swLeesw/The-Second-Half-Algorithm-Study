
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M, Q;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    //앞의 물건이 뒤의 물건보다 더 무겁다.
    private static int[][] map;
    private static List<Node> nodelist;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        nodelist = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = -1;
            map[b][a] = 1;

        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodelist.add(new Node(a, b));
        }
    }

    private static void solve() throws IOException {
        FloydWarshall();


    }

    private static void FloydWarshall() {
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = map[i][j];
            }
        }

        // 플로이드-워셜 알고리즘 실행
        for (int k = 1; k <= N; k++) { // 각 정점을 거쳐 가는 경우를 고려
            for (int i = 1; i <= N; i++) { // 모든 출발 정점에 대해
                for (int j = 1; j <= N; j++) { // 모든 도착 정점에 대해
                    // 현재 알려진 최단 거리와 비교하여 더 짧은 경로가 있는지 확인하고 업데이트
                    if (dist[i][j] == 0 && dist[i][k] == dist[k][j]) {
                        dist[i][j] = dist[i][k];
                    }
                }
            }
        }
//
//        for(int i = 1; i <= N; i++) {
//            System.out.println(Arrays.toString(dist[i]));
//        }

        for (Node node : nodelist) {
            System.out.println(dist[node.x][node.y]);
        }

    }
}
