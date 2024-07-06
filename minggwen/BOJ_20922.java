import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int nums[] = new int[100001];
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int MAX = 0;
		nums[arr[left]]++;
		while(left<=right&&right<=N) {
			if(nums[arr[right]]>K) {
				nums[arr[left]]--;
				left++;
			}else {
				right++;
				MAX = Math.max(right-left, MAX);
				if(right==N)break;
				nums[arr[right]]++;
				
			}
		}
		System.out.println(MAX);
	}

}
