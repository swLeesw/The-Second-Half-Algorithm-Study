import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i = 0 ; i<R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j<C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int time = 1;
		boolean flag = false;
		while(true) {
			if(time == N) break;
			flag= true;
			time++;
			if(time == N) break;
			flag = false;
			boolean[][] visit = new boolean[R][C];
			for(int i = 0 ; i<R ; i++) {
				for(int j = 0 ; j<C ; j++) {
					if(map[i][j] =='O') {
						visit[i][j] = true;
						map[i][j] = '.';
						for(int d = 0 ;d<4 ;d++) {
							int nr = i+delta[d][0];
							int nc = j+delta[d][1];
							if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]!='O') {
								visit[nr][nc] = true;
								map[i][j] = '.';
							}
						}
					}
				}
			}
			for(int i = 0 ; i<R ;i++) {
				for(int j = 0 ; j<C ; j++) {
					if(!visit[i][j]) map[i][j]='O';
				}
			}
			time++;
			
			
			
			
		}
		for(int i = 0 ; i<R ; i++) {
			for(int j = 0 ; j<C ; j++) {
				if(flag) System.out.print('O');
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
		

	}

}
