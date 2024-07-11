import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //샘터의 수
        int K = Integer.parseInt(st.nextToken()); //지을 집의 수
        Set<Integer> select = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N ; i++){
            int x = Integer.parseInt(st.nextToken())+100100000;
            q.add(new int[] {x,0});
            select.add(x);
        }
        int answer = 0;
        while(K!=0 && !q.isEmpty()){
            int[] cur = q.poll();
            if(!select.contains(cur[0]-1)){
                q.add(new int[] {cur[0]-1,cur[1]+1});
                select.add(cur[0]-1);
                K--;
                answer+=(cur[1]+1);
            }
            if(K==0) break;
            if(!select.contains(cur[0]+1)){
                q.add(new int[] {cur[0]+1, cur[1]+1});
                select.add(cur[0]+1);
                K--;
                answer+=(cur[1]+1);
            }

        }
        System.out.println(answer);


    }

}
