import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20164 {
    static int MAX = 0 ;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> num = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            num.add(str.charAt(i)-'0');
            if(num.get(i)%2==1) cnt++;
        }
        recur(num,0);
        System.out.println(MIN+" "+MAX);
    }
    static void recur(List<Integer> num, int cnt){
        cnt+=cnt(num);
        if(num.size()==1){
            MAX = Math.max(MAX,cnt);
            MIN = Math.min(MIN,cnt);
            return;
        }else if(num.size()==2){
            int sum = num.get(0) + num.get(1);
            num.add(sum);
            List<Integer> tmp = new ArrayList<>();
            String str = Integer.toString(sum);
            for(int i=0;i<str.length();i++){
                tmp.add(str.charAt(i)-'0');
            }
            recur(tmp,cnt);
        }else{
            for(int i=1;i<num.size()-1;i++){
                for(int j = i+1;j<num.size();j++){
                    int k = cut(i,j,num);
                    recur(toArr(k),cnt);
                }
            }
        }

    }
    static private int cut(int first, int second, List<Integer> num){
        int total = 0;
        total+=getNum(0,first,num);
        total+=getNum(first,second,num);
        total+=getNum(second,num.size(),num);
        return total;
    }
    static private int getNum(int start,int end, List<Integer> num){
        int sum = 0;
        for(int i=start;i<end;i++){
            if(i==0){
                sum+=num.get(i);
            }else{
                sum*=10;
                sum+=num.get(i);
            }
        }
        return sum;
    }
    static List<Integer> toArr(int num){
        List<Integer> arr = new ArrayList<>();
        String str = Integer.toString(num);
        for(int i=0;i<str.length();i++){
            arr.add(str.charAt(i)-'0');
        }
        return arr;
    }
    static int cnt(List<Integer> num){
        int c = 0;
        for(int i=0;i<num.size();i++){
            if(num.get(i)%2==1) c++;
        }
        return c;
    }
}
