import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16918 {
	static int R,C;
	static boolean map[][];
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		if(N%2==0) {
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					System.out.print('0');
				}
				System.out.println();
			}
			System.exit(0);
		}
		map = new boolean[R][C];
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c = 0;c<C;c++) {
				if(str.charAt(c)=='O') {
					map[r][c] = true;
				}
			}
		}
		for(int i=0;i<(N-1)/2;i++) {
			boolean[][] visited = new boolean [R][C];
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(!map[r][c])continue;
					for(int d=0;d<4;d++) {
						int rd = r+delta[d][0];
						int cd = c+delta[d][1];
						if(!isIn(rd,cd))continue;
						visited[rd][cd] = true;
					}
				}
			}
			map = copy(map,visited);
		}
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c])System.out.print('0');
				else System.out.print('.');
			}
			System.out.println();
		}
	}
	static private boolean[][] copy(boolean[][] map, boolean[][] visited){
		boolean[][] tmp = new boolean[R][C];
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]||visited[r][c]) tmp[r][c] = false;
				else tmp[r][c] = true;
			}
		}
		return tmp;
	}
	static boolean isIn(int r,int c) {
		return 0<=r&&r<R&&0<=c&&c<C?true:false;
	}

}
