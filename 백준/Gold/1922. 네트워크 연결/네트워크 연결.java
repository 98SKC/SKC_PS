import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] p;
	public static int[][] g;
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	int M=Integer.parseInt(br.readLine());
    	
    	int min=0;
    	
    	p=new int[N+1];
    	
//    	ArrayList<List> list=new ArrayList<>();
//    	ArrayList<Integer>[] list2=new ArrayList[N+1];
    	
    	g=new int[N+1][N+1];
    	StringTokenizer st;
    	int subA;
    	int subB;
    	int subC;
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

    	for(int i=0;i<M;i++) {
    		st=new StringTokenizer(br.readLine());
    		
    		subA=Integer.parseInt(st.nextToken());
    		subB=Integer.parseInt(st.nextToken());
    		subC=Integer.parseInt(st.nextToken());
    		
//    		g[subA][subB]=subC;
//    		g[subB][subA]=subC;
    		pq.add(new int[] {subA,subB,subC});
    	}
    	
    	//부모 초기화
    	for(int i=1;i<=N;i++) {
    		p[i]=i;
    	}
    	
    	
    	int count=0;
    	int[] sub;
    	while(!pq.isEmpty()) {
    		sub=pq.poll();
    		
    		if(union(sub[0],sub[1])) {
    			min+=sub[2];
    			count++;
    		}else {
    			continue;
    		}
    		if(count==N-1) break;
    		
    		
    	}
    	
    	System.out.println(min);
    	
    }
    
    
    public static int find(int a) {
		if(p[a]==a) return a;
		return find(p[a]);
    	
    }
    
    
    public static boolean union(int a,int b) {
    	
    	int p1=find(a);
    	int p2=find(b);
    	if(p1==p2) return false;
    	
    	p[p1]=p2;
    	
    	return true;
    }
    
    
}