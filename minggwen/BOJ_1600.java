import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

	static class Move{
		int row, col,hCnt;

		public Move(int row, int col, int hCnt) {
			this.row = row;
			this.col = col;
			this.hCnt = hCnt;
		}
	}
	static int K,W,H;
	static int min = Integer.MAX_VALUE;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] hDelta = {{-1,-2},{-2,-1},{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H][W];
		visited = new boolean[H][W][K+1];
		for(int h=0;h<H;h++) {
			st = new StringTokenizer(br.readLine());
			for(int w=0;w<W;w++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==1) map[h][w] = true;
			}
		}
		for(int k=0;k<=K;k++) {
			visited[0][0][k] = true;
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Move> que = new ArrayDeque<>();
		que.offer(new Move(0,0,0));
		int cnt = 0;
		int r = 0;
		int c = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			boolean flag = false;
			for(int i=0; i<size;i++) {
				Move tmp = que.poll();
				r = tmp.row;
				c = tmp.col;
				int hCnt = tmp.hCnt;
				if(r==H-1&&c==W-1) {
					flag = true;
					break;
				}
				for(int d=0; d<delta.length;d++) {
					int nr = r+delta[d][0];
					int nc = c+delta[d][1];
					
					if(isIn(nr,nc)&&!map[nr][nc]&&!visited[nr][nc][hCnt]) {
						que.offer(new Move(nr,nc,hCnt));
						visited[nr][nc][hCnt]=true;
					}
				}
				for(int d=0; d<hDelta.length;d++) {
					int nr = r+hDelta[d][0];
					int nc = c+hDelta[d][1];
					if(isIn(nr,nc)&&!map[nr][nc]&&hCnt<K&&!visited[nr][nc][hCnt+1]) {
						que.offer(new Move(nr,nc,hCnt+1));
						visited[nr][nc][hCnt+1]=true;
					}
				}
			}
			if(flag) break;
			cnt++;
		}
		return r==H-1&&c==W-1 ? cnt:-1;
	}
	private static boolean isIn(int row, int col) {
		return 0<=row&&row<H&&0<=col&&col<W?true:false;
	}

}
