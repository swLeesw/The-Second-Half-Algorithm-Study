import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0;n<N;n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for(int x=0;x<X;x++) {
			sum+=arr[x];
		}
		int MAX = sum;
		int cnt = 1;
		for(int i=X;i<N;i++) {
			sum-=arr[i-X];
			sum+=arr[i];
			if(sum>MAX) {
				MAX = sum;
				cnt =1;
			}
			else if(sum==MAX)cnt++;
		}
		if(MAX==0) {
			System.out.println("SAD");
		}else {
			System.out.println(MAX);
			System.out.println(cnt);
		}
	}

}
