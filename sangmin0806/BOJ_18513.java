import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513 {
    static int N,K;
    static int[] dir = {1,-1};

    static Queue<Integer> que = new ArrayDeque<>();
    static HashSet<Integer> visited = new HashSet<>();
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            que.add(num);
            visited.add(num);
        }
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        int sad = 0;
        int count = 0;
        while (!que.isEmpty()){
            int size = que.size();
            sad++;
            for (int q = 0; q < size; q++) {
                int current = que.poll();
                for (int i = 0; i < 2; i++) {
                    int nNum = current+dir[i];
                    if(visited.contains(nNum))continue;
                    que.add(nNum);
                    visited.add(nNum);
                    count++;
                    answer+=sad;
                    if(count==K) return;
                }
            }

        }
    }
}
