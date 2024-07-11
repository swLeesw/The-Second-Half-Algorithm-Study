import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567 {
    static int n,m;
    static int answer = 0;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        list = new List[n+1];
        visited = new boolean[n+1];
        visited[1] = true;
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < list[1].size(); i++) {
            int next = list[1].get(i);
            que.add(next);
            visited[next] = true;
            answer++;
        }
        int count = 0;
        while (!que.isEmpty()){
            for (int q = 0; q < que.size(); q++) {

                int current = que.poll();
                for (int i = 0; i < list[current].size(); i++) {
                    int next = list[current].get(i);
                    if(visited[next])continue;
                    visited[next]=true;
                    answer++;
                }
            }

        }
    }
}
