import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());
        
        int[] dist=new int[N+1];
        int[] revers=new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(revers, Integer.MAX_VALUE);

        ArrayList<int[]>[] list=new ArrayList[N+1];
        ArrayList<int[]>[] Rlist=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        	Rlist[i]=new ArrayList<>();
        }
        
        int start,end,cost;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	cost=Integer.parseInt(st.nextToken());
        	list[start].add(new int[] {end,cost});
        	Rlist[end].add(new int[] {start,cost});	
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]); // 인덱스 1을 기준으로 오름차순 정렬
            }
        });
        // 각 점에서 M까지의 최소거리 -> m까지 가는  간선 방향을 역으로 하여 M에서 출발하도록
        int[] node;
        boolean[] v=new boolean[N+1];
        pq.add(new int[] {X,0});
        while(!pq.isEmpty()){
        	node=pq.poll();
        	if(v[node[0]]) continue;
        	v[node[0]]=true;
        	for(int[] next:Rlist[node[0]]) {//Rlist[node[0]]에는 0에서 갈 수 있는 점과 거리
        		if(revers[next[0]]>next[1]+node[1]) {
        			revers[next[0]]=next[1]+node[1];
        			pq.add(new int[] {next[0],revers[next[0]]});
        		}
        	}
        	
        }
        
        v=new boolean[N+1];
        // M에서 각 점까지의 최소거리 
        pq.add(new int[] {X,0});
        while(!pq.isEmpty()){
        	node=pq.poll();
        	if(v[node[0]]) continue;
        	v[node[0]]=true;
        	for(int[] next:list[node[0]]) {//Rlist[node[0]]에는 0에서 갈 수 있는 점과 거리
        		if(dist[next[0]]>next[1]+node[1]) {
        			dist[next[0]]=next[1]+node[1];
        			pq.add(new int[] {next[0],dist[next[0]]});
        		}
        	}
        	
        }
        dist[X]=0;
        revers[X]=0;
        int max=0;
        for(int i=1;i<=N;i++) {
        	max=Math.max(max, dist[i]+revers[i]);
        }
        System.out.println(max);
        

        
    }
}