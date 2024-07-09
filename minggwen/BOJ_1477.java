import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1477 {
    static int N,M,L;
    static List<Integer> diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        List<Integer> nums = new ArrayList<>();
        diff = new ArrayList<>();
        
        if(N>0) {
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++){
                nums.add(Integer.parseInt(st.nextToken()));
            }
        	
        }
        
        nums.add(0);
        nums.add(L);
        Collections.sort(nums);
        for (int j = 1; j < nums.size(); j++) {
            diff.add(nums.get(j)-nums.get(j-1));
        }
        
        Collections.sort(diff);
        int left = 1;
        int right = L;
        int mid = 0;
        int answer = L;
        while(left<=right){
            mid = (left+right)/2;
            if(cnt(mid)<=M){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
    private static int cnt(int num){
        int cnt = 0;
        for(int n:diff){
        	if (n > num) {
                cnt += (n - 1) / num;
            }
        }
        return cnt;
    }
}
