import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(solve(N, K, arr));
    }
    
    private static int solve(int N, int K, int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;

        while (end < N) {
            countMap.put(arr[end], countMap.getOrDefault(arr[end], 0) + 1);
            
            while (countMap.get(arr[end]) > K) {
                countMap.put(arr[start], countMap.get(arr[start]) - 1);
                if (countMap.get(arr[start]) == 0) {
                    countMap.remove(arr[start]);
                }
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        
        return maxLength;
    }
}
