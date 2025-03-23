
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int N;
        long answer=0;
        int[] arr;
        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++) {
        	st=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(st.nextToken());
        	arr=new int[N];
        	for(int i=0;i<N;i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        	}
        	answer=0;
        	for(int i=0;i<N-1;i++){
        		for(int j=i+1;j<N;j++) {
        			answer+=euclidean(arr[i],arr[j]);
        		}
        	}
        	sb.append(answer+"\n");
        }

        System.out.println(sb);
        
    }
    
    public static int euclidean(int a,int b) {
    	int big=a;
    	int small=b;
    	
    	if(big<small) {
    		int tmp=big;
    		big=small;
    		small=tmp;
    	}
    	
    	int mod=-1;
    	
    	while(mod!=0) {
    		mod=big%small;
    		big=small;
    		small=mod;
    	}
    	
    	return big;
    }
}
