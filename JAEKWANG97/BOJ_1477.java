import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        
        int[] restStops = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            restStops[i] = sc.nextInt();
        }
        restStops[0] = 0; // 고속도로의 시작점
        restStops[N + 1] = L; // 고속도로의 끝점
        
        Arrays.sort(restStops);
        
        int left = 1;
        int right = L - 1;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceRestStops(restStops, N, M, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
        sc.close();
    }
    
    private static boolean canPlaceRestStops(int[] restStops, int N, int M, int maxDist) {
        int count = 0;
        for (int i = 1; i < restStops.length; i++) {
            int dist = restStops[i] - restStops[i - 1];
            if (dist > maxDist) {
                count += (dist - 1) / maxDist;
            }
        }
        return count <= M;
    }
}
