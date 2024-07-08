import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
    static int N,M;
    static List<int[]> houses, chickens;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<int[]>();
        chickens = new ArrayList<>();
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    houses.add(new int[]{n,k});
                }else if(num==2){
                    chickens.add(new int[]{n,k});
                }
            }
        }
        comb(0,0,new int[M],new boolean[chickens.size()]);
        System.out.println(MIN);

    }
    private static void comb(int idx, int cnt, int arr[],boolean visited[]){
        if(cnt==M){
            int sum = 0;
            for(int i=0;i< houses.size();i++){
                int min = Integer.MAX_VALUE;
                for(int a:arr){
                    int num = Math.abs(houses.get(i)[0]-chickens.get(a)[0])+Math.abs(houses.get(i)[1]-chickens.get(a)[1]);
                    min = Math.min(min,num);
                }
                sum+=min;
            }
            MIN = Math.min(MIN,sum);
            return;
        }
        for(int i=idx;i<chickens.size();i++){
            if(visited[i])continue;
            visited[i]=true;
            arr[cnt] = i;
            comb(i,cnt+1,arr,visited);
            visited[i] = false;
            arr[cnt] = 0;
        }
    }
}
