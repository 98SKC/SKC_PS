import java.util.*;
import java.io.*;



public class Solution {

	static int max,N,M;
	static int[][] miro;
	static int[] startToEnd;
	static boolean[][] visit;
	static int possible;
	static int[] di= {1,0,-1,0};
	static int[] dj= {0,1,0,-1};
	
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input (5).txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str;
		int T;
		startToEnd=new int[2];
		
		
		for(int tc=1;tc<=10;tc++) {
			T=Integer.parseInt(br.readLine());// 테스트케이스 문자 처리
			possible=0;
			visit=new boolean[100][100];
			//미로만들기
			miro=new int[100][100];
			for(int i=0;i<100;i++) {
				str=br.readLine();
				for(int j=0;j<100;j++) {
					miro[i][j]=str.charAt(j)-'0';
					if(miro[i][j]==1) {
						visit[i][j]=true;// 미리 막아두기
					}
					if(miro[i][j]==2) {
						startToEnd[0]=i;
						startToEnd[1]=j;
					}
				}
			}
			search(startToEnd[0],startToEnd[1]);
			sb.append("#").append(tc).append(" ").append(possible).append("\n");
		}
		System.out.println(sb);

	}
	static void search(int i,int j) {
		if(miro[i][j]==3) {
			possible=1;
			return;
		}
		int ni;
		int nj;
		for(int a=0;a<4;a++) {
			ni=i+di[a];
			nj=j+dj[a];
			if(ni>=0&&ni<100&&nj>=0&&nj<100&&!visit[ni][nj]) {
				visit[ni][nj]=true;
				search(ni,nj);
			}
		}
	
	}


}