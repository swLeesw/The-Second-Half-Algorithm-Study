import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10159 {
    static class Node{
        List<Integer> lighter;
        List<Integer> heavier;
        public Node() {
            lighter = new ArrayList<>();
            heavier = new ArrayList<>();
        }
    }
    static List<Node> items;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N  = Integer.parseInt(br.readLine());
        int M  = Integer.parseInt(br.readLine());
        items = new ArrayList<Node>();
        for(int n=0;n<=N;n++)items.add(new Node());
        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            items.get(a).heavier.add(b);
            items.get(b).lighter.add(a);
        }
        for(int n=1;n<=N;n++){
            System.out.println(getCnt(n));
        }
    }
    private static int getCnt(int idx){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(idx);
        visited[idx] = true;
        while(!que.isEmpty()){
            int q=que.poll();
            for(int i = 0; i<items.get(q).heavier.size();i++) {
                int num = items.get(q).heavier.get(i);
                if (!visited[num]) {
                    visited[num] = true;
                    que.add(num);
                }
            }
        }
        que.add(idx);
        while(!que.isEmpty()){
            int q=que.poll();
            for(int i = 0; i<items.get(q).lighter.size();i++) {
                int num = items.get(q).lighter.get(i);
                if (!visited[num]) {
                    visited[num] = true;
                    que.add(num);
                }
            }
        }
        int cnt = 0;
        for(int n=1;n<=N;n++){
            if(n==idx)continue;
            if(!visited[n])cnt++;
        }
        return cnt;
    }
}
