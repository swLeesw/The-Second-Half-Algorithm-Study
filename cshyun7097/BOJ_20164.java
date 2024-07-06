import java.util.Scanner;

public class BOJ_20164 {
    static int min, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        sol(N, getCnt(N));
        System.out.println(min + " " + max);
    }

    private static void sol(int n, int cnt) {
        if (n < 10) {
            //한자리
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        } else if (n < 100) {
            //두자리
            int sum = (n / 10) + (n % 10);
            sol(sum, cnt + getCnt(sum));
        } else {
            //세자리 이상
            String strN = Integer.toString(n);
            int length = strN.length();
            for (int i = 0; i <= length - 3; ++i) {
                for (int j = i + 1; j <= length - 2; ++j) {
                    //3개로 나누기 완전탐색
                    String str1 = strN.substring(0, i + 1);
                    String str2 = strN.substring(i + 1, j + 1);
                    String str3 = strN.substring(j + 1, length);

                    int sum = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
                    sol(sum, cnt + getCnt(sum));
                }
            }
        }
    }

    private static int getCnt(int N) {
        int oddCnt = 0;
        while (N > 0) {
            int tmp = N % 10;
            if ((tmp % 2) == 1) oddCnt++;
            N /= 10;
        }
        return oddCnt;
    }
}
