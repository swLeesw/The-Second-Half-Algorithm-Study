import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배 / 90분
public class BOJ_1092 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, cranes[], boxs[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cranes = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		boxs = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			boxs[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cranes);
		Arrays.sort(boxs);

		if (cranes[N-1] < boxs[M-1]) {
			System.out.println(-1); return;
		}

		int count = 0;
		boolean[] lifted = new boolean[M];
		int totalLifted = 0;

		while (totalLifted < M) {
			count++;
			int craneIndex = N - 1;
			for (int boxIndex = M - 1; boxIndex >= 0 && craneIndex >= 0; boxIndex--) {
				if (!lifted[boxIndex] && cranes[craneIndex] >= boxs[boxIndex]) {
					lifted[boxIndex] = true;
					totalLifted++;
					craneIndex--;
				}
			}
		}

		System.out.println(count);
	}
}
