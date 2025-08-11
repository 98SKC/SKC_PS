

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken()); //정점의 개수
        int E=Integer.parseInt(st.nextToken()); //도로의 개수
        //int[][] edge=new int[V+1][V+1];
        HashMap<Integer,Integer>[] edge=new HashMap[V+1];
        for(int i=1;i<=V;i++) {
        	edge[i]=new HashMap<>();
        }
        
        int u,v,w;
        for(int i=0;i<E;i++) {
        	st=new StringTokenizer(br.readLine());
        	//u v 사이 가중치 w의 도로가 존재. 간선은 여러가 있을 수 있다.
        	u=Integer.parseInt(st.nextToken());
        	v=Integer.parseInt(st.nextToken());
        	w=Integer.parseInt(st.nextToken());
//        	edge[u][v]=Math.max(edge[u][v], w);
//        	edge[v][u]=Math.max(edge[u][v], w);
        	if(edge[u].containsKey(v)) {
        		edge[u].put(v, Math.min(edge[u].get(v), w));
        	}else {
        		edge[u].put(v, w);
        	}
        	
        	if(edge[v].containsKey(u)) {
        		edge[v].put(u, Math.min(edge[v].get(u), w));
        	}else {
        		edge[v].put(u, w);
        	}
        	
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[1], o2[1]);
        	}
        });
        
        boolean[] isMac = new boolean[V + 1];
        boolean[] isStar = new boolean[V + 1];
        int[] mcdonalds=new int[V+1];
        for(int i=1;i<=V;i++) {
        	mcdonalds[i]=Integer.MAX_VALUE;
        }
        //ArrayList<Integer> mcdonalds=new ArrayList<>();
        //맥도널드 개수와 위치
        st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        int sub;
        for(int i=0;i<M;i++) {
        	sub=Integer.parseInt(st.nextToken());
            isMac[sub] = true;
        	mcdonalds[sub]=0;
        	pq.add(new int[] {sub,0});
        }
        int dis;
        int[] p;
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(p[1]>mcdonalds[p[0]]) continue;
        	for(int next: edge[p[0]].keySet()) {
        		//next가 다음 노드. 
        		dis=edge[p[0]].get(next);
        		if((p[1]+dis)<mcdonalds[next]&&(p[1]+dis)<=x) {
        			mcdonalds[next]=p[1]+dis;
        			pq.add(new int[] {next,mcdonalds[next]});
        		}
        		
        	}
        }
        
        
        st=new StringTokenizer(br.readLine());
        int S=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        
        //ArrayList<Integer> starbucks=new ArrayList<>();
        int[] starbucks=new int[V+1];
        for(int i=1;i<=V;i++) {
        	starbucks[i]=Integer.MAX_VALUE;
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
        	sub=Integer.parseInt(st.nextToken());
            isStar[sub] = true;
        	starbucks[sub]=0;
        	pq.add(new int[] {sub,0});
        }
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(p[1]>starbucks[p[0]]) continue;
        	for(int next: edge[p[0]].keySet()) {
        		//next가 다음 노드. 
        		dis=edge[p[0]].get(next);
        		if((p[1]+dis)<starbucks[next]&&(p[1]+dis)<=y) {
        			starbucks[next]=p[1]+dis;
        			pq.add(new int[] {next,starbucks[next]});
        		}
        		
        	}
        }
        int min=Integer.MAX_VALUE;
        int answer=-1;
        int sum;
        
       // System.out.println("맥: "+Arrays.toString(mcdonalds));
       // System.out.println("스: "+Arrays.toString(starbucks));
        for(int i=1;i<=V;i++) {
        	if(!isMac[i] && !isStar[i] &&mcdonalds[i]<=x&&starbucks[i]<=y&&min>(mcdonalds[i]+starbucks[i])) {
        		//System.out.println("후보: "+i+" "+mcdonalds[i]+" "+starbucks[i]);
        		min=mcdonalds[i]+starbucks[i];
        	}
        }
        if(min==Integer.MAX_VALUE)System.out.println(-1);										
        else System.out.println(min);
        
     
        
    }
}
