import java.io.*;
import java.util.*;

public class Main {

    static int n, x, arr[], sol, period;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int sIdx = 0;
        int eIdx = x - 1;
        for (int i = 0 ; i < x; i++) {
            sum += arr[i];
        }
        sol = sum;

        period = 1;
        int cnt = n - x;

        while (cnt-- > 0) {
            sum -= arr[sIdx++];
            sum += arr[++eIdx];
            if (sol < sum) {
                sol = sum;
                period = 1;
            } else if (sol == sum) {
                period++;
            }

        }

        if (sol != 0) {
            System.out.print(sol + "\n" + period);
        } else {
            System.out.println("SAD");
        }
    }

}
