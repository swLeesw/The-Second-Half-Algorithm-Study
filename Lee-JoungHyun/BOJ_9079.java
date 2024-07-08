import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char map[][] = new char[3][3];
            for (int y = 0; y < 3; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 3; x++) {
                    map[y][x] = st.nextToken().charAt(0);
                }
            }

            HashSet<String> visited = new HashSet<>();
            visited.add(makeString(map));
            Queue<String> queue = new LinkedList<>();
            queue.add(makeString(map));
            int answer = 0;

            while (!queue.isEmpty()) {
                int qsize = queue.size();
                while (qsize-- > 0) {

                }
                answer++;
            }


        }
    }

    public static String makeString(char[][] map) {
        String result = "";
        for (char[] y : map) {
            for (char x : y) {
                result += x;
            }
        }
        return result;
    }

    public static String[] nextStep(String tmp) {
        String[] result = new String[8];

        return result;
    }

    public static boolean check(char[][] map) {
        char flag = map[0][0];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (map[y][x] != flag) return false;
            }
        }
        return true;
    }

}
