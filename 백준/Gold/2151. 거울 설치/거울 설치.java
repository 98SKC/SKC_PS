import java.io.*;
import java.util.*;

//다익스트라버전으로 두번째 풀이
public class Main {

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
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[]o1, int[] o2) {
				return o1[3]-o2[3];
			}
		});
		for(int a=0;a<4;a++) {
			v[start/N][start%N][a] = 0;
			pq.add(new int[] {start/N,start%N,a,0});
		}
		int ni,nj,pi,pj;
		int[] p;
		
		while(!pq.isEmpty()) {
			p=pq.poll();
			
			if((p[0]*N+p[1])==exit) {
				v[p[0]][p[1]][p[2]]=Math.min(v[p[0]][p[1]][p[2]], p[3]);
				continue;
			}
			
			if(map[p[0]][p[1]]=='!') {
				for(int a=0;a<4;a++) {
					if(a==p[2]) continue;
					ni=p[0]+di[a];
					nj=p[1]+dj[a];
					if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]!='*'&&v[ni][nj][a]>(p[3]+1)) {
						v[ni][nj][a]=p[3]+1;
						pq.add(new int[] {ni,nj,a,p[3]+1});
					}
				}
			}
			ni=p[0]+di[p[2]];
			nj=p[1]+dj[p[2]];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]!='*'&&v[ni][nj][p[2]]>p[3]) {
				v[ni][nj][p[2]]=p[3];
				pq.add(new int[] {ni,nj,p[2],p[3]});
			}
			
		}
		
		for(int a=0;a<4;a++) {
			answer=Math.min(answer, v[exit/N][exit%N][a]);
		}
		System.out.println(answer);
	
	}
	
	
	
	

}