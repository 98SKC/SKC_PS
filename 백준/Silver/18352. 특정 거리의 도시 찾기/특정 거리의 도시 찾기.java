import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); //도시 개수
        int M=Integer.parseInt(st.nextToken()); //도로 개수
        int K=Integer.parseInt(st.nextToken()); //거리 정보
        int X=Integer.parseInt(st.nextToken()); //출발 도시 번호
        
        boolean[] v=new boolean[N+1];
        int[] maxLen=new int[N+1];
        ArrayList<Integer>[] list=new ArrayList[N+1];
        int a,b;
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        	maxLen[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	list[a].add(b);
        	
        }
        

        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] a1,int[] a2) {
        		return a1[1]-a2[1];
        	}
        	
        });
        maxLen[X]=0;
        pq.add(new int[] {X,0});
        int[] node;
        while(!pq.isEmpty()) {
        	node=pq.poll();
        	if(v[node[0]]) continue;
        	v[node[0]]=true;
        	
        	for(Integer next:list[node[0]]) {
        		if(node[1]+1<maxLen[next]) {
        			maxLen[next]=node[1]+1;
        			pq.add(new int[] {next,node[1]+1});
        		}
        	}
        	
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++) {
        	if(K==maxLen[i]) sb.append(i+"\n");
        }
        
        if(sb.length()==0) {
        	System.out.println(-1);
        }else {
        	System.out.println(sb);
        }
        
    }
}