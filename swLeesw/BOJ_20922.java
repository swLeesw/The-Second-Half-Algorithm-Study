
import java.io.*;
import java.util.*;

public class Main {

  static int N, K, arr;
  
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int start = 0;
		int end = 0;
		int cnt[] = new int[100001];
		while(end < arr.length) {
			while(end < arr.length && cnt[arr[end]] + 1 <= K) {
				cnt[arr[end]]++;
				end++;
			}
			int len = end-start;
			ans = Math.max(ans, len);
			cnt[arr[start]]--;
			start++;
		}
		System.out.println(ans);
	}
}
