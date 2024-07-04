import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이 / 60분
public class BOJ_1600 {
	static StringBuilder sb = new StringBuilder();
	static int K, W, H, minDist, map[][];
	
	static class Pos {
		int r, c, moveCnt;

		public Pos(int r, int c, int breakCnt) {
			this.r = r;
			this.c = c;
			this.moveCnt = breakCnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken()); // 맵의 크기
		
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minDist = -1;
		
		solve();
	}
	
	private static void solve() throws Exception {
		bfs(new Pos(0, 0, 0));
		sb.append(minDist);
	}
	
	private static void bfs(Pos start) {
		int deltas[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}},
			deltasHorse[][] = {
					{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, // 체스 말
					{1, -2}, {1, 2}, {2, -1}, {2, 1}
			};
		int visited[][][] = new int[K+1][H][W];
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.moveCnt][start.r][start.c] = 1;
		
		int dist = 0; // 시작지점부터 끝지점까지의 거리
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos cur = q.poll();
				if (cur.r == H-1 && cur.c == W-1) {
					minDist = dist; // 도달하면 가능
                    return;
				}
				
				if (cur.moveCnt < K) { // 말처럼 이동하기
					for (int d = 0; d < deltasHorse.length; d++) {
						int nr = cur.r + deltasHorse[d][0];
						int nc = cur.c + deltasHorse[d][1];
						
						if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
						if (visited[cur.moveCnt+1][nr][nc] != 0) continue;
						if (map[nr][nc] == 1) continue;
						visited[cur.moveCnt+1][nr][nc] = dist; 
						q.offer(new Pos(nr, nc, cur.moveCnt+1)); 
					}
				}
				// 그냥 넘어가기
				for (int d = 0; d < deltas.length; d++) {
					int nr = cur.r + deltas[d][0];
					int nc = cur.c + deltas[d][1];
					
					if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if (visited[cur.moveCnt][nr][nc] != 0) continue;
					if (map[nr][nc] == 1) continue;
					visited[cur.moveCnt][nr][nc] = dist; 
					q.offer(new Pos(nr, nc, cur.moveCnt)); 
				}
			}
			dist++;
		}
	}
}
