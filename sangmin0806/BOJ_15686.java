import java.io.*;
import java.util.*;

public class BOJ_15686 {

    static int N;
    static int M;
    static int[][] map;
    static int minSum;
    static int minDistance = Integer.MAX_VALUE;
    static List<int[]> houselist = new ArrayList<>();
    static int housesize;
    static List<int[]> chickenlist = new ArrayList<>();
    static int chickensize;
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i+1][j+1] = Integer.parseInt(st.nextToken());
                if (map[i + 1][j + 1] == 1) {
                    houselist.add(new int[]{i+1,j+1});
                }
                else if(map[i + 1][j + 1] == 2) {
                    chickenlist.add(new int[]{i + 1, j + 1});
                }
            }
        }
        housesize = houselist.size();
        chickensize = chickenlist.size();

        open = new boolean[chickensize];
        dfs(0,0);
        System.out.println(minDistance);
        br.close();
    }
    public static void dfs(int count,int start){

        if(count==M){
            minSum =0;
            int distance;
            for(int j = 0; j<housesize; j++){
                int min = Integer.MAX_VALUE;
                for(int i = 0; i<chickensize; i++){
                    if(open[i]) {
                        distance = Math.abs(houselist.get(j)[0] - chickenlist.get(i)[0]) + Math.abs(houselist.get(j)[1] - chickenlist.get(i)[1]);
                        if (min > distance) {
                            min = distance;
                        }
                    }
                }
                minSum+=min;
            }
            minDistance = Math.min(minDistance,minSum);
            return;
        }
        for(int i = start; i<chickensize;i++){
            open[i] = true;
            dfs(count+1,i+1);
            open[i] = false;
        }
    }
}
