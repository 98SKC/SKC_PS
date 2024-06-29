import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[] map=new int[N+1];
        int[] prefix=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	map[i]=Integer.parseInt(st.nextToken());
   
        }
        int start,end,H;
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            prefix[start]+=H;
            if(end<N) prefix[end+1]-=H;
            
        }
        
        for(int i=1;i<=N;i++) {
   
        	prefix[i]+=prefix[i-1];
        	
        }
        
        for(int i=1;i<=N;i++) {
	   
        	System.out.print((map[i]+prefix[i])+" ");
        }
        
    }
}