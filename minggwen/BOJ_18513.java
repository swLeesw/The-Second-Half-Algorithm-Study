import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513 {

	static int MAX = 200000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new ArrayDeque<>();
		boolean visited[] = new boolean[2*MAX+1];
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			int num = Integer.parseInt(st.nextToken())+MAX;
			que.add(num);
			visited[num] = true;
		}
		Long sum = 0L;
		int cnt = 0;
		int len = 0;
		boolean flag = false;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s=0;s<size;s++) {
				int q = que.poll();
				if(len!=0) {
					cnt++;
					sum+=len;
				}
				if(cnt==K) {
					flag = true;
					break;
				}
				if(isIn(q-1)&&!visited[q-1]) {
					visited[q-1]=true;
					que.add(q-1);
				}
				if(isIn(q+1)&&!visited[q+1]) {
					visited[q+1]=true;
					que.add(q+1);
				}
			}
			if(flag) break;
			len++;
		}
		System.out.println(sum);

	}
	private static boolean isIn(int num) {
		return 0<=num &&num<=2*MAX?true:false;
	}

}
