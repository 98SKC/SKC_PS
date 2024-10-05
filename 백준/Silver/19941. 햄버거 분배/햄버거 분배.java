import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int N=Integer.parseInt(st.nextToken());
    	int K=Integer.parseInt(st.nextToken());
    	
    	String str=br.readLine();
    	char[] table=new char[N];
    	boolean[] c=new boolean[N];
    	for(int i=0;i<N;i++) {
    		table[i]=str.charAt(i);
    	}
    	int start,end;
    	int answer=0;
    	for(int i=0;i<N;i++) {
    		if(table[i]=='P') {
    			start=(i-K>=0)?i-K:0;
    			end=(i+K<N)?i+K:N-1;
    			for(int j=start;j<=end;j++) {
    				if(table[j]=='H'&&!c[j]) {
    					c[j]=true;
    					answer++;
    					break;
    				}
    			}
    			
    		}
    	}
    	System.out.println(answer);
    	
    	
    }
}