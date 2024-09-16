import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
       
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	int T=Integer.parseInt(br.readLine());
    	int n,d,c;
    	StringTokenizer st;
    	for(int test_case=1;test_case<=T;test_case++) {
    		st=new StringTokenizer(br.readLine());
    		n=Integer.parseInt(st.nextToken());
    		d=Integer.parseInt(st.nextToken());
    		c=Integer.parseInt(st.nextToken());
    		int[] dist=new int[n+1];
    		boolean[] v=new boolean[n+1];
    		ArrayList<int[]>[] list=new ArrayList[n+1];
    		for(int i=1;i<=n;i++) {
    			list[i]=new ArrayList<>();
    		}
    		int a,b,s;
    		int count=0;
    		
    		for(int i=1;i<=n;i++) {
    			dist[i]=Integer.MAX_VALUE;
    		}
    		
    		dist[c]=0;
    		
    		for(int i=0;i<d;i++) {
    			st=new StringTokenizer(br.readLine());
    			a=Integer.parseInt(st.nextToken());
    			b=Integer.parseInt(st.nextToken());
    			s=Integer.parseInt(st.nextToken());
    			list[b].add(new int[] {a,s});// b와 연결된 a로 가는 간선 값이 s
    			
    		}
    		
    		 int max=0;
    		 PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));

    		 pq.add(new int[] {c,0});// 이 정점까지 최소 거리로 들어옴
    		 while(!pq.isEmpty()) {
    			 
    			 int[] sub=pq.poll();
    			 if(v[sub[0]]) continue;
    			 v[sub[0]]=true;
    			 count++;
    			 
    			 max=Math.max(max, sub[1]);
    			 for(int[] next:list[sub[0]]) {
    				 //next[0] 지금 노드에서 갈 수 있는 다음 노드
    				 //next[1] 그 노드로 연결된 간선 값
    				 if(v[next[0]]) continue;
    				 if(dist[next[0]]>dist[sub[0]]+next[1]) {
    					 dist[next[0]]=dist[sub[0]]+next[1];
    					 pq.add(new int[] {next[0],dist[sub[0]]+next[1]});
    				 }
    			 }

    		 }
    		 sb.append(count+" "+max+"\n"); 

    	}
		System.out.println(sb);
    
    }
}