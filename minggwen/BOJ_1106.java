import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {

	static int MAX = 2000;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int dp[] = new int[MAX+1];
		int arr[][] = new int[N][2];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1000000000);
		dp[0]=0;
		for(int n=0;n<N;n++) {
			int money = arr[n][0];
			int custom = arr[n][1];
			for(int c=custom;c<=MAX;c++) {
				dp[c]=Math.min(dp[c],dp[c-custom]+money);
			}
		}

		int result = 1000000000;
		for(int c=C;c<=MAX;c++) {
			result = Math.min(result, dp[c]);
		}
		System.out.println(result);

	}

}
