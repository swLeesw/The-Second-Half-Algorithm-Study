import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9079 {
	static int delta[][][] = {{{0,0},{0,1},{0,2}},{{1,0},{1,1},{1,2}},{{2,0},{2,1},{2,2}},{{0,0},{1,0},{2,0}},
			{{0,1},{1,1},{2,1}},{{0,2},{1,2},{2,2}},{{0,0},{1,1},{2,2}},{{2,0},{1,1},{0,2}}};
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			char[][] map = new char[3][3];
			for(int i=0;i<3;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			set.clear();
			System.out.println(bfs(map));
		}

	}
	static private int bfs(char[][] map) {
		Queue<char[][]> que = new ArrayDeque<>();
		que.add(map);
		set.add(toStr(map));
		int cnt = 0;
		boolean flag = false;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s=0;s<size;s++) {
				char[][] q = que.poll();
				if(isSame(q)) {
					flag = true;
					break;
				}
				
				for(int delt[][]:delta) {
					char[][] copy = copyMap(q);
					for(int del[]:delt) {
						if(q[del[0]][del[1]]=='H') {
							copy[del[0]][del[1]] = 'T';
						}else {
							copy[del[0]][del[1]] = 'H';
						}
						
					}
					String str = toStr(copy);
					if(set.contains(str))continue;
					
					set.add(str);
					que.add(copy);
				}
				
			}
			if(flag)break;
			cnt++;
			
		}
		return flag?cnt:-1;
	}
	static private boolean isSame(char[][] map) {
		char tmp = map[0][0];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[i][j]!=tmp)return false;
				
			}
		}
		return true;
	}
	static private char[][] copyMap(char[][] map){
		
		char[][] copy = new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	static private String toStr(char[][] map) {
		String str="";
		for(char[] ma:map) {
			for(char m:ma) {
				str+=m;
			}
		}
		return str;
	}
}
