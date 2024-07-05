package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    private static class Node {
        int x;
        int y;
        int count;
        int k;

        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    private static int k, w, h, result = -1;
    private static int[][] arr;
    private static boolean[][][] visited;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    private static int[] hx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    private static int[] hy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        System.out.println(result);
    }// main end

    private static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.x == h - 1 && now.y == w - 1) {
                result = now.count;
                return;
            }

            if (!check(now.x, now.y))
                continue;
            if (visited[now.x][now.y][now.k])
                continue;
            if (arr[now.x][now.y] == 1)
                continue;

            visited[now.x][now.y][now.k] = true;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                que.offer(new Node(nx, ny, now.count + 1, now.k));
            }

            if (now.k == k) {
                continue;
            }

            for (int d = 0; d < 8; d++) {
                int nx = now.x + hx[d];
                int ny = now.y + hy[d];

                que.offer(new Node(nx, ny, now.count + 1, now.k + 1));
            }
        }
    }// bfs end

    private static boolean check(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }// return end
}// class end

