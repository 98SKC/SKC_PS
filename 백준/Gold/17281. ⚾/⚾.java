import java.io.*;
import java.util.*;

public class Main {
	static int N,max=0;
	static int[] a= {1,2,3,4,5,6,7,8}, b=new int[9];
	static int[][] game;
	static boolean[] v=new boolean[8];
	static boolean[] state;
	
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		game=new int[N][9];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				game[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		b[3]=0;//4번타자는 고정
		perm(0);
		System.out.println(max);
	}
	
	
	static void perm(int cnt) {//cnt는 b=new int[R];의 인덱스, 또한 몇번 재귀했는지.
		if(cnt==9) {
			simul();
			return;
		}
		for(int i=0;i<8;i++) {
			if(v[i]) continue;
			v[i]=true;
			b[cnt]=a[i];
			if(cnt==2) {
				perm(cnt+2);
			}else {
				perm(cnt+1);
			}
			v[i]=false;
		}
	}

	
	 static void simul(){
		 int out=0;
		 int pos=0;
		 int sub=0;
		 
		 for(int i=0;i<N;i++) {
			 state=new boolean[4];
			 
			 while(true) {
//				 System.out.print("다음타자가 칠 차례: "+pos);
//				 System.out.println(b[pos]);
				 if(game[i][b[pos]]>0) {
//					System.out.println(game[i][b[pos]]+"루타");
					 sub+=oper(game[i][b[pos]]);//아마 배열 주소 자체의 변경이 이루어 질거임.
//					 System.out.println("점수"+sub);
//					 System.out.println("각 루수의 상태: "+Arrays.toString(state));
				 }else {
					 out++;
				 }
				 pos=(pos+1)%9;
				 if(out==3) {
					 out=0;
					 break;
				 }
			 }
		 }
		 max=Math.max(sub, max);
	 }
	 static int oper(int a) {// a루타일때, 각 루수 상황.
		 
		 int score=0;
		 for(int i=0;i<a;i++) {
//			 System.out.println((i+1)+"루수 이동");
			 state[0]=state[3];
			 state[3]=state[2];
			 state[2]=state[1];
			 if(i==0)state[1]=true;
			 else state[1]=false;
			 if(state[0]) {
//				 System.out.println("점수나옴?");
				 score++;
				 state[0]=false;
			 }
		 }
		 return score;
	 }
  
}