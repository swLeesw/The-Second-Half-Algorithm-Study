import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


    //앞의 물건이 뒤의 물건보다 더 무겁다.
    private static List<List<Integer>> upperlist;
    private static List<List<Integer>> lowerlist;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        upperlist = new ArrayList<>();
        lowerlist = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            upperlist.add(new ArrayList<>());
            lowerlist.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            upperlist.get(a).add(b);
            lowerlist.get(b).add(a);
        }
    }

    private static void solve() throws IOException {
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(n);
        boolean[] visited = new boolean[N + 1];
        visited[n] = true;


        int count = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            count += 1;
            if(n == 1){
//                System.out.println("n == 1 " + cur);
            }
            for (Integer i : upperlist.get(cur)) {
                if (visited[i]) continue;
                visited[i] = true;
                que.add(i);


            }
        }

        que = new ArrayDeque<>();
        que.add(n);



        while (!que.isEmpty()) {
            int cur = que.poll();
            count += 1;
            if(n == 1) {
//                System.out.println("n == 1 " + cur);
            }
            for (Integer i : lowerlist.get(cur)) {
                if (visited[i]) continue;
                visited[i] = true;
                que.add(i);

            }
        }

        System.out.println(N - count + 1);
    }


}
