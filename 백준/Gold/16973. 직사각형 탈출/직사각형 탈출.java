

import java.util.*;
import java.io.*;

public class Main {

	public static int N,M,W,H;
	public static int[] di=new int[] {0,1,0,-1}; //우,하,좌,상
	public static int[] dj=new int[] {1,0,-1,0};
	public static int[][] map;
	public static int[][] rowSum;
	public static int[][] colSum; 
	public static int[][] dist;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //N*M 격자판에 H*W 직사각형이 놓여있다.
        //격자는 (1,1) 부터 시작해서 (N,M)까지
        //직사각형의 좌상단 (Sr,Sc)가 주어질 때, 직사각형의 이동 후 좌측 상단을 (Fr,Fc)로 이동시키기 위한 최소 이동 횟수를 구하라.
        //직사각형은 한번에 좌,우,위,아래 중 한 방향으로 이동시킬 수 있다.
        //격자 중간에는 벽이 존재. 벽을 뚫을 순 없다.
        
        
        
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1][M+1];
        rowSum=new int[N+1][M+1];
        colSum=new int[N+1][M+1];
        dist=new int[N+1][M+1];
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++){
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=M;j++){
        		rowSum[i][j]=rowSum[i][j-1]+map[i][j];
        	}
        }
        
        for(int j=1;j<=M;j++) {
        	for(int i=1;i<=N;i++){
        		colSum[i][j]=colSum[i-1][j]+map[i][j];
        	}
        }
        
        st=new StringTokenizer(br.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        int Sr=Integer.parseInt(st.nextToken());
        int Sc=Integer.parseInt(st.nextToken());
        int Fr=Integer.parseInt(st.nextToken());
        int Fc=Integer.parseInt(st.nextToken());
        
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=M;j++){
        		dist[i][j]=1000001;
        	}
        }
        
        dist[Sr][Sc]=0;
        
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[] {Sr,Sc,0});
        
        int ni,nj;
        int[] p;
        
        boolean c;
        
        while(!q.isEmpty()){
        	p=q.poll();
        	
        	for(int a=0;a<4;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		
        		if(ableMove(ni,nj)&&dist[ni][nj]>p[2]+1){
        			c=containsWall(p[0],p[1],a);
        			if(c){
        				
        				dist[ni][nj]=p[2]+1;
        				q.add(new int[] {ni,nj,p[2]+1});
        			}else {
        				//System.out.println(p[0]+" "+p[1]+"이 좌측 상단일 때 "+a+"방향으로 가는건 막힘");
        				//아래로 가지도 못했는데?
        			}
        			
        		}
        		
        	}
        	
        	
        }
//        
//        for(int[] d:dist) {
//        	System.out.println(Arrays.toString(d));
//        }
        
        if(dist[Fr][Fc]==1000001) dist[Fr][Fc]=-1;
        System.out.println(dist[Fr][Fc]);
        
        
    }
    public static boolean ableMove(int ni, int nj) {
    	boolean answer=false;
    	
    	if(ni>0&&ni<=N&&nj>0&&nj<=M&&ni+H-1>0&&ni+H-1<=N&&nj+W-1>0&&nj+W-1<=M){
    		answer=true;
    	}
    	
    	return answer;
    }
    
    //이동한 위치에 벽이 존재하는지 확인. r,c는 이동 전 좌측 상단이라 할 때
    public static boolean containsWall(int r, int c, int dir) {
    	
    	boolean answer;
    	
    	if(dir==0){//우
    		// 시작위치는 r, c+W
    		answer=checkCol(r,c+W);
    	}else if(dir==1) { //하
    		// 시작위치는 r+H, c 
    		answer=checkRow(r+H,c);
    		
    	}else if(dir==2) {//좌
    		// 시작위치는 r, c-1
    		answer=checkCol(r,c-1);
    		
    	}else {//상
    		// 시작위치는 r-1, c
    		answer=checkRow(r-1,c);
    	}
    	
    	
    	return answer;
    	
    }
    
    //좌,우로 이동해서 새로운 위치가 세로로 한줄 생김
    public static boolean checkCol(int r, int c) {

    	//세로운 한 줄에 벽이 없으면, 누적합 기준 한 줄의 출발지와 끝이 같으면
    	if(colSum[r-1][c]==colSum[r+H-1][c]){
    		return true;
    	}
    	/**/
    	
    	return false;
    	
    }
    
    //상,하로 이동해서 새로운 위치가 가로로 한줄 생김
    public static boolean checkRow(int r, int c) {
    	
    	//세로운 한 줄에 벽이 없으면, 누적합 기준 한 줄의 출발지와 끝이 같으면
    	if(rowSum[r][c-1]==rowSum[r][c+W-1]){
    		return true;
    	}else {
    		//System.out.println("왜냐? 새로운 줄의 출발점 "+r+" "+c);
    		//System.out.println("누적합 확인 "+rowSum[r][c-1]+" "+rowSum[r][c+W]);
    		
    	}
    	

    	return false;
    	
    }
    
    
        
}


