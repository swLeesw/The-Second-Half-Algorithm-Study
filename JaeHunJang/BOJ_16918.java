import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 봄버맨 / 30분
public class BOJ_16918 {
	static StringBuilder sb = new StringBuilder();
	static int R, C, N, map[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Pos> q;
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			int j = 0;
			for (char ch : br.readLine().toCharArray()) {
				if (ch == '.') {
					map[i][j] = 9; // 빈칸
				} else {
					map[i][j] = 3; // 폭탄
				}
				j++;
			}
		}

		for (int i = 1; i <= N; i++) {
			checkTimer();
			bomb();
			if (i % 2 == 0) {
				plant();
			}
		}
		print();
	}

	static void checkTimer() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 9 && map[i][j] > 0) {
					map[i][j]--;
				}
				if (map[i][j] == 0) q.offer(new Pos(i, j));
			}
		}
	}

	static void bomb() {
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = deltas[d][0] + now.r;
				int nc = deltas[d][1] + now.c;
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				map[nr][nc] = 9;
			}
			map[now.r][now.c] = 9;
		}
	}

	static void plant() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 9) map[i][j] = 3;
			}
		}
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] == 9 ? '.' : 'O');
			}
			System.out.println();
		}
	}

	static void printArr() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
