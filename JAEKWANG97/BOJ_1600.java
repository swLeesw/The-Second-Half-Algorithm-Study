import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] deltaX = new int[] { 0, 1, 0, -1 };
	static int[] deltaY = new int[] { -1, 0, 1, 0 };

	static int[] jumpX = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] jumpY = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int minValue = Integer.MAX_VALUE;

	static class Monkey {
		int x;
		int y;
		int k;
		int value;

		public Monkey(int x, int y, int k, int value) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				int item = Integer.parseInt(st.nextToken());
				map[i][j] = item;
			}
		}

		bfs(k, map, H, W);

		System.out.println(minValue != Integer.MAX_VALUE ? minValue : -1);

	}

	private static void bfs(int k, int[][] map, int H, int W) {

		Queue<Monkey> queue = new ArrayDeque<>();
		// 첫번째 원숭이는 항상 0,0
		queue.offer(new Monkey(0, 0, k, 0));
		boolean[][][] visited = new boolean[k + 1][H][W];
		visited[k][0][0] = true;

		// 방문 배열은 필요없음

		while (!queue.isEmpty()) {
			Monkey cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curK = cur.k;
			int curV = cur.value;

			if (curV > minValue) {
				continue;
			}

			if (curX == H - 1 && curY == W - 1) {
				minValue = Math.min(minValue, curV);
				return;
			}

			// 인접한 곳으로 이동
			for (int i = 0; i < 4; i++) {
				int nx = curX + deltaX[i];
				int ny = curY + deltaY[i];
				if (isIn(nx, ny, H, W) && !visited[curK][nx][ny] && map[nx][ny] == 0) {
					queue.offer(new Monkey(nx, ny, curK, curV + 1));
					visited[curK][nx][ny] = true;
				}
			}

			// 점프
			if (curK > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = curX + jumpX[i];
					int ny = curY + jumpY[i];
					if (isIn(nx, ny, H, W) && !visited[curK - 1][nx][ny] && map[nx][ny] == 0) {
						queue.offer(new Monkey(nx, ny, curK - 1, curV + 1));
						visited[curK-1][nx][ny] = true;
					}
				}
			}

		}

	}

	private static boolean isIn(int x, int y, int H, int W) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

}
