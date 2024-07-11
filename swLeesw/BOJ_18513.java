import java.util.*;
import java.io.*;


public class Main {


    static class Info {
        int num, dis;

        public Info(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    static int n, k;
    static long sol;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Info> que = new ArrayDeque<>();
        set = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int samter = Integer.parseInt(st.nextToken());
            que.offer(new Info(samter, 0));
            set.add(samter);
        }

        while (!que.isEmpty()) {


            Info cur = que.poll();

            if (!set.contains(cur.num + 1)) {
                que.offer(new Info(cur.num + 1, cur.dis + 1));
                set.add(cur.num + 1);
                sol += cur.dis + 1;
                k--;
            }
            if (!set.contains(cur.num - 1)) {
                que.offer(new Info(cur.num - 1, cur.dis + 1));
                set.add(cur.num - 1);
                sol += cur.dis + 1;
                k--;
            }
            if (k <= 0) break;

        }

        System.out.println(sol);

    }

}
