import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1092 {
    static int N,M;
    static int[] weightLimits;
    static List<Integer> boxWeights = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        weightLimits = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weightLimits[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int boxWeight= Integer.parseInt(st.nextToken());
            boxWeights.add(boxWeight);
        }
        Arrays.sort(weightLimits);
        Collections.sort(boxWeights);
        if(boxWeights.get(M-1)>weightLimits[N-1]){
            System.out.println(-1);
            return;
        }
        int time = 0;
        while (true){
            time++;
            int index = boxWeights.size()-1;
            for (int i = N-1; i >=0 ; i--) {
                int crane = weightLimits[i];

                if(boxWeights.get(index)<=crane){
                    boxWeights.remove(index);
                    if(boxWeights.isEmpty()){
                        System.out.println(time);
                        return;
                    }
                    index--;
                    if(index<0) break;
                }
                else{
                    index--;
                    if(index<0)break;
                    i++;
                }
            }
        }

    }
}
