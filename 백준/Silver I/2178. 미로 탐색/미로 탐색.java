import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	//static int[][] map;
	static boolean[][] map;
	static int[] di= {0,1,0,-1};//우 하 좌 상
	static int[] dj= {1,0,-1,0};
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	Queue<Integer> queue=new ArrayDeque<>();

    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
  
    	map=new boolean[N][M];

    	int[] level=new int[N*M];
    	int ni,nj;
    	String str;
    	for(int i=0;i<N;i++) {
    		str=br.readLine(); 
    		for(int j=0;j<M;j++) {
    			if(str.charAt(j)=='1') {
    				map[i][j]=true;
    			}
        	}
    	}
    	
    	queue.offer(0);
    	level[0]=1;
    	map[0][0]=false;
    	int i,j;
    	int sub;
    	while(!queue.isEmpty()) {
    		sub=queue.poll();
    		i=sub/M;
    		j=sub%M;
    		if(i==N-1&&j==M-1) {
                System.out.println(level[sub]);
                return;
            }
    		for(int a = 0; a < 4; a++) {
                ni = i + di[a];
                nj = j + dj[a];
            
                if(ni >= 0 && ni < N && nj >= 0 && nj < M&&map[ni][nj]) {
               	 queue.offer(ni*M+nj);
               	 level[ni*M+nj]=level[sub]+1;
               	map[ni][nj]=false;
                }
            }

    	}
    	
    	System.out.println("0");
    	
    }
 
}