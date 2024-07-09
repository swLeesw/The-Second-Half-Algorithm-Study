import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            if (arr.get(i) == C) {
                System.out.println(1);
                return;
            }
        }
        Collections.sort(arr);
        int left = 0, right = N - 1, weight;
        while(left < right) {
            weight = arr.get(left) + arr.get(right);
            if (weight > C) {
                right--;
            } else if (weight == C) {
                System.out.println(1);
                return;
            } else {
                if(arr.indexOf(C-weight) < right && arr.indexOf(C-weight) > left) {
                    System.out.println(1);
                    return;
                }
                left++;
            }
        }
        System.out.println(0);
    }
}
