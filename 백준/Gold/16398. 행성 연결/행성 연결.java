
import java.util.*;
import java.io.*;

public class Main{

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[][] edge=new int[N+1][N+1];
        
        StringTokenizer st;
        int a,b,c;
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
            	edge[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[1], o2[1]);
        	}
        });
        
        boolean[] v=new boolean[N+1];
        long answer=0;
        int[] p;
        int total=0;
        pq.add(new int[] {1,0});
        while(!pq.isEmpty()){
        	p=pq.poll();
        	if(v[p[0]]) continue;
        	v[p[0]]=true;
        	answer+=p[1];
        	total++;
        	if(total==N) break;
        	for(int i=1;i<=N;i++) {
        		if(v[i]) continue;
        		pq.add(new int[] {i,edge[p[0]][i]});
        	}
        }
        System.out.println(answer);
       
        
        //중심행성 T
        //N개의 행성 간에 플로우 설치
        //모든 행성을 연결하며 유지비용을 최소화
        
        //간선이 많다. 
        
    }
    
    
 
}
