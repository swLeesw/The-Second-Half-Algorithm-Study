package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    private static class Node{
        int x;
        int y;
        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int n,m,min;
    private static int[][] arr;
    private static boolean[] visited;
    private static ArrayList<Node> home = new ArrayList<>();
    private static ArrayList<Node> ch = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1) {
                    home.add(new Node(i, j));
                }else if(arr[i][j] == 2) {
                    ch.add(new Node(i, j));
                }
            }
        }
        min = Integer.MAX_VALUE;
        visited = new boolean[ch.size()];
        dfs(0,0);
        System.out.println(min);
    }//main end

    private static void dfs(int count,int idx) {
        if(count == m) {
            int total = 0;
            for(int i = 0; i < home.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < ch.size(); j++) {
                    if(visited[j]) {
                        int dis = Math.abs(home.get(i).x - ch.get(j).x)+Math.abs(home.get(i).y - ch.get(j).y);

                        sum = Math.min(sum, dis);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = idx; i < ch.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(count+1,i+1);
                visited[i] = false;
            }
        }
    }//dfs end
}//class end
