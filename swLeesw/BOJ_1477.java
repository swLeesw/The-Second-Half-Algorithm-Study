import java.util.*;
import java.io.*;

public class Main {

    static int n, m, l;
    static Integer[] arr, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new Integer[n + 2];

        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n + 1] = l;

        // 정렬
        Arrays.sort(arr);

        int low = 1;
        int high = l;
        int sol = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceRestStops(mid)) {
                sol = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(sol);
    }

    static boolean canPlaceRestStops(int maxDist) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int dist = arr[i] - arr[i - 1];
            count += (dist - 1) / maxDist;
        }
        return count <= m;
    }
}
