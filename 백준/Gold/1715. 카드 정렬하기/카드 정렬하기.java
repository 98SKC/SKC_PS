import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq=new PriorityQueue<>();
        
        for(int i=0;i<N;i++) {
        	pq.add(Long.parseLong(br.readLine()));
        }
        long a,b;
        long sum=0;
        if(pq.size()==1) {
        	System.out.println(0);
        	return;
        }
        while(pq.size()>1) {
        	a=pq.poll();
        	b=pq.poll();
        	sum+=a+b;
        	//System.out.println(a+"+"+b);
        	pq.add(a+b);
        	
        }
        
        System.out.println(sum);
    }
        
    
}