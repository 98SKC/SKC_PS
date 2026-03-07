
import java.util.*;
import java.io.*;

public class Main {

	public static int T,N;
	public static final long mod=1000000007L;
	
	public static long[][] dp=new long[1000001][2];// 0은 끝이 1개짜리, 1을 끝이 2개짜리.
	
	//칼날이 결국 대칭이야. 끝이 1개 짜리인게 a개면 시작이 1개 짜리인것도 a개!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb=new StringBuilder();
        
        T=Integer.parseInt(br.readLine());
        
        //문제는 이거를 끝이 두개인 것과, 한개인 것으로 나눠야 하는가.
//        dp[1]=7;
//        dp[2]=33;
        dp[1][0]=3;
        dp[1][1]=4;
        dp[2][0]=13;
        dp[2][1]=20;
        
        for(int i=3;i<=1000000;i++) {
        	
//        	//끝이 1개짜리인 것으로 고정일 때 붙이는 방법
//        	//1.dp[i-1][0]에서 1개짜리 3개를 붙인다.
//        	dp[i][0]+=dp[i-1][0];
//        	
//        	//2.dp[i-1][1]에서 1개짜리 3개를 붙인다, .
//        	dp[i][0]+=dp[i-1][1];
//        	
//        	//3.dp[i-1][0]에서 끝에 1개를 제거하고, 2개짜리로 시작하는 블록을 붙이는 2가지의 방법.
//        	dp[i][0]+=dp[i-1][0]*2;
//        	
//        	
//        	//끝이 2개짜리인 것으로 고정일 때 붙이는 방법
//        	//1. 6시,3시방향으로 올라가는 블록을 붙이는 경우.
//        	//1-1. 12시 방향이 1개짜리. 이전은 모든 모양이 가능
//        	dp[i][1]+=dp[i-1][0]+dp[i-1][1];
//        	
//        	//1-2. 9시,12시 방향으로 올라가는 모양과 같이 사용. 이전은 무조건 1개짜로 끝나야함
//        	dp[i][1]+=dp[i-1][0];
//        	
//        	//2. 12시,3시방향으로 내려가는 블록을 붙이는 경우.
//        	//2-1. 6시 방향이 1개짜리. 이전은 모든 모양이 가능
//        	dp[i][1]+=dp[i-1][0]+dp[i-1][1];
//        	
//        	//2-2. 9시,6시 방향으로 내려가는 모양과 같이 사용. 이전은 무조건 1개짜로 끝나야함
//        	dp[i][1]+=dp[i-1][0];
//        	
        	
        	
        	//수식합치고 mod 적용
            dp[i][0] = (3L * dp[i-1][0] + dp[i-1][1]) % mod;
            dp[i][1] = (4L * dp[i-1][0] + 2L * dp[i-1][1]) % mod;
            
        	
        }

        
        for(int test_case=1;test_case<=T;test_case++) {
        	N=Integer.parseInt(br.readLine());
 
        	sb.append((dp[N][0]+dp[N][1])%mod).append('\n');
    		
        }
        
        
        System.out.println(sb);
        
        
        
    }
//    
//    //p크기의 칼날을 만들기 위해서
//    public static int calDp(){
//    	
//    	if(dp[p][0]!=0) return dp[N][0]+dp[N][1];
//    	
//    	//1~i, i~p 로 칼날을 나눌 때
//    	for(int i=1;i<p;i++){
//    		
//    		//이 점화식 문제는 끝이 뭘로 끝날 때의 개수인데, 그걸 어케암
//    		
//    		//1개짜리는 중첩으로 바로
//    		dp[p][0]+=dp[p][0]+dp[p-i][0];
//    		
//    		//앞의 1개짜리 끝이 뒤의 2개짜리에 중첩
//    		dp[p][0]+=dp[p][0]+dp[p-i][1];
//    		
//    		//뒤의 1개짜리 초반이 앞의 2개짜리에 중첩. 1개짜리 시작은 1개짜리 끝과 개수가 같다.
//    		dp[p][0]+=dp[p][0]+dp[p-i][1];
//    		
//    		
//    		//dp[p]+=dp[i]+dp[p-i]-dp[0];
//    		
//    	}
//    	
//    	return dp[N][0]+dp[N][1];
//    	
//    }
        
}


