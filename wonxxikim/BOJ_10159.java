import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> big = new ArrayList<>();
        Node(ArrayList<Integer> small, ArrayList<Integer> big){
            this.small = small;
            this.big = big;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];
        for(int i = 1 ; i<=N ; i++){
            nodes[i] = new Node(new ArrayList<>(), new ArrayList<>());
        }
        for(int i = 0 ; i<M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[x].small.add(y);
            nodes[y].big.add(x);
        }

        int[] answer = new int[N+1];
        boolean[][] visit = new boolean[N+1][N+1];
        for(int i = 1 ; i<=N ; i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visit[i][i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int x : nodes[cur].small){
                    if(!visit[i][x]){
                        visit[i][x] = true;
                        q.add(x);
                    }

                }
            }
            q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int x : nodes[cur].big){
                    if(!visit[i][x]){
                        visit[i][x] = true;
                        q.add(x);
                    }

                }
            }
            int cnt = 0;
            for(int j = 1 ; j<=N ; j++){
                if(!visit[i][j]) cnt++;
            }
            answer[i] = cnt;
        }
        for(int i = 1; i<=N ; i++){
            System.out.println(answer[i]);
        }

    }

}
