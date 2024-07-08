import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20164 {
    private static class Step {
        long value;
        int count;

        public Step(long value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Step{" +
                    "value=" + value +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int count = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        char[] nArr = ("" + N).toCharArray();
        for (int i = 0; i < nArr.length; i++) {
            if ((nArr[i] - '0') % 2 == 1)
                count++;
        }

        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(N, count));

        while (!queue.isEmpty()) {
            Step now = queue.poll();
            //System.out.println(now);
            if (now.value < 10) {
                minValue = Math.min(minValue, now.count);
                maxValue = Math.max(maxValue, now.count);
            } else if (now.value < 100) {
                long nxtValue = now.value / 10 + now.value % 10;
                int nxtCount = now.count
                        + ((nxtValue / 10) % 2 == 1 ? 1 : 0)
                        + ((nxtValue % 10) % 2 == 1 ? 1 : 0);
                queue.add(new Step(nxtValue, nxtCount));
            } else {
                String tmp = "" + now.value;
                for (int i = 1; i < tmp.length() - 1; i++) {
                    for (int j = i + 1; j < tmp.length(); j++) {
                        long nxtValue = Long.valueOf(tmp.substring(0, i)) + Long.valueOf(tmp.substring(i, j)) + Long.valueOf(tmp.substring(j));
                        int nxtCount = now.count;
                        char[] tmp2 = ("" + nxtValue).toCharArray();
                        for (int k = 0; k < tmp2.length; k++) {
                            if ((tmp2[k] - '0') % 2 == 1)
                                nxtCount++;
                        }
                        queue.add(new Step(nxtValue, nxtCount));
                    }
                }
            }
        }
        System.out.println(minValue + " " + maxValue);
    }
}
