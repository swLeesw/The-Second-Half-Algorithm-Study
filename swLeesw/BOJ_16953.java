import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(a, 1));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.first == b) {
                System.out.println(cur.second);
                return;
            }
            long next1 = cur.first * 2;
            if (next1 <= b) {
                queue.add(new Pair(next1, cur.second + 1));
            }

            long next2 = cur.first * 10 + 1;
            if (next2 <= b) {
                queue.add(new Pair(next2, cur.second + 1));
            }
        }

        System.out.println(-1);
    }
}

class Pair {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}
