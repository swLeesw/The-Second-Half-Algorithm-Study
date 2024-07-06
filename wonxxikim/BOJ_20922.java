import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N ;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int[] check = new int[100001];
        int cnt  = 1;
        Queue<Integer> q= new LinkedList<>();
        q.add(num[0]);
        check[num[0]] = 1;
        while(cnt!=N){
            check[num[cnt]]++;
            q.add(num[cnt]);
            if(check[num[cnt]]>K){
                while(true){
                    int x = q.poll();
                    check[x]--;
                    if(x==num[cnt]) break;
                }
            }

            max = Math.max(max,q.size());
            cnt++;
        }
        System.out.println(max);


    }
}
