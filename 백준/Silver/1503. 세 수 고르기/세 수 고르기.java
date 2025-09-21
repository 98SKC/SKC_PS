

import java.util.*;
import java.io.*;

public class Main {

	public static boolean[] v=new boolean[1002];
	public static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //M개의 자연수로 이루어진 집합S, 자연수 N이 주어진다.
        //S에 속하지 않는 자연수 x,y,z,를 골라서 |N-xyz|의 최솟값을 구하라.
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        

        st=new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++) {
        	v[Integer.parseInt(st.nextToken())]=true;
        }
        
        int answer=Integer.MAX_VALUE;
    	for (int i = 1; i <= 1000; i++) {
    		if (v[i])continue;
    		for (int j = i; j <= 1000; j++) {
    			if (v[j])continue;
    			for (int k = j; k <= 1001; k++) {
    				if (v[k])continue;
    				answer = Math.min(answer, Math.abs(N-i*j*k));
    			}
    		}
    	}
                                                                                
        System.out.println(answer);
    }
        
}


