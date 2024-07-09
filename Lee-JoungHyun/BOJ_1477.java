import java.io.*;
import java.util.*;

public class BOJ_1477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();			// 휴게소 위치 리스트

        list.add(0);		// 출발 위치
        list.add(L);		// 고속도로 끝 위치

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
		
        // 이분 탐색
        int left = 1;
        int right = L;

        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            // 휴게소 사이에 mid 길이만큼 거리에 휴게소를 세운다면 몇개의 휴게소를 세울 수 있을지 계산
            for(int i = 1; i<list.size(); i++)
                count += (list.get(i) - list.get(i-1) - 1) / mid;
            // 세울 수 있는 휴게소 개수에 따라 범위 재조정
            if(count > M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }
}
