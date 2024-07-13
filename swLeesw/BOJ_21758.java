import java.util.*;
import java.io.*;

public class Main {
    public static long[] honey;
    public static int n;
    public static long solve;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        honey = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            honey[i] = a;
        }

        solve = 0;

        long fixSum = Arrays.stream(honey).sum() - honey[0];
        long moveSum = fixSum;

        for (int i = 1; i <= honey.length - 2 ; i++) {
            long sum = fixSum - honey[i];
            moveSum = moveSum - honey[i];
            sum += moveSum;
            solve = Math.max(sum, solve);
        }


        fixSum = fixSum + honey[0] - honey[honey.length - 1];
        moveSum = fixSum;
        for (int i = honey.length - 2; i >= 0 ; i--) {
            long sum = fixSum - honey[i];
            moveSum = moveSum - honey[i];
            sum += moveSum;
            solve = Math.max(sum, solve);
        }
        
        fixSum = 0;
        moveSum = Arrays.stream(honey).sum() - honey[honey.length - 1];
        for (int i = 1; i <= honey.length - 2; i++) {
            long sum = 0;
            fixSum += honey[i];
            moveSum = moveSum - honey[i - 1];
            solve = Math.max(fixSum + moveSum, solve);
        }

        System.out.println(solve);
    }
}
