import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1092 {

    private static int N, M;
    private static List<Integer> cranes, boxes;

    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        moveBoxes();

        printAnswer();
    }

    private static void moveBoxes() {
        if (cranes.get(0) < boxes.get(0)) {
            answer = -1;
            return;
        }

        while (!boxes.isEmpty()) {
            int craneIdx = 0;
            int boxIdx = 0;

            while (craneIdx < N) {
                Integer crane = cranes.get(craneIdx);
                Integer box = boxes.get(boxIdx);

                if (crane >= box) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }

                if (boxIdx == boxes.size()) {
                    break;
                }
            }

            answer++;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cranes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort((i1, i2) -> i2 - i1);
        boxes.sort((i1, i2) -> i2 - i1);
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
