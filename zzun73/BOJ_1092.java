import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(boxes, Collections.reverseOrder());

        int answer = 0;
        if (boxes[0] <= cranes[0]) {
            boolean[] isMoved = new boolean[M];
            int movedCount = 0;

            while (movedCount < M) {
                int craneIndex = 0;
                for (int i = 0; i < M; i++) {
                    if (craneIndex == N) {
                        break;
                    }
                    if (!isMoved[i] && cranes[craneIndex] >= boxes[i]) {
                        isMoved[i] = true;
                        craneIndex++;
                        movedCount++;
                    }
                }
                answer++;
            }

        } else {
            answer = -1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}