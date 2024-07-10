import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18513 {

    private static class Candi implements Comparable<Candi>{
        int poz;
        long cost;

        public Candi(int poz, long cost) {
            this.poz = poz;
            this.cost = cost;
        }

        @Override
        public int compareTo(Candi o) {
            return Long.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "Candi{" +
                    "poz=" + poz +
                    ", cost=" + cost +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long answer = 0;

        HashSet<Integer> hs = new HashSet<>();
        PriorityQueue<Candi> pq = new PriorityQueue<>();
        List<Integer> sam = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            hs.add(s);
            sam.add(s);
        }

        for (int i : sam) {
            if (!hs.contains(i - 1)) {
                hs.add(i - 1);
                pq.add(new Candi(i - 1, 1));
            }
            if (!hs.contains(i + 1)) {
                hs.add(i + 1);
                pq.add(new Candi(i + 1, 1));
            }
        }

        for (int i = 0; i < k; i++) {
            Candi candi = pq.poll();
            //System.out.println(answer);
            answer += candi.cost;

            if (!hs.contains(candi.poz - 1)) {
                pq.add(new Candi(candi.poz - 1, candi.cost + 1));
                hs.add(candi.poz - 1);
            }
            if (!hs.contains(candi.poz + 1)) {
                pq.add(new Candi(candi.poz + 1, candi.cost + 1));
                hs.add(candi.poz + 1);
            }
        }

        System.out.println(answer);
    }
}
