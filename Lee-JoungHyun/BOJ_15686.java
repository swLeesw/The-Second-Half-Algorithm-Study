import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {

    static ArrayList<int[]> checkens;
    static int houseCnt, N, M, min = Integer.MAX_VALUE, select[][], nx, ny;
    static boolean map[][], visited[][];
    // 집이 있는곳만 true로 지정
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        checkens = new ArrayList<>();
        select = new int[M][2];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    map[y][x] = true;
                    houseCnt++;
                }
                else if (tmp == 2)
                    checkens.add(new int[]{y, x});
            }
        }// 입력 끝

        //1. 조합으로 치킨집 M개를 뽑아라
        //2. 뽑은 치킨집 M개 모두 queue에 넣고 BFS 진행
        makeComb(0, 0);
        System.out.println(min);
    }
    // 조합 뽑기
    static void makeComb(int start, int cnt) {
        if (cnt == M) {
            // 다뽑고 처리 -> check()
            check();
            return;
        }
        for (int i = start; i < checkens.size(); i++) {
            select[cnt][0] = checkens.get(i)[0];
            select[cnt][1] = checkens.get(i)[1];
            makeComb(i+1, cnt+1);
        }
    }
    // 뽑은 조합으로 치킨집부터 시작해 집들까지의 거리 찾기
    static void check() {
        queue = new LinkedList<>();
        visited = new boolean[N][N];
        for (int[] ch : select)
            queue.add(ch);
        int qusize = 0;
        int depth = 1;  // 가장 가까운 치킨집과의 거리
        int sCnt = 0;   // 선택된 집의 개수
        int tmp = 0;    // 해당 조합에서의 치킨거리
        int[] now;
        while (!queue.isEmpty()) {
            qusize = queue.size();
            while (qusize-- > 0) {
                now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    ny = now[0] + dy[i];
                    nx = now[1] + dx[i];
                    // 범위 밖 or 방문
                    if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                        // 집찾으면 치킨거리 더해주기, 찾은 집 개수 더해주기
                        if (map[ny][nx]) {
                            sCnt++;
                            tmp += depth;
                        }
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
                // 집 다 찾으면 종료
                if (sCnt >= houseCnt) {
                    queue.clear();
                    break;
                }
            }
            depth++;
        }
        // min값 갱신
        min = Math.min(min, tmp);
    }
}
