import java.io.*;
import java.util.*;
 
public class Main {

    public static void main(String[] args) throws IOException{
        int N, M;
	    int[] arr;
	    int[] prefixSum;
	    long answer = 0;
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()); 	
 
    	N = Integer.parseInt(st.nextToken());
    		
    	int sumValue = 0;
    	prefixSum = new int[N+1];
    	st = new StringTokenizer(br.readLine());
        
    	for(int i=0;i<N;i++) {
    		sumValue += Integer.parseInt(st.nextToken());
    		prefixSum[i+1] = sumValue;
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		System.out.println(prefixSum[b] - prefixSum[a-1]);
    	}
    }
}