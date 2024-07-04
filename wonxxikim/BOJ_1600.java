import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K,W,H,map[][], min;
	static class monkey{
		int x;
		int y;
		int k;
		int time;
		public monkey(int x, int y, int k, int time) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i = 0 ; i<H ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		bfs();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	public static void bfs() {
		int[][] delta = {{0,-1},{1,0},{0,1},{-1,0}};
		int[][] delta_h = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
		Queue<monkey> q = new ArrayDeque<>();
		q.offer(new monkey(0,0,K,0));
		boolean[][][] visit = new boolean[K+1][H][W];
		visit[K][0][0] = true;
		
		while(!q.isEmpty()) {
			monkey cur = q.poll();
			if(cur.x==H-1 && cur.y==W-1) {
				min = cur.time;
				return;
			}
			for(int d = 0 ; d<4 ;d++) {
				int nr =cur.x+delta[d][0];
				int nc = cur.y+delta[d][1];
				if(nr>=0 && nr<H && nc>=0 && nc<W && !visit[cur.k][nr][nc] && map[nr][nc] == 0) {
					q.offer(new monkey(nr,nc,cur.k,cur.time+1));
					visit[cur.k][nr][nc] = true;
				}
			}
			if(cur.k>0) {
				for(int d = 0 ; d < 8 ;d++) {
					int nr = cur.x+delta_h[d][0];
					int nc = cur.y+delta_h[d][1];
					if(nr>=0 && nr<H && nc>=0 && nc<W && !visit[cur.k-1][nr][nc] && map[nr][nc] == 0) {
						q.offer(new monkey(nr,nc,cur.k-1,cur.time+1));
						visit[cur.k-1][nr][nc] = true;
					}
				}
			}
		}
	}

}
