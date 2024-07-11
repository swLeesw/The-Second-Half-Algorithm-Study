import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<List<Integer>> arr = new ArrayList<>();
		for(int n=0;n<=N+1;n++) arr.add(new ArrayList<>());
		for(int m=0;m<M;m++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		boolean[] visited = new boolean[N+2];
		for(int a:arr.get(1)) {
			visited[a] = true;
			for(int k:arr.get(a)) {
				visited[k]=true;
			}
		}
		int cnt = 0;
		for(int i=2;i<=N+1;i++) {
			if(visited[i])cnt++;
		}
		System.out.println(cnt);
	}

}
