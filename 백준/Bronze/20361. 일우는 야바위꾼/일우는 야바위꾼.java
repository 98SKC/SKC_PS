import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int N,X,K,swapA,swapB;//N-종이컵 개수, X-처음 간식의 위치, K-교환 횟수, swapA-교환할 컵A, swapB-교환할 컵B
		boolean[] snack;// 간식이 들어있는 종이 컵을 표시할 boolean배열.

			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());//종이컵이 몇개인지 입력
			X=Integer.parseInt(st.nextToken());//간식이 왼쪽에서 몇번째인지 입력
			K=Integer.parseInt(st.nextToken());//컵의 위치를 몇번 바꾸는지 입력
			
			snack=new boolean[N+1];//1~N까지의 종이컵
			snack[X]=true;//처음 종이컵 위치를 표시
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				swapA=Integer.parseInt(st.nextToken());//교환할 컵 두개 중 하나
				swapB=Integer.parseInt(st.nextToken());//교환할 컵 두개 중 하나
				
				if(snack[swapA]) {//A컵에 과자가 있었으면
					snack[swapA]=false;//A의 과자를 제거한다. 
					snack[swapB]=true;//B에 과자를 옮긴다.
				}else if(snack[swapB]){//B컵에 과자가 있었으면
					snack[swapA]=true;//A에 과자를 추가하고
					snack[swapB]=false;//B의 과자를 제거한다..
				}
				
			}
			
			for(int i=1;i<=N;i++) {// 종이컵을 탐색
				if(snack[i]) {// 과자가 있는 종이컵을 발생하면 이번 테스트케이스는 끝난다.
					System.out.println(i);
					return;
				}
			}
			

	}

}