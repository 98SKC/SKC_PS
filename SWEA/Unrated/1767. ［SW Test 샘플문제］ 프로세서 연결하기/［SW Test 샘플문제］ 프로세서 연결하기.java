import java.io.*;
import java.util.*;

public class Solution

{

	static int N;
	static int min;
	static int max;// 프로세서 개수
	static List<Integer> position;
	static final int[] di= {1,0,-1,0};//0-하. 1-우. 2-상, 3-좌
	static final int[] dj= {0,1,0,-1};
	static boolean[][] map;
	
    public static void main(String args[]) throws Exception{
    
    	//System.setIn(new FileInputStream("res/sample_input (9).txt"));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb=new StringBuilder();
    	int T=Integer.parseInt(br.readLine());
    
    	
    	for(int tc=1;tc<=T;tc++) {
    		position=new ArrayList<>();
    		N=Integer.parseInt(br.readLine());  		
    		map=new boolean[N][N];
    		min=Integer.MAX_VALUE;
    		max=0;
    		for(int i=0;i<N;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
        			if(st.nextToken().charAt(0)=='1') {
        				map[i][j]=true;
        				if(i!=0&&i!=N-1&&j!=0&&j!=N-1) {
        					position.add(i*N+j);
        				}
        			}
        		}
    		}
    		
    		helper(0,0,map,max);
  
    		sb.append("#").append(tc).append(" ").append(min).append("\n");
    	}
    	
    System.out.println(sb);
    }
    
    
    
    public static void helper(int cnt,int answer,boolean[][] visit,int have) {
    	if(position.size()-cnt+have<max) {//남은 것을 다 연결해도 지금 max보다 적음.
    		return;
    	}
    	boolean ch=true;
    	if(cnt==position.size()) {
    		if(have>max) {
    			max=have;
    			min=answer;
    		}else if(have==max) {
    			min=Math.min(min, answer);
    		}
    		return;
    	}
    	int sub=0;
    	boolean[][] v=new boolean[N][N];
    	//배열 복사
    	for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
    			v[i][j]=visit[i][j];
    		}
		}
    	
    	for(int a=0;a<4;a++) {
    		sub=check(cnt,a,v);
    		if(sub!=0) {
    			ch=false;
    			helper(cnt+1,answer+sub,v,have+1);
    			back(cnt,sub,a,v);
    			
    		}
    	}
    	 
    		helper(cnt+1,answer,v,have);
    	
    	
    }
    static void back(int cnt,int sub,int dir, boolean[][] visit) {
    	
    	int ni=position.get(cnt)/N;
    	int nj=position.get(cnt)%N;
    	while(sub>0) {// 전선 설치가 불가능하면 원래대로
			ni=ni+di[dir];
    		nj=nj+dj[dir];
			visit[ni][nj]=false;
			sub--;
		}
    }
    static int check(int cnt,int dir, boolean[][] visit) {
    	int ni=position.get(cnt)/N+di[dir];
    	int nj=position.get(cnt)%N+dj[dir];
    	int count=0;
    	if(dir%2==0) {//세로
    		while(ni>=0&&ni<N) {		
        		if(!visit[ni][nj]) {
        			visit[ni][nj]=true;
        			count++;
        		}else {
        			while(count>0) {// 전선 설치가 불가능하면 원래대로
        				ni=ni-di[dir];
                		nj=nj-dj[dir];
        				visit[ni][nj]=false;
        				count--;
        			}
        			return 0;
        		}
        		ni=ni+di[dir];
        		nj=nj+dj[dir];
    		}
    		
    	}else {
    		while(nj>=0&&nj<N) {
        		if(!visit[ni][nj]) {
        			visit[ni][nj]=true;
        			count++;
        		}else {
        			while(count>0) {// 전선 설치가 불가능하면 원래대로
        				ni=ni-di[dir];
                		nj=nj-dj[dir];
        				visit[ni][nj]=false;
        				count--;
        			}
        			return 0;
        		}
        		ni=ni+di[dir];
        		nj=nj+dj[dir];
    		}
    	}
    	return count;
    }
}