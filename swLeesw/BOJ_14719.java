import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, arr[], sol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
			
		for (int i = 1; i < n - 1; i++) {
			int lIdx = 0;
			int rIdx = n - 1;
			for (int j = 1; j < i; j++) {
				if (arr[lIdx] < arr[j]) {
					lIdx = j;
				}
			}
			
			for (int j = n - 2; j > i; j--) {
				if (arr[rIdx] < arr[j]) {
					rIdx = j;
				}
			}
			
			if (arr[lIdx] == 0 || arr[rIdx] == 0) continue;
			
			if (arr[lIdx] < arr[rIdx]) {
				if (arr[lIdx] > arr[i]) {
					sol += arr[lIdx] - arr[i];
				}
			} else {
				if (arr[rIdx] > arr[i]) {
					sol += arr[rIdx] - arr[i];
				}
			}
		}
		
		
		
		System.out.println(sol);
		
	}
	
}
