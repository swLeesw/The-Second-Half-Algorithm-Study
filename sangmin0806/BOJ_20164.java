import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
    static String N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        divide(N);
        System.out.println(min+" "+max);

    }
    public static void divide(String input){

        if(input.length()==1) {
            if(Integer.parseInt(input)%2==1)answer++;
            min = Math.min(min,answer);
            max = Math.max(max,answer);
            if(Integer.parseInt(input)%2==1)answer--;

        }
        else if(input.length()==2){
            int num1 = input.charAt(0)-'0';
            int num2 = input.charAt(1)-'0';
            String str = String.valueOf(num1+num2);
            if(num1%2==1)answer++;
            if(num2%2==1)answer++;
            divide(str);
            if(num1%2==1)answer--;
            if(num2%2==1)answer--;
        }
        else {
            int len = input.length();
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                int num = input.charAt(i)-'0';
                if(num%2==1)count++;
            }
            for (int i = 1; i < len-1; i++) {
                String str1 = input.substring(0,i);
                for (int j = i+1; j < len; j++) {
                    String str2 = input.substring(i,j);
                    String str3 = input.substring(j,len);
                    int sum = Integer.parseInt(str1)+Integer.parseInt(str2)+Integer.parseInt(str3);;
                    String ssum = String.valueOf(sum);

                    answer+=count;
                    divide(ssum);
                    answer-=count;

                }

            }
        }
    }
}
