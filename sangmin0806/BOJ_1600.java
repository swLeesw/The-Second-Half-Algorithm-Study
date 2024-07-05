import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static class Monkey{
        int row;
        int col;
        int count;

        public Monkey(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    static int K,W,H;
    static boolean flag = false;
    static int[][] map;
    static int answer = 0;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[] hdr = {-2,-1,1,2,2,1,-1,-2};
    static int[] hdc = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(flag){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
    public static void bfs(){
        Queue<Monkey> que = new ArrayDeque<>();
        boolean[][][] visited = new boolean[K+1][H][W];
        que.add(new Monkey(0,0,K));
        visited[K][0][0] = true;

        while (!que.isEmpty()){
            int size = que.size();
            answer++;
            for (int q = 0; q < size; q++) {
                Monkey current = que.poll();
                if(current.row==H-1&&current.col==W-1){
                    answer--;
                    flag = true;
                    return;
                }
                if(current.count>0){
                    for (int i = 0; i < 8; i++) {
                        int nrow = current.row+hdr[i];
                        int ncol = current.col+hdc[i];
                        int ncount = current.count-1;
                        if(nrow<0||nrow>=H||ncol<0||ncol>=W)continue;
                        if(visited[ncount][nrow][ncol]||map[nrow][ncol]==1)continue;

                        visited[ncount][nrow][ncol] = true;
                        que.add(new Monkey(nrow,ncol,ncount));

                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nrow = current.row+dr[i];
                    int ncol = current.col+dc[i];
                    int count = current.count;
                    if(nrow<0||nrow>=H||ncol<0||ncol>=W)continue;
                    if(visited[count][nrow][ncol]||map[nrow][ncol]==1)continue;

                    visited[count][nrow][ncol] = true;
                    que.add(new Monkey(nrow,ncol,count));
                }
            }

        }



    }

}
