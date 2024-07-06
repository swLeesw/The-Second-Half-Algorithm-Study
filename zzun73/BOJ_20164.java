import java.io.*;

public class BOJ_20164 {
    static int minAnswer, maxAnswer;

    static void helper(int num, int count) {
        count += countOddNum(num);

        if (num < 10) {
            minAnswer = Math.min(minAnswer, count);
            maxAnswer = Math.max(maxAnswer, count);
            return;
        }

        if (num < 100) {
            int first = num / 10;
            int second = num % 10;
            helper(first + second, count);
        } else {
            String str = String.valueOf(num);
            for (int i = 1; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    int first = Integer.parseInt(str.substring(0, i));
                    int second = Integer.parseInt(str.substring(i, j));
                    int third = Integer.parseInt(str.substring(j));
                    helper(first + second + third, count);
                }
            }
        }
    }

    static int countOddNum(int num) {
        int count = 0;
        while (num > 0) {
            if ((num % 10) % 2 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        minAnswer = Integer.MAX_VALUE;
        maxAnswer = Integer.MIN_VALUE;
        helper(N, 0);

        sb.append(minAnswer).append(" ").append(maxAnswer);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}