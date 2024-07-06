import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {

    private static int N;

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        cutNumber(N, 0);

        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static void cutNumber(int n, int cnt) {
        cnt += countOddNumber(n);

        if (n / 10 == 0) {
            min = Integer.min(min, cnt);
            max = Integer.max(max, cnt);
        }
        else if (n / 100 == 0) {
            int next = n / 10;
            next += n % 10;
            cutNumber(next, cnt);
        }
        else {
            String str = String.valueOf(n);
            for (int i = 0; i < str.length() - 2; i++) {
                for (int j = i+1; j < str.length() - 1; j++) {
                    int next = Integer.parseInt(str.substring(0, i+1));
                    next += Integer.parseInt(str.substring(i+1, j+1));
                    next += Integer.parseInt(str.substring(j+1));

                    cutNumber(next, cnt);
                }
            }
        }
    }

    private static int countOddNumber(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n % 10;
            if (tmp % 2 == 1) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }

    private static void printAnswer() {
        System.out.println(min + " " + max);
    }
}

