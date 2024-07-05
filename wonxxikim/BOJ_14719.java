import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] height;
	static int H, W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		height = new int[W];
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int i = 1 ; i<W-1; i++) {
			int left = 0;
			int right = 0;
			for(int j = 0 ; j<i; j++) {
				left=  Math.max(left, height[j]);
			}
			for (int j = i+1 ; j<W ; j++) {
				right = Math.max(right, height[j]);
			}
			if(height[i]<left && height[i]<right) answer+=(Math.min(left, right)-height[i]);
		}
		
		System.out.println(answer);

	}

}
