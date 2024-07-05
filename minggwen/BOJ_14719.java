import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int columns[] = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int w=0;w<W;w++){
            columns[w] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int h=H;h>=1;h--){
            boolean open = false;
            int water = 0;
            for(int w=0;w<W;w++){
                if(columns[w]>=h){
                    if(!open&&(w+1<W&&columns[w+1]<h))open = true;
                    else if(open){
                        if(w+1<W&&columns[w+1]<h){
                            cnt+=water;
                            water = 0;
                            continue;
                        }
                        cnt+=water;
                        water=0;
                        open = false;
                    }
                }else{
                    if(open)water++;
                }
            }
        }
        System.out.println(cnt);
    }
}
