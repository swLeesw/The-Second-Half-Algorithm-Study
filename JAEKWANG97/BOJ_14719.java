import java.util.Scanner;

public class Main {
    private static int W, H;
    private static int[] arr;
    private static int maxIdx;
    private static int max;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        max = Integer.MIN_VALUE;
        arr = new int[W];
        for(int i = 0; i < W; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max){
                max = arr[i];
                maxIdx = i;
            }
        }
    }

    private static void solve(){

        int left = 0;
        int right = W - 1;
        int totalSum = 0;

        int curMax = arr[left];

        while(left < maxIdx){
            if(curMax >= arr[left]){
                totalSum += (curMax - arr[left]);
            }
            else{
                curMax = arr[left];
            }
            left += 1;
        }

        curMax = arr[right];
        while(right > maxIdx){
            if(curMax >= arr[right]){
                totalSum += (curMax - arr[right]);
            }
            else{
                curMax = arr[right];
            }
            right -= 1;
        }
        System.out.println(totalSum);
    }
}
