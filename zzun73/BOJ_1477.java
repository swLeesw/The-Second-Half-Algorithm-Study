import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(L);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            list.add(val);
        }
        Collections.sort(list);

        int left = 1;
        int right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < list.size(); i++) {
                count += (list.get(i) - list.get(i - 1) - 1) / mid;
            }
            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(String.valueOf(left));

        br.close();
        bw.close();
    }
}