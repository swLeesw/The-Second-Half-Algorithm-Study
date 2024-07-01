package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(box.get(0) > crane.get(0)){
            System.out.println(-1);
            return;
        }

        int answer = 0;

        while(!box.isEmpty()){
            int boxIndex = 0;
            int craneIndex = 0;

            while(craneIndex < n){
                if(boxIndex == box.size()){
                    break;
                } else if(crane.get(craneIndex) >= box.get(boxIndex)){
                    box.remove(boxIndex);
                    craneIndex++;
                }else{
                    boxIndex++;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }//main end
}//class end
