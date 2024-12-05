import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        long[] prefix=new long[N+1];
        int[] num=new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	num[i]=Integer.parseInt(st.nextToken());
        	prefix[i]=prefix[i-1]+num[i];
        }
        long answer=0;
        for(int i=1;i<=N;i++) {
        	answer+=num[i]*(prefix[N]-prefix[i]);
        }
        System.out.println(answer);
        
    }
}