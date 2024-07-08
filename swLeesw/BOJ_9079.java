import java.io.*;
import java.util.*;

public class Main {

    static class Info {
        int num, cnt;

        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int t, arr[][];
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            visited = new boolean[512]; //2^9
            arr = new int[3][3];

            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    if (st.nextToken().equals("H")) { //앞 1
                        arr[i][j] = 1;
                    } else { //뒤 0
                        arr[i][j] = 0;
                    }
                }
            }

            System.out.println(bfs());

        }

    }



    static int bfs() {
        Queue<Info> que = new ArrayDeque<>();
        int start = makeInt(arr);
        visited[start] = true;
        que.offer(new Info(start, 0));

        while (!que.isEmpty()) {
            Info cur = que.poll();

            if (cur.num == 511 || cur.num == 0) {
                return cur.cnt;
            }

            int curArr[][] = makeArr(cur.num);

            for (int i = 0; i < 3; i++) {
                int next1 = makeInt(turnHor(curArr, i));
                int next2 = makeInt(turnVer(curArr, i));

                if (!visited[next1]) {
                    visited[next1] = true;
                    que.offer(new Info(next1, cur.cnt + 1));
                }
                if (!visited[next2]) {
                    visited[next2] = true;
                    que.offer(new Info(next2, cur.cnt + 1));
                }

            }

            for (int i = 0; i < 2; i++) {
                int next3 = makeInt(turnDia(curArr, i));
                if (!visited[next3]) {
                    visited[next3] = true;
                    que.offer(new Info(next3, cur.cnt + 1));
                }
            }

        }
        return -1;
    }

    static int[][] makeArr(int num) { //비트마스킹을 사용한 배열 변환
        int[][] arr = new int[3][3];
        int mask = 1; // 비트를 추출하기 위한 마스크

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = (num & mask) == 0 ? 0 : 1; // num의 현재 비트가 0인지 1인지 확인
                mask <<= 1;
            }
        }

        return arr;
    }

    static int[][] turnHor(int[][] tArr, int row) {
        int[][] newArr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            newArr[i] = tArr[i].clone();
        }
        for (int j = 0; j < 3; j++) {
            newArr[row][j] = newArr[row][j] == 1 ? 0 : 1;
        }
        return newArr;
    }

    static int[][] turnVer(int[][] tArr, int col) {
        int[][] newArr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            newArr[i] = tArr[i].clone();
        }
        for (int i = 0; i < 3; i++) {
            newArr[i][col] = newArr[i][col] == 1 ? 0 : 1;
        }
        return newArr;
    }

    static int[][] turnDia(int[][] tArr, int dir) {
        int[][] newArr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            newArr[i] = tArr[i].clone();
        }
        if (dir == 0) {
            for (int i = 0; i < 3; i++) {
                newArr[i][i] = newArr[i][i] == 1 ? 0 : 1;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                newArr[2 - i][i] = newArr[2 - i][i] == 1 ? 0 : 1;
            }
        }
        return newArr;
    }

    static int makeInt(int[][] tArr) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += (int)(tArr[i][j] * Math.pow(2, i * 3 + j));
            }
        }
        return sum;
    }
}
