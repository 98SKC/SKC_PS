import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        int[] len = new int[N];
        int[] count = new int[21];
        long answer=0;
        
        
        for (int i = 0; i < N; i++) {
            len[i] = br.readLine().length();
            if (i <= K) {
                count[len[i]]++;
            }
        }
        
        answer = --count[len[0]];
        
        for (int i = 1; i < N; i++) {
            if (i + K < N) count[len[i + K]]++;
            answer += --count[len[i]];
        }
        
        
        System.out.print(answer); 
    }
}