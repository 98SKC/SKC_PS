import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        int a=0, b=0,c=0;
        int[] maxDp=new int[3];
        int[] minDp=new int[3];
        int[] beforeDp=new int[3];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	if(i==0) {
                maxDp[0]=a;
                maxDp[1]=b;
                maxDp[2]=c;
                minDp[0]=a;
                minDp[1]=b;
                minDp[2]=c;
        	}else {
        		
            	beforeDp[0]=maxDp[0];
            	beforeDp[2]=maxDp[2];
            	maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
    			maxDp[2] = Math.max(maxDp[1], maxDp[2]) +c;
    			maxDp[1] = Math.max(Math.max(maxDp[1], beforeDp[0]), beforeDp[2]) + b;
    			
    			
            	beforeDp[0]=minDp[0];
            	beforeDp[2]=minDp[2];
            	minDp[0] = Math.min(minDp[0], minDp[1]) + a;
            	minDp[2] = Math.min(minDp[1], minDp[2]) +c;
            	minDp[1] = Math.min(Math.min(minDp[1], beforeDp[0]), beforeDp[2]) + b;
        	}
        		        		        	        	
        }

        System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]))+" "+Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
    }
}