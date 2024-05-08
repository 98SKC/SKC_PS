import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int white=0;
        int blue=0;
        map=new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[] {1,1,N});
        int[] sub;
        int si,sj,size;
        
        while(!q.isEmpty()) {    
    		//System.out.println("왜 루프"+q.size()); 
        	sub=q.poll();
        	si=sub[0];
        	sj=sub[1];
        	size=sub[2];
        	if(!check(si,sj,size)) {
        		q.add(new int[] {si,sj,size/2});
        		q.add(new int[] {si+size/2,sj,size/2});
        		q.add(new int[] {si,sj+size/2,size/2});
        		q.add(new int[] {si+size/2,sj+size/2,size/2});
        	}else {
        		if(map[si][sj]==1) {
        			blue++;
        		}else {
        			white++;
        		}
        	}
        }
        
        System.out.println(white);
        System.out.println(blue);
        
    }
    
    
    static boolean check(int si,int sj, int size) {
    	int start=map[si][sj];
    	
    	for(int i=si;i<si+size;i++) { 		
    		for(int j=sj;j<sj+size;j++) {
        		if(map[i][j]!=start) return false;     		
        	}
    	}
    	
    	
    	return true;
    }
}