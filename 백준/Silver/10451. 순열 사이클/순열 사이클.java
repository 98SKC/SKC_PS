

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        int N;
        int[] edge;
        
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        boolean[] v;
        ArrayDeque<Integer> q;
        int count;
        int sub;
        for(int test_case=1;test_case<=T;test_case++) {
        	N=Integer.parseInt(br.readLine());
        	edge=new int[N+1];
        	count=0;
        	q=new ArrayDeque<>();
        	v=new boolean[N+1];
        	st=new StringTokenizer(br.readLine());
        	for(int i=1;i<=N;i++) {
        		edge[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i=1;i<=N;i++) {
        		if(v[i]) continue;
        		q.add(i);
        		while(!q.isEmpty()) {
        			sub=q.poll();
        			v[sub]=true;
        			if(!v[edge[sub]]) q.add(edge[sub]);
        		}
        		count++;
        	}
        	sb.append(count+"\n");
        }
        
        System.out.println(sb);
        
    }
        
}


