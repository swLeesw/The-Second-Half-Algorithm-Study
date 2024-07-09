import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], home_size, chicken_size, result;
	static Node chicken[];
	static Node home[];
	static Node choose[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chicken = new Node[13];
		home = new Node[N*N];
		chicken_size = 0;
		home_size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) chicken[chicken_size++] = new Node(i, j);
				if (map[i][j] == 1) home[home_size++] = new Node(i,j);
			}
		}

		result = Integer.MAX_VALUE;
		choose = new Node[M];
		combination(0, 0);
		System.out.println(result);

	}

	static void combination(int cnt, int start) {
		if (cnt == M) {
			int candidate = 0;
			for(int i = 0 ; i<home_size ; i++) {
				Node h = home[i];
				int length = Integer.MAX_VALUE;
				for(Node c : choose) {
					int len = Math.abs(h.x-c.x)+Math.abs(h.y-c.y);
					if(length>len) length =len;
				}
				candidate+=length;
				
			}
			if(candidate<result) result = candidate;
			return;


		}
		
		for (int i = start; i < chicken_size; i++) {
			choose[cnt]= chicken[i];
			combination(cnt + 1, i + 1);
		}
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;

		}

	}
}
