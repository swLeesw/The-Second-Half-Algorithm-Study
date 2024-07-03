import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 호텔 / 90분
public class BOJ_1106 {
	static StringBuilder sb = new StringBuilder();
	static int C, N, dp[];
	static Dosi[] list;
	static final int MAX = 987654321;

	static class Dosi {
		int cost, customer;

		public Dosi(int cost, int customer) {
			this.cost = cost;
			this.customer = customer;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new Dosi[N];
		dp = new int[C + 101];

		int c, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[i] = new Dosi(c, b);
		}

		Arrays.fill(dp, MAX);
		dp[0] = 0;

		for (Dosi dosi : list) {
			for (int i = dosi.customer; i < C + 101; i++) {
				dp[i] = Math.min(dp[i], dp[i - dosi.customer] + dosi.cost);
			}
		}

		int minCost = MAX;
		for (int cost = C; cost < C + 101; cost++) {
			minCost = Math.min(minCost, dp[cost]);
		}

		System.out.println(minCost);
	}
}
