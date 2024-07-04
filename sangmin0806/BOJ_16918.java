import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_16918 {
    static int R,C,N;
    static char[][] map;
    static char[][] map2;
    static char[][] all;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        map2 = new char[R][C];
        char[][] initmap = new char[R][C];
        all = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                initmap[i][j] = str.charAt(j);
                map[i][j] = 'O';
                map2[i][j] = 'O';
                all[i][j] = 'O';
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(initmap[i][j]=='O'){
                    Bomb(i,j);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='O'){
                    Bomb2(i,j);
                }
            }
        }
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        StringBuilder initprint = new StringBuilder();
        for (int i = 0; i < R; i++) {
            initprint.append(initmap[i]).append("\n");
        }
        StringBuilder bombprint = new StringBuilder();
        for (int i = 0; i < R; i++) {
            bombprint.append(map[i]).append("\n");
        }
        StringBuilder allprint = new StringBuilder();
        for (int i = 0; i < R; i++) {
            allprint.append(all[i]).append("\n");
        }
        StringBuilder bomb2print = new StringBuilder();
        for (int i = 0; i < R; i++) {
            bomb2print.append(map2[i]).append("\n");
        }
        if(N==1){
            System.out.println(initprint);
            return;
        }
        if(N%2==0){
            System.out.println(allprint);
        }
        else if(N%4==1)
            System.out.println(bomb2print);
        else if(N%4==3)
            System.out.println(bombprint);
    }
    public static void Bomb(int row, int col){
        map[row][col] = '.';
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=R||ncol>=C)
                continue;
            map[nrow][ncol] = '.';
        }
    }
    public static void Bomb2(int row, int col){
        map2[row][col] = '.';
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=R||ncol>=C)
                continue;
            map2[nrow][ncol] = '.';
        }
    }
}
