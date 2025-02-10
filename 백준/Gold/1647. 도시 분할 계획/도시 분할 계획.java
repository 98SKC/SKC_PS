import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        //int[][] load=new int[N+1][N+1];
        ArrayList<int[]>[] load=new ArrayList[N+1];
        int a,b,c;
        for(int i=1;i<=N;i++) {
        	load[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	load[a].add(new int[] {b,c});
        	load[b].add(new int[] {a,c});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        
        pq.add(new int[] {1,0});
        boolean[] v=new boolean[N+1];
        int[] sub;
        int node;
        int count=0;
        int total=0;
        int weight;
        int maxW=0;
        while(!pq.isEmpty()) {
        	sub=pq.poll();
        	
        	node=sub[0];
        	weight=sub[1];
        	
        	if(v[node]) continue;
        	v[node]=true;
        	maxW=Math.max(maxW, weight);
        	count++;
        	total+=weight;
        	
        	if(count==N) break;
        	
        	for(int[] next:load[node]) {
        		if(!v[next[0]]) pq.add(new int[] {next[0],next[1]});
        	}
        	
        }
       
        System.out.println(total-maxW);
    }
}