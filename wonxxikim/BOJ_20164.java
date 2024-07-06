import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        String N = br.readLine();
        int[] cut = new int[2];
        combination(N.length(),0,1,findOdd(N), N, cut);
        System.out.println(min+" "+max);

    }
    static void combination(int type, int cnt, int start, int num, String N, int[] cut){
        if(type == 1){
            min = Math.min(min,num);
            max = Math.max(max,num);
            return;
        }
        if(type ==2 && cnt ==1){
            String a = "";
            String b = "";

            for(int i = 0 ; i<cut[0] ; i++){
                a+=N.charAt(i);
            }
            for(int i = cut[0] ; i<type ; i++){
                b+=N.charAt(i);
            }
            N = String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
            combination(N.length(),0,1,num+findOdd(N),N, new int[2]);
            return;
        }
        if(type >=3  && cnt ==2){
            String a = "";
            String b = "";
            String c = "";
            for(int i = 0 ; i<cut[0] ; i++){
                a+=N.charAt(i);
            }
            for(int i = cut[0] ; i<cut[1] ; i++){
                b+=N.charAt(i);
            }
            for(int i = cut[1] ; i<type ; i++){
                c+=N.charAt(i);
            }
            N = String.valueOf(Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c));
            combination(N.length(),0,1,num+findOdd(N),N, new int[2]);
            return;
        }
        for(int i = start ; i<type ; i++){
            cut[cnt] = i;
            combination(type,cnt+1,i+1, num, N, cut);
        }
    }
    static int findOdd(String N){
        int cnt = 0;
        for(int i = 0 ; i <N.length() ; i++){
            if(N.charAt(i)%2==1) cnt++;
        }
        return cnt;
    }
}
