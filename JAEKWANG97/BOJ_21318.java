import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //, 1번부터 N번까지의 번호로 부른다.
    // 1 이상 109 이하의 정수로 표현되는 난이도
    // 1 ≤ x ≤ y ≤ N
    // 지금 연주하는 악보가 바로 다음에 연주할 악보보다 어렵다면 실수를 한다
    // , 마지막으로 연주하는 y번 악보에선 절대 실수하지 않는다

    private static int N;
    private static int[] arr;
    private static int Q;
    private static Node[] nodeArr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int[] prefixSumArr;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Q = Integer.parseInt(br.readLine());
        nodeArr = new Node[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodeArr[i] = new Node(x, y);
        }

        prefixSumArr = new int[N];

        for (int i = 1; i < N; i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + confirmMusic(i-1, i);
        }

//        System.out.println(Arrays.toString(prefixSumArr));
    }

    private static void solve() throws IOException {
        for (int i = 0; i < Q; i++) {
            Node curNode = nodeArr[i];
            int curX = curNode.x;
            int curY = curNode.y;
            sb.append(prefixSumArr[curY - 1] - prefixSumArr[curX - 1]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int confirmMusic(int cur, int next){
        if(arr[cur] <= arr[next]){
            return 0;
        }else{
            return 1;
        }
    }
}
