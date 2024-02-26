import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack=new Stack<>();
		int[] work=new int[2];
		int score=0;
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
	
		int now,A,T;
		
		for(int i=1;i<=N;i++) {
			
			st=new StringTokenizer(br.readLine());
			now=Integer.parseInt(st.nextToken());
			if(now==0) {//하던일을 지속한다. 하던일이 없으면 스택에서 꺼낸다.
				if(stack.isEmpty()&&work[1]==0) continue;
				if(work[1]==0) {
					work=stack.pop();			
				}

				work[1]--;
				if(work[1]==0) {
					score+=work[0];
				} 
			}else if(now==1) {// 일이 주어진다.
				if(work[1]!=0) {// 새로운 일을 받기 전에 일이 끝났는지를 확인 한다.
					stack.push(new int[] {work[0],work[1]});
				}
				A=Integer.parseInt(st.nextToken());
				T=Integer.parseInt(st.nextToken());
				work[0]=A;
				work[1]=T-1;
				if(work[1]==0) {
					score+=work[0];
				} 
			}
			
				
		}
		
		System.out.println(score);
		
	}

}