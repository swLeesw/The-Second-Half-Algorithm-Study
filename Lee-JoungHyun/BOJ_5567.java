import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[n + 1];
        List<Integer> friends = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i < n + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 =  Integer.parseInt(st.nextToken());
            int f2 =  Integer.parseInt(st.nextToken());

            if (f1 == 1) {
                friends.add(f2);
                hs.add(f2);
            } else if (f2 == 1) {
                friends.add(f1);
                hs.add(f1);
            }

            list[f1].add(f2);
            list[f2].add(f1);
        }
        hs.add(1);
        for (int i : friends) {
            hs.addAll(list[i]);
        }
        System.out.println(hs.size() - 1);
    }
}
