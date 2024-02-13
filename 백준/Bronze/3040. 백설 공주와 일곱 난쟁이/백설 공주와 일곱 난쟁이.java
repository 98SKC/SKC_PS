import java.io.*;
import java.util.*;

public class Main {

	static int[] arr=new int[9], answer=new int[7];
	static StringBuilder sb=new StringBuilder();
	static boolean end;
	
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int i=0;i<9;i++) {
    		arr[i]=Integer.parseInt(br.readLine());
    	}
    	comb(0,0,0);
    	System.out.println(sb);
    }
    
    static void comb(int start,int cnt, int sum) {

    	if(cnt==7&&sum==100) {
    		for(int a:answer) {
    			sb.append(a).append("\n");

    		}
    		end=true;
    	}
    	
    	if(cnt>=7||sum>=100) {
    		return;
    	}
    	
    	for(int i=start;i<9;i++) {
    		answer[cnt]=arr[i];
    		comb(i+1,cnt+1,sum+arr[i]);
    		if(end) return;
    	}
    }
}