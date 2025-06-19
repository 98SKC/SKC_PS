
import java.util.*;
import java.io.*;

public class Main {

	//1조
	//N: 1000000000000
	//public static int[] arr;
	public static long N;
	public static int P,Q;
    public static HashMap<Long,Long> map=new HashMap<>();
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Long.parseLong(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        
        //arr=new int[N+1];
        //arr[0]=1;
        map.put((long) 0,(long) 1);
        //  i번째 수는= i/P번의 수 + i/Q의 수
        
        System.out.println(find(N));
    }
    
    public static long find(long n) {

    	
    	long p;
    	long q;
    	if(map.containsKey(n)) return map.get(n);
    	
    	
    	if(!map.containsKey(n/P)) {
    		map.put(n/P, find(n/P));
    	}
    	
    	p=map.get(n/P);

    	if(!map.containsKey(n/Q)) {
    		map.put(n/Q, find(n/Q));
    	}
    	
    	q=map.get(n/Q);
    	return p+q;
    	
    }
    
    
}
