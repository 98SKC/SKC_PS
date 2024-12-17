import java.util.*;
import java.io.*;

public class Main {
  
    //18퍼
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	
    	int result=0;
    	int[] subArr=new int[N+1];
    	int[] dijkstra=new int[N+1];
    	int[] path=new int[N+1];// 다익스트라 구하면서 나오는 간선
    	
    	int[][] dis=new int[N+1][N+1];
    	
    	boolean[] v=new boolean[N+1];
    	
    	for(int i=0;i<=N;i++) {
    		dijkstra[i]=Integer.MAX_VALUE;
    	}

    	int subA;
    	int subB;
    	int subC;
    	for(int i=0;i<M;i++) {
    		st=new StringTokenizer(br.readLine());
    		subA=Integer.parseInt(st.nextToken());
    		subB=Integer.parseInt(st.nextToken());
    		subC=Integer.parseInt(st.nextToken());
    	
    		dis[subA][subB]=subC;
    		dis[subB][subA]=subC;
    	

    	}
    	
    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
    		
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			return o1[1]-o2[1];
    			
    		}
    	});
    	
    	pq.add(new int[] {1,0,0});
    	dijkstra[1]=0;
    	int[] now;
    	
    	// 지연 시간을 알려면, 원래 시간을 알아야 함.
    	
    	while(!pq.isEmpty()) {
    		now=pq.poll();
    		
    		
    		if(v[now[0]]) {
    			continue;
    		}
    		
    		v[now[0]]=true;
    		path[now[2]]=now[0];
    		if(v[N]) break;
    		

    		for(int k=1;k<=N;k++) {

    			if(dis[now[0]][k]==0) continue;

    			if(dijkstra[k]>dijkstra[now[0]]+dis[now[0]][k]) {
//    				path[now[0]]=k;

    				dijkstra[k]=dijkstra[now[0]]+dis[now[0]][k];
    				pq.add(new int[] {k,dijkstra[k],now[0]});
    			}
    		}
    		
    	}
    	
    	//System.out.println(Arrays.toString(dijkstra));
    	
    	for(int i=1;i<=N;i++) {
    		if(result==-1) break;
    		for(int j=i+1;j<=N;j++) {
    			
    			if(dis[i][j]==0||!(path[i]==j||path[j]==i)) {
    				continue;
    			}

    			v=new boolean[N+1];
    			
    			
    	    	for(int k=1;k<=N;k++) {
    	    		subArr[k]=Integer.MAX_VALUE;
    	    	}
    	    	
    	    	subArr[1]=0;
    	    	pq.clear();
    	    	pq.add(new int[] {1,0,0});
    	    	while(!pq.isEmpty()) {

    	    		now=pq.poll();

    	    		if(v[now[0]]) {
    	    			continue;
    	    		}
    	    		
    	    		v[now[0]]=true;
    	    		

    	    		for(int k=1;k<=N;k++) {
    	    			if(dis[now[0]][k]==0||(now[0]==i&&k==j)||(now[0]==j&&k==i)) continue;
    	    			
    	    			if(subArr[k]>subArr[now[0]]+dis[now[0]][k]) {
    	    				subArr[k]=subArr[now[0]]+dis[now[0]][k];
    	    				pq.add(new int[] {k,subArr[k]});
    	    			}
    	    		}
    	    		
    	    	}
    	    	
    	    	if(!v[N]) {
    	    		result=-1;
    	    		break;
    	    	}
    	    	
    	    	
    	    	result=Math.max(result, subArr[N]-dijkstra[N]);
    		}
    	}
    	
    	System.out.println(result);
    	
    }
}