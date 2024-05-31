import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		
		int pos;
		int next;
		
		Node(int pos,int next){
			this.pos=pos;
			this.next=next;
			
		}
		
		
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	int[][] map= new int[N][N];
    	int[][] answer= new int[N][N];
    	boolean v[];
    	
    	Queue<Node> q=new ArrayDeque<>();
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		//방문배열 초기화
    		v=new boolean[N];
    		for(int j=0;j<N;j++) {
    			if(map[i][j]==1&&!v[j]) {
    				q.offer(new Node(i,j));
    				//System.out.println(q.size());
    				while(!q.isEmpty()) {
    					//System.out.println("들어옴");
    					Node node=q.poll();
    					if(v[node.next]) {
    						continue;
    					}
    					//System.out.println("값 넣음");
    					answer[i][node.next]=1;
    					v[node.next]=true;
    					for(int k=0;k<N;k++) {
    						if(map[node.next][k]==1&&v[j]) {
    							q.add(new Node(node.next,k));
    						}
    					}
    					
    				}
    			}
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(answer[i][j]+" ");
    		}
    		System.out.println();
    	}
  
        
    }
}