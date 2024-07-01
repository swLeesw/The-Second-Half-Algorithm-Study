import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static class guest{
		int cost;
		int num;
		public guest(int cost, int num){
			this.cost = cost;
			this.num = num;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); //늘려야하는 고객의 수
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		guest[] guests = new guest[N];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			guests[i] = new guest(cost,num);
		}
		int[] dp = new int[C+101];
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		for(guest cur : guests) {
			for(int i = cur.num; i<C+101 ; i++) {
				dp[i] = Math.min(dp[i], cur.cost+dp[i-cur.num]);
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = C ; i<C+101; i++) {
			result = Math.min(result, dp[i]);
		}
    
		System.out.println(result);

	}

}
