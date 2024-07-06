import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 겹치는 건 싫어 / 70분
public class BOJ_20922 {
    static int K, N, list[], visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];
        visited = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right=0, max = 0;
        while(right < N) {
            while (right < N && visited[list[right]] < K) {
                visited[list[right]]++;
                right++;
            }
            max = Math.max(max, right - left);
            visited[list[left]]--;
            left++;
        }

        System.out.println(max);
    }
}