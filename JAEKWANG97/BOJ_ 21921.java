import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] visitant = new int[n];
        for (int i = 0; i < n; i++) {
            visitant[i] = sc.nextInt();
        }


        int maxSum = 0;
        for (int i = 0; i < x; i++) {
            maxSum += visitant[i];
        }
        
        int currentSum = maxSum;
        int count = maxSum == 0 ? 0 : 1;


        for (int i = 1; i <= n - x; i++) {
            currentSum = currentSum - visitant[i - 1] + visitant[i + x - 1];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                count = 1;
            } else if (currentSum == maxSum) {
                count += 1;
            }
        }


        if (maxSum > 0) {
            System.out.println(maxSum);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
        
        sc.close();
    }
}
