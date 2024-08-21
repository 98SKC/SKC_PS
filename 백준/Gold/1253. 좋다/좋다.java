import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int ans = 0;
        
        for(int i = 0; i < N; i++){
            int p1 = 0;
            int p2 = N - 1;
            
            while(p1 < p2){
                if(p2 == i) {
                    p2--;
                    continue;
                }
                if(p1 == i) {
                    p1++;
                    continue;
                }

                int sum = list[p1] + list[p2];
                
                if(sum > list[i]){
                    p2--;
                } else if(sum < list[i]){
                    p1++;
                } else {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}