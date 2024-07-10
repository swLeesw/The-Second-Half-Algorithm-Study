import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18114 {
	static int goods[];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		goods = new int[N];
		st = new StringTokenizer(br.readLine());
		boolean flag = false;
		for(int n=0;n<N;n++) {
			goods[n] = Integer.parseInt(st.nextToken());
			if(goods[n]==W)flag = true;
		}
		Arrays.sort(goods);
		
		if(!flag) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)continue;
					if(goods[i]+goods[j]==W) {
						flag= true;
						break;
					}
				}
				if(flag)break;
			}
		}
		if(!flag) {
			for(int i =0;i<N;i++) {
				int left = i+1;
				int right = N-1;
				if(right==i)continue;
				while(left<right) {
					int sum = goods[left]+goods[right]+goods[i];
					if(sum==W) {
						flag = true;
						break;
					}else if(sum<W) {
						left++;
					}else {
						right--;
					}
				}
				if(flag)break;
				
			}
		}
		System.out.println(flag?1:0);
	}

}
