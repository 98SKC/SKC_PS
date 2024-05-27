import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        Deque<Integer> dq;
        boolean r;
        int N;
        int[] arr;
        String sub;
        String[] subArr;
        char c;
        StringBuilder sb=new StringBuilder();
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        for(int test_case=1;test_case<=T;test_case++) {
        	boolean isError=false;
        	String str=br.readLine();
        	N=Integer.parseInt(br.readLine());
        	arr=new int[N];
        	sub=br.readLine();
        	sub=sub.replace("[", "");
        	sub=sub.replace("]", "");
        	subArr=sub.split(",");
        	dq=new ArrayDeque<Integer>();
        	for(int i=0;i<N;i++) {
        		dq.add(Integer.parseInt(subArr[i]));
        	}
        	
        	r=false;
        	for(int i=0;i<str.length();i++) {
        		c=str.charAt(i);
        		if(c=='R') {
        			r=!r;
        		}else {
        			if(dq.isEmpty()) {
        				isError=true;
        				sb.append("error"+"\n");
        				break;
        			}
        			if(r) {
        				dq.pollLast();
        			}else{
        				dq.pollFirst();
        			}
        			
        		}
        		
        	}
    		if(!isError) {
    			sb.append("[");
    			while(!dq.isEmpty()) {
    				if(r) {
    					sb.append(dq.pollLast());
        				if(!dq.isEmpty()) {
        					sb.append(",");
        				}
    				}else {
    					sb.append(dq.pollFirst());
        				if(!dq.isEmpty()) {
        					sb.append(",");
        				}
    				}
    				
    			}
    			sb.append("]"+"\n");
    		}

        }
        System.out.println(sb);
    }
}