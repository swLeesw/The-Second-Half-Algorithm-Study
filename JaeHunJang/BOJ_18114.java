import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 블랙 프라이데이 / 40분
public class BOJ_18114 {
    static int N, C;
    static List<Integer> items;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        items = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int item = Integer.parseInt(st.nextToken());
            if (item <= C) items.add(item);
        }

        Collections.sort(items);

        if (items.get(items.size()-1) == C) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            int left = i+1, right = items.size()-1, sum = items.get(i);
            while (left <= right) {
                int mid = (left + right) / 2;
                int item = items.get(mid);
                if (sum + item > C) {
                    right = mid - 1;
                } else if (sum + item < C) {
                    left = mid + 1;
                } else if (sum + item == C) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 0; i < items.size(); i++) {
            for (int j = i+1; j < items.size()-1; j++) {
                int left = j+1, right = items.size()-1, sum = items.get(i) + items.get(j);
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int item = items.get(mid);
                    if (sum + item > C) {
                        right = mid - 1;
                    } else if (sum + item < C) {
                        left = mid + 1;
                    } else if (sum + item == C) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}