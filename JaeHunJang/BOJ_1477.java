import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 휴게소 세우기 / 90분
public class BOJ_1477 {
    static int N, M, L;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(0); // 시작점
        list.add(L); // 끝점
        if (N > 0) { // N이 0이면 추가 휴게소 바로 계산
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(list);

        int left = 1, right = L-1, mid; // 휴게소가 설치 가능한 위치에서 점점 좁혀나감
        while (left <= right) {
            mid = (left + right) / 2; // 휴게소를 설치해야하는 거리
            if (isValid(mid)) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }

    private static boolean isValid(int maxDist) {
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            int distance = list.get(i) - list.get(i-1); // 휴게소별 거리 계산
            cnt += (distance - 1) / maxDist; // 커버 가능한 휴게소의 거리를 계산
            /*
                distance = 300km, maxDist = 100km
                필요한 휴게소 수 = (300 - 1) / 100 = 2.99 → 총 2개의 추가 휴게소가 필요
            */
        }
        return cnt <= M;
    }
}