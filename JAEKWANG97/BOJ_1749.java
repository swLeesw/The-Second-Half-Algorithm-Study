import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(maxSubmatrixSum(matrix, N, M));
        scanner.close();
    }

    public static int maxSubmatrixSum(int[][] matrix, int N, int M) {
        int maxSum = Integer.MIN_VALUE;

       
        for (int left = 0; left < M; left++) {
            int[] tempRowSum = new int[N];
            
            for (int right = left; right < M; right++) {
                for (int i = 0; i < N; i++) {
                    tempRowSum[i] += matrix[i][right];
                }
                
                
                int maxHere = tempRowSum[0];
                int maxEndHere = tempRowSum[0];
                for (int i = 1; i < N; i++) {
                    maxEndHere = Math.max(maxEndHere + tempRowSum[i], tempRowSum[i]);
                    maxHere = Math.max(maxHere, maxEndHere);
                }
                
                maxSum = Math.max(maxSum, maxHere);
            }
        }
        
        return maxSum;
    }
}
