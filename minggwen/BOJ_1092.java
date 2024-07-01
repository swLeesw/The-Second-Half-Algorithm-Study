import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1092 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int cranes[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			cranes[n]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cranes);
		int M = Integer.parseInt(br.readLine());
		List<Integer> goods = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int m=0;m<M;m++) {
			goods.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(goods);
		int time = 0;
		while(!goods.isEmpty()) {
			int cnt = 0;
			for(int n=0;n<N;n++) {
				int crane = cranes[n];
				int left = 0;
				int right = goods.size()-1;
				int mid = 0;
				int pick = -1;
				while(left<=right) {
					mid = (left+right)/2;
					if(crane>=goods.get(mid)) {
						pick = mid;
						left = mid+1;
					}else {
						right = mid-1;
					}
				}
				if(pick==-1)cnt++;
				else goods.remove(pick);
			}
			if(cnt==N) {
				System.out.println(-1);
				System.exit(0);
			}else time++;
		}
		System.out.println(time);

	}

}
