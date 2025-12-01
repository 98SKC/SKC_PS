

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //주어진 목적지 후보들 중 불가능한 경우를 제외한 목적지들을 오름차순으로 알아낸다.
        //s에서 출발했다는 정보와 목적지 후보들이 주어진다.
        //목적지까지 최단거리로 갈 것
        
        //지나갔을 g와 h교차로 사이의 도로? 가 주어짐
        
        //s를 시작점으로 , g-h 간선을 무조건 포함하는 루트를 가진 최단거리의 노드를 구하라
        
        

        int T=Integer.parseInt(br.readLine());
        
        int N,M,C;
        int S,G,H;
        int A,B,D;
        int momory=-1;
        
        StringTokenizer st;

        boolean[] v;
        int[] dijk;
        int[] distViaGH;
        int[] distViaHG;
        ArrayList<int[]>[] edges;
        
        
        for(int test_case=1;test_case<=T;test_case++){
        	momory=-1;
        	st=new StringTokenizer(br.readLine());
            
            N=Integer.parseInt(st.nextToken()); // 노드 개수
            M=Integer.parseInt(st.nextToken()); // 간선 개수
            C=Integer.parseInt(st.nextToken()); // 목적지 후보 개수
            
            //v=new boolean[N+1];
            edges=new ArrayList[N+1];
            dijk=new int[N+1];
            distViaGH=new int[N+1];
            distViaHG=new int[N+1];
            
            for(int i=1;i<=N;i++) {
            	edges[i]=new ArrayList<>();
            }
            

            st=new StringTokenizer(br.readLine());
            
            S=Integer.parseInt(st.nextToken()); // 출발지 노드
            G=Integer.parseInt(st.nextToken()); // 무조건 지나는 간선 엣지 1
            H=Integer.parseInt(st.nextToken()); // 무조건 지나는 간선 엣지 2
            
            
            //
            
            
            for(int i=0;i<M;i++) {
            	st=new StringTokenizer(br.readLine());
                A=Integer.parseInt(st.nextToken()); // A 노드와
                B=Integer.parseInt(st.nextToken()); // B 노드 사이에
                D=Integer.parseInt(st.nextToken()); // D 길이의 간선이 존재한다.
                
                if((A==G&&B==H)||(A==H&&B==G)) momory=D;
                
                edges[A].add(new int[] {B,D});
                edges[B].add(new int[] {A,D});

            }
            
            ArrayList<Integer> candidate=new ArrayList<>(); 
            
            for(int i=0;i<C;i++) {
            	candidate.add(Integer.parseInt(br.readLine()));
            }
            
            Collections.sort(candidate);
            
            
            //후보들 중 불가능한 경우를 제외하는 방법 = G-H를 거치지 않고 최단으로 갈 수 있는 곳들
            
            //g-h를 거치고 다른 노드들을 도달하는 경우와,
            //그냥 bfs를 했을 때 를 비교해서 그냥이 더 짧으면 제외.
            
            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            	@Override
            	public int compare(int[] o1, int[] o2) {
            		return Integer.compare(o1[1], o2[1]);
            	}
            });
            
            int[] p;
            int n,d;
            //1. 일반적인 다익스트라.
            

            
            v=new boolean[N+1];
            pq.add(new int[] {S,0});

            for(int i=1;i<=N;i++) {
            	dijk[i]=100000000;
            }
            
            dijk[S]=0;
            
            while(!pq.isEmpty()) {
            	
            	p=pq.poll();
            	
            	v[p[0]]=true;
            	
            	for(int[] next:edges[p[0]]){
            		
            		//if(v[next[0]]) continue; // 이 조건이 다익스트라 들어가던가 기억이 안나네
            		n=next[0];// 다음 노드
            		d=next[1];// 다음 노드까지 거리
            		
            		if(dijk[n]>p[1]+d){
            			dijk[n]=p[1]+d;
            			pq.add(new int[] {n,dijk[n]});
            		}
            	}
            	
            }
            
            
            //2. G를 거쳐 H에 도달 후 다익스트라
            pq.clear();
            v=new boolean[N+1];
            
            pq.add(new int[] {H,dijk[G]+momory});
            
            for(int i=1;i<=N;i++) {
            	distViaGH[i]=100000000;
            }
            
            distViaGH[H]=dijk[G] + momory;
            
            while(!pq.isEmpty()) {
            	
            	p=pq.poll();
            	
            	v[p[0]]=true;
            	
            	for(int[] next:edges[p[0]]){
            		
            		//if(v[next[0]]) continue; // 이 조건이 다익스트라 들어가던가 기억이 안나네
            		n=next[0];// 다음 노드
            		d=next[1];// 다음 노드까지 거리
            		
            		if(distViaGH[n]>p[1]+d){
            			distViaGH[n]=p[1]+d;
            			pq.add(new int[] {n,distViaGH[n]});
            		}
            	}
            	
            }
            
            
            //3. H를 거쳐 G에 도달 후 다익스트라
            pq.clear();
            v=new boolean[N+1];
            
            pq.add(new int[] {G,dijk[H]+momory});
            
            for(int i=1;i<=N;i++) {
            	distViaHG[i]=100000000;
            }
            
            distViaHG[G]=dijk[H] + momory;
            
            while(!pq.isEmpty()) {
            	
            	p=pq.poll();
            	
            	v[p[0]]=true;
            	
            	for(int[] next:edges[p[0]]){
            		
            		//if(v[next[0]]) continue; // 이 조건이 다익스트라 들어가던가 기억이 안나네
            		n=next[0];// 다음 노드
            		d=next[1];// 다음 노드까지 거리
            		
            		if(distViaHG[n]>p[1]+d){
            			distViaHG[n]=p[1]+d;
            			pq.add(new int[] {n,distViaHG[n]});
            		}
            	}
            	
            }
            
            
    		for(int c:candidate) {
    			if(!v[c]) continue; //혹시라도 도달 못할 노드가 있음을 대비
    			if(dijk[c]>=distViaGH[c]||dijk[c]>=distViaHG[c]) sb.append(c+" ");
            }
    		
            sb.append("\n");
        }
        
       

        
        System.out.println(sb);

    
    }
        
}


