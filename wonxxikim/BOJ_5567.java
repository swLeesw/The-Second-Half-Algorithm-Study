import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n+1];
        friends = new ArrayList[n+1];
        for(int i = 0 ; i<=n ; i++){
            friends[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }
        Queue<Integer> friends2 = new LinkedList<>();
        for(int i : friends[1]) {
            visit[i] = true;
            friends2.add(i);
        }
        while(!friends2.isEmpty()){
            int cur = friends2.poll();
            for(int i : friends[cur]){
                visit[i] = true;
            }
        }
        int answer = 0;
        for(int i = 2 ; i<=n ; i++){
            if(visit[i]) answer++;
        }
        System.out.println(answer);

    }

}
