
import java.util.*;
import java.io.*;

public class Main {

	public static Long N,P,Q,X,Y;
	public static HashMap<Long,Long> map=new HashMap<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        N=Long.parseLong(st.nextToken());
        P=Long.parseLong(st.nextToken());
        Q=Long.parseLong(st.nextToken());
        X=Long.parseLong(st.nextToken());
        Y=Long.parseLong(st.nextToken());
        

        System.out.println(find(N));
 
    }
    
    
    public static long find(long n) {
    	long answer=0;
    	if(n<=0) return 1;
    	//System.out.println(n+"의 값을 구함");
    	if(map.containsKey(n)) return map.get(n);
    	
    	
    	long left=(n/P)-X;
    	long right=(n/Q)-Y;
    	
    	long l,r;
    	if(!map.containsKey(left)) {
    		map.put(left, find(left));
    	}
    	l=map.get(left);
    	
    	if(!map.containsKey(right)) {
    		map.put(right, find(right));
    	}
    	r=map.get(right);
    	
    	//System.out.println(n+"의 값은: "+(l+r));
    	return l+r;
 
    	
    }
}
