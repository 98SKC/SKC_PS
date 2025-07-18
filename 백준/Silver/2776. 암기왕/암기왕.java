import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T=Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	int N;
    	HashSet<Integer> set;    	
    	StringBuilder sb=new StringBuilder();
    	for(int t=1;t<=T;t++) {
    		set=new HashSet<>();
    		N=Integer.parseInt(br.readLine());
    		st=new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		set.add(Integer.parseInt(st.nextToken()));
        	}
        	int M=Integer.parseInt(br.readLine());
        	
        	st=new StringTokenizer(br.readLine());
        	int sub;
        	for(int i=0;i<M;i++) {
        		sub=Integer.parseInt(st.nextToken());
        		if(set.contains(sub)) {
        			sb.append(1+"\n");
        		}else {
        			sb.append(0+"\n");
        		}
        	}
    	}
    	

    	System.out.println(sb);
    }
}