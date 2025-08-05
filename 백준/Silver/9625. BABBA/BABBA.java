import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		// 기계에 버튼이 하나.
		// 초기 A만 있음.
		// 버튼을 누르니 B로, 한번더 누르니 BA, 그다음 BAB, BABBA
		// 화면의 모든 B는 BA로 바뀌고, A는 B로 바뀌는 로직.
		// K번 버튼을 눌렀을 때, 화면에 A와 B의 개수는 몇개?
		//한번 누룰때마다 이전 b의 개수만큼 A가 나오고, B와 A의 개수만큼 b가 나온다.
		
		int K=Integer.parseInt(br.readLine());
		int[][] dp=new int[K+1][2];
		dp[0][0]=1;
		dp[1][1]=1;
		//0이 A, 1이 B
		if(K>=2) {
			for(int i=2;i<=K;i++) {
				dp[i][0]=dp[i-1][1];
				dp[i][1]=dp[i-1][1]+dp[i-1][0];
				
			}
		}
		
		System.out.println(dp[K][0]+" "+dp[K][1]);
		
	}
	

}