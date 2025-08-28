

import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<int[]>[] roads;
	public static int N,M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        
        roads=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	roads[i]=new ArrayList<>();
        }
        
        StringTokenizer st;
        int start, end, cost;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	cost=Integer.parseInt(st.nextToken());
        	roads[start].add(new int[] {end, cost});
        }
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[] {1,0});
        int[] dp=new int[N+1];
        
        int[] p;
        int[] prev=new int[N+1];
        //문제는 경로를 기억해야한다.
        while(!q.isEmpty()) {
        	p=q.poll();
        	start=p[0];
        	cost=p[1];
        	
        	if(dp[start]>cost) continue;
        	for(int[] next: roads[start]) {
        		if(dp[next[0]]<cost+next[1]) {
        			dp[next[0]]=cost+next[1];
        			prev[next[0]]=start;
        			if(next[0]!=1)q.add(new int[] {next[0],dp[next[0]]});
        		}
        		
        	}
        	
        }

        
        int pos=prev[1];
        StringBuilder sb=new StringBuilder();
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        while(pos!=1) {
        	list.add(pos);
        	pos=prev[pos];
        }
        
        list.add(1);
        Collections.reverse(list);
        for(int next: list) {
        	sb.append(next+" ");
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[1]);
        System.out.println(sb);
    }
}
