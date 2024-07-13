import

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, cnt;
    static int[][] inputArr;
    static char[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 라운드 횟수

        inputArr = new int[n + 1][m + 1]; // 입력 배열
        visited = new char[n + 1][m + 1]; // 방문 여부 배열

        // 입력 받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = 'S'; // 모든 칸을 방문하지 않은 상태로 초기화
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            attack(x, y, getDir(direction));

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            defense(x, y);
        }

        System.out.println(cnt);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void attack(int x, int y, int dir) {
        if (visited[x][y] == 'F') { // 이미 방문한 칸이면 종료
            return;
        } else {
            int size = inputArr[x][y] - 1;
            visited[x][y] = 'F';  // 방문 표시
            cnt++; // 방문 횟수 증가

            while (size > 0) {
                int nx = x + dy[dir];
                int ny = y + dx[dir];

                if (nx < 1 || nx >= n + 1 || ny < 1 || ny >= m + 1) {
                    return;
                }
                size--;
                x = nx;
                y = ny;
                if (visited[nx][ny] == 'F') {
                    continue;
                }
                visited[nx][ny] = 'F';
                size = Math.max(size, inputArr[nx][ny] - 1);
                cnt++;
            }
        }
    }
    
    static int getDir(String s) {
        if (s.equals("E")) return 0;
        else if (s.equals("W")) return 1;
        else if (s.equals("S")) return 2;
        else if (s.equals("N")) return 3;
        else return 0;
    }
    
    static void defense(int cr, int cc) {
        if (visited[cr][cc] != 'F') return;
        visited[cr][cc] = 'S';
    }
}
