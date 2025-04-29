import java.io.*;
import java.util.*;

public class Main{

	// 집 곳곳에 거울을 설치
	// 집에 문이 두개. 한쪽 문에서 다른쪽 문을 볼수 있도록
	// 이를 위한 최소의 거울 개수
	// #은 문, .은 아무것도 없는 빛이 통과하는 곳. !거울 설치 가능. * 통과불가
	// 빛이 직진을 하다가, 거울 설치 가능한 곳에서 전환
	public static int[][][] v;
	public static char[][] map;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
	public static int N,start,exit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String str;
		v=new int[N][N][4];
		map=new char[N][N];
		
		int start=-1;
		for(int i=0;i<N;i++) {
			str=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='#'&&start==-1) {
					start=i*N+j;
				}else if(map[i][j]=='#'&&start!=-1) {
					exit=i*N+j;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int a=0;a<4;a++) {
					v[i][j][a]=Integer.MAX_VALUE;
				}
			}
		}
		int answer=Integer.MAX_VALUE;
		for(int a=0;a<4;a++) {
			dfs(start/N,start%N,a,0);
		}
		
		for(int a=0;a<4;a++) {
			answer=Math.min(answer, v[exit/N][exit%N][a]);
		}
		System.out.println(answer);
	
	}
	
	public static void dfs(int pi, int pj, int dir,int count) {
		if(v[pi][pj][dir]<=count) {
			return;
		}
		v[pi][pj][dir]=count;
		if((pi*N+pj)==exit) {
			v[pi][pj][dir]=Math.min(v[pi][pj][dir], count);
			return;
		}
		// #은 문, .은 아무것도 없는 빛이 통과하는 곳. !거울 설치 가능. * 통과불가
		
		//지금 위치가 거울 설치 가능, 빛 통과, 벽 세가지 경우
		int ni,nj;
		if(map[pi][pj]=='!'){
			for(int a=0;a<4;a++) {
				if(dir==a) continue;//같은 방향은 거울 설치 x
				ni=pi+di[a];
				nj=pj+dj[a];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]!='*'&&v[ni][nj][a]>(count+1)) {					
					dfs(ni,nj,a,count+1);
				}
			}		
			//설치 가능해도 통과인 곳은 . 이랑 똑같이 처리
		}
		ni=pi+di[dir];
		nj=pj+dj[dir];
		if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]!='*'&&v[ni][nj][dir]>count) {					
			dfs(ni,nj,dir,count);
		}
		
	}
	
	

}