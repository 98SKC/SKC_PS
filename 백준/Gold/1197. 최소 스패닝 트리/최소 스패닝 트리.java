import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1,int[] o2) {
        		return o1[1]-o2[1];
        	}
        });
        //int[][] graph=new int[N+1][N+1];
        ArrayList<int[]>[] graph=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	graph[i]=new ArrayList<>();
        }
        
        int a,b,c;
        for(int i=0;i<E;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	graph[a].add(new int[] {b,c});
        	graph[b].add(new int[] {a,c});
        	
        }
        
        pq.add(new int[] {1,0});
        boolean[] v=new boolean[N+1];
        int[] sub;
        int result=0;
        
        while(!pq.isEmpty()) {

        	sub=pq.poll();
        	if(v[sub[0]]) continue;
        	
        	v[sub[0]]=true;
        	
        	result+=sub[1];
        	
        	for(int[] next:graph[sub[0]]) {
        		if(!v[next[0]]) {
        			pq.add(new int[] {next[0],next[1]});
        		}
        		
        	}
        	
        }
        
        System.out.println(result);
    }
}