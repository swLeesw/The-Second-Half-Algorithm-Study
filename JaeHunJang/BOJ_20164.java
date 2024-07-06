import java.io.BufferedReader;
import java.io.InputStreamReader;

// 홀수 홀릭 호석 / 120분
public class BOJ_20164 {
    static int num, min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        num = Integer.parseInt(N);

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(N, 0);
        System.out.println(min + " " + max);
    }

    static void dfs(String n, int sum) {
        int cnt = count(n);
        int len = n.length();
        if (len == 1){
            min = Math.min(min, sum + cnt);
            max = Math.max(max, sum + cnt);
            return;
        } else if (len == 2) {
            int n1 = n.charAt(0) - '0';
            int n2 = n.charAt(1) - '0';
            int next = n1 + n2;
            dfs(next+"", sum + cnt);
        } else {
            for (int i = 1; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {
                    int n1 = Integer.parseInt(n.substring(0, i));
                    int n2 = Integer.parseInt(n.substring(i, j));
                    int n3 = Integer.parseInt(n.substring(j));
                    int next = n1 + n2 + n3;
                    dfs(next+"", sum + cnt);
                }
            }
        }
    }

    static int count(String N) {
        int cnt = 0;
        for(char ch : N.toCharArray()) {
            if ((ch - '0') % 2 == 1) cnt++;
        }

        return cnt;
    }
}