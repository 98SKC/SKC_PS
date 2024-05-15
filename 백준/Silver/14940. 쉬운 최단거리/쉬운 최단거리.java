import java.io.*;
import java.util.*;

public class Main {


	static int[] di=new int[] {0,1,0,-1};
	static int[] dj=new int[] {1,0,-1,0};

    public static void main(String[] args) throws Exception {
       
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	int[][] map=new int[N][M];
    	int[][] answer=new int[N][M];
    	boolean[][] v=new boolean[N][M];
    	Queue<int[]> q=new ArrayDeque<>();
    	for(int i=0;i<N;i++){
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++){
        		map[i][j]=Integer.parseInt(st.nextToken());
        		if(map[i][j]==2) {
        			q.add(new int[] {i,j});
        			answer[i][j]=0;
        			v[i][j]=true;
        			
        		} 
        	}
    	}
    	int[] pos;
    	int ni,nj;
    	
    	while(!q.isEmpty()) {
    		pos=q.poll();
    		
    		
    		for(int a=0;a<4;a++) {
    			ni=pos[0]+di[a];
    			nj=pos[1]+dj[a];
    			
    			if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!=0&&!v[ni][nj]) {
    				q.add(new int[] {ni,nj});
    				answer[ni][nj]=answer[pos[0]][pos[1]]+1;
    				v[ni][nj]=true;
    			}
    		}
    	}
    	
    	for(int i=0;i<N;i++){
    		for(int j=0;j<M;j++){
        		if(!v[i][j]&&map[i][j]!=0) answer[i][j]=-1;
        	}
    	}
    	
    	for(int[] a:answer){
    		for(int b:a) {
    			System.out.print(b+" ");
    		}
    		System.out.println();
    	}
    }
    
 
    
}