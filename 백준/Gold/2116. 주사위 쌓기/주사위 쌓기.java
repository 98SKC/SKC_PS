import java.io.*;
import java.util.*;

public class Main {
    static int max = -1, N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][6];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<6;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<6;i++) {
            search(1, i, 0);
        }
        
        bw.write(String.valueOf(max));	
        bw.flush();		
        bw.close();
        br.close();
    }

    static void search(int cnt, int bottom, int sum){
        
        int pair = pairCheck(bottom);
        int tempMax = -1;
        
        for(int i=0;i<6;i++){
            if(i == pair || i == bottom)
                continue;
            tempMax = Math.max(tempMax, arr[cnt-1][i]);
        }
        sum += tempMax;
       
        if(cnt == N){
            max = Math.max(max, sum);	
            return;
        }
        
        for(int i=0;i<6;i++){
            if(arr[cnt-1][pair] == arr[cnt][i]){
                search(cnt+1, i, sum);
                break;
            }
        }
    }
    
    static int pairCheck(int n){
        if(n == 0)
            return 5;
        else if(n == 1)
            return 3;
        else if(n == 2)
            return 4;
        else if(n == 3)
            return 1;
        else if(n == 4)
            return 2;
        else
            return 0;
    }
}