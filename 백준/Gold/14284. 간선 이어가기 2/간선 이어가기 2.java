import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());//정점의 수
        int m=Integer.parseInt(st.nextToken());//간선의 수
        
        ArrayList<int[]>[] edge=new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
        	edge[i]=new ArrayList<>();
        }
        
        int a,b,c;
        
        //정점 n개, 0개의 간선으로 이루어진 무뱡향 그래프
        //m개의 가중치 간선리스트.
        //이 리스트의 간선을 하나씩 추가해간다. 
        //특정 정점 s와 t가 연결되는 시점에 추가를 멈춘다.
        //간선 가중치의 합이 최소가 되게 추가하도록 순서를 조정.
        //가중치 합의 최소값을 구하라
        
        //일반적인 다익스트라 문제로 보임.
        
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	edge[a].add(new int[] {b,c});
        	edge[b].add(new int[] {a,c});

        }
        
        st=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        
        
        int[] dijk=new int[n+1];
        Arrays.fill(dijk, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];
        	}
        	
        });
        pq.add(new int[] {s,0});
        dijk[s]=0;
        
        int[] p;
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	
        	
        	if(p[0]==t){
        		break;
        	}
        	for(int[] next: edge[p[0]]) {
        		if(dijk[next[0]]>p[1]+next[1]){
        			dijk[next[0]]=p[1]+next[1];
        			pq.add(new int[] {next[0],dijk[next[0]]});
        		}
        	}
        	
        }
        
        System.out.println(dijk[t]);
    }

}
