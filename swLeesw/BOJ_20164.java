import java.io.*;

public class BOJ_20164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n;
        n = br.readLine();
        System.out.println(solve(n, 0, false) + " " + solve(n, 0, true));
    }

    static int solve(String str, int nSum, boolean check) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int number = str.charAt(i) - '0';
            if (number % 2 == 1) {
                sum++;
            }
        }
        //길이 1이면 바로 반환
        if (str.length() == 1) {
            return nSum + sum;
        } else if (str.length() == 2) { //길이가 2면 반반
            int left = str.charAt(0) - '0';
            int right = str.charAt(1) - '0';

            String newStr = Integer.toString(left + right);

            return solve(newStr, nSum + sum, check);
        } else {
            int sIdx = 1;
            int eIdx = str.length() - 2;

            int maxSum = 0;
            int minSum = Integer.MAX_VALUE;
            for (int i = sIdx; i <= eIdx; i++) {
                for (int j = i; j <= eIdx; j++) {
                    int left = Integer.parseInt(str.substring(0, i));
                    int middle = Integer.parseInt(str.substring(i, j + 1));
                    int right = Integer.parseInt(str.substring(j + 1, str.length()));

                    String newStr = Integer.toString(left + middle + right);

                    if (check) {
                        maxSum = Math.max(maxSum, solve(newStr, nSum + sum, check));
                    } else {
                        minSum = Math.min(minSum, solve(newStr, nSum + sum, check));
                    }
                }
            }
            if (check) {
                return maxSum;
            } else {
                return minSum;
            }
        }
    }
}
