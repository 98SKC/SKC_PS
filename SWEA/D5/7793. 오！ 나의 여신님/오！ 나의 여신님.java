
import java.io.*;
import java.util.*;

public class Solution

{
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	//static boolean[][] demonV;
	//static boolean[][] wkV;
	
	static char[][] map;
	static int N,M;
	static StringBuilder sb=new StringBuilder();
	static boolean check;
	static Queue<Integer> dv;
	static Queue<Integer> wk;
	static int count;
	
    public static void main(String args[]) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T=Integer.parseInt(br.readLine());
    	String str;
    	//S:주인공 위치
    	//D:여신의 공간
    	//X:돌의 이치
    	//*:악마의 위치
    	//.:평범한 지역
    	
    	//S-> 주인공이 이동한 범위로 사용. 주인공은 *를 갈 수 없다.
    	//*-> 손아귀가 퍼진 범위로 사용. 손아귀는 S를 침식한다.
    	for(int tc=1;tc<=T;tc++) {

    		check=true;
    		dv=new ArrayDeque<>();
    		wk=new ArrayDeque<>();
    		
    		
    		st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		M=Integer.parseInt(st.nextToken());
    		map=new char[N][M];

    		
    		for(int i=0;i<N;i++) {
    			str=br.readLine();
    			for(int j=0;j<M;j++) {
    				map[i][j]=str.charAt(j);
    				if(map[i][j]=='*') {
    					dv.offer(i*M+j);
    				}else if(map[i][j]=='S') {
    					wk.offer(i*M+j);
    				}
    			}
    		}
    		
    		count=0;
    		dhbfs();
    		while(wkbfs()) {
    			count++;
    			
    			if(!check) {
    				sb.append("#").append(tc).append(" ").append(count).append("\n");
    				break;
    			}
    			
    			dhbfs();
    		}
    		if(check) {
    			sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
				
    		}	
    	}
    	
    System.out.println(sb);
    }
    
    
   
    static boolean wkbfs() {

    	boolean possible=false;
    	
    	int len=wk.size();
    	int pos;
    	for(int k=0;k<len;k++) {
    		pos=wk.poll();
    		int ni;
    		int nj;
    		
    		for(int a=0;a<4;a++) {
    			ni=pos/M+di[a];
    			nj=pos%M+dj[a];
    			if(ni>=0&&ni<N&&nj>=0&&nj<M&&(map[ni][nj]=='.'||map[ni][nj]=='D')){
    				possible=true;
    				if(map[ni][nj]=='D') {
    					check=false;// 지역에 도착함				
    					return possible;//이도이 가능함
    				}	
    				map[ni][nj]='S';
    				wk.offer(ni*M+nj);		
    			}
    		}
    	}
    	
    	return possible;
    }
    
    static void dhbfs() {

    	int len=dv.size();
    	int pos;
    	for(int k=0;k<len;k++) {
    		pos=dv.poll();
    		int ni;
    		int nj;
    		
    		for(int a=0;a<4;a++) {
    			ni=pos/M+di[a];
    			nj=pos%M+dj[a];
    			if(ni>=0&&ni<N&&nj>=0&&nj<M&&(map[ni][nj]=='.'||map[ni][nj]=='S')) {
    				map[ni][nj]='*';
    				dv.offer(ni*M+nj);		
    			}
    		}
    	}
    	
    }
   

}