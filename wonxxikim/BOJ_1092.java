import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 크레인의 수
		int[] limit = new int[N]; // 크레인의 무게 제한
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(limit);
		int answer = 0;

		int M = Integer.parseInt(br.readLine()); // 박스의 수
		ArrayList<Integer> box = new ArrayList<>(); // 박스의 무게
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int thisbox = Integer.parseInt(st.nextToken());
			box.add(thisbox);
			if (thisbox > limit[N - 1])
				answer = -1;
		}
		box.sort(Collections.reverseOrder());;
		if (answer == -1)
			System.out.println(answer);
		else {
			while (!box.isEmpty()) {
				int craneidx = N-1;
				int boxidx = 0;
				while(craneidx>=0) {
					if(boxidx==box.size()) break;
					else if(box.get(boxidx)<=limit[craneidx]) {
						box.remove(boxidx);
						craneidx--;
					}else {
						boxidx++;
					}
				}
				answer++;
			}
			System.out.println(answer);
		}

	}

}
