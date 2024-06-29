import java.util.*;
import java.io.*;

public class Main {

	static int N,M;
	static int[] money;
	static int[] dp;
	static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int T=Integer.parseInt(br.readLine());//3
        StringTokenizer st;
        
        for(int test_case=1;test_case<=T;test_case++) {
        	answer=0;
        	N=Integer.parseInt(br.readLine());//2
        	
        	money=new int[N];
        	
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		money[i]=Integer.parseInt(st.nextToken());	
        	}
        
        	M=Integer.parseInt(br.readLine());
       	dp=new int[M+1];
        	
//        	help2(0,M);
        	
        	for(int i=0;i<N;i++) {// money[i]원을 사용히여 만들 수 있는 돈의 개수
        		for(int j=1;j<=M;j++) {//j원을 만들어야함.
                    if(j-money[i]>0) {// 만약 j월보다 
                        dp[j]+=dp[j-money[i]];
                    }else if(j-money[i]==0) {
                        dp[j]++;
                    }
                    
        		}
        	}
        	sb.append(dp[M]+"\n");
//        	sb.append(answer+"\n");
        }
  
        System.out.println(sb);
    }

 /*   
    static int help(int idx) {
    	if(idx<0) {
    		System.out.println("불가능한 경우입니다.");
    		return 0;
    	} 
    	if(idx==0) {
    		System.out.println("기본 단위입니다.");
    		return 1;
    	} 
    	
    	if(dp[idx]!=0) {
    		System.out.println(idx+"원은 이미 구한 값입니다."+dp[idx]);
    		return dp[idx];
    	} 
    	// dp[idx]-money[1]과 dp[idx]-money[2] 의 경로에 중첩이 있는 경우3=1+2 와 1+1+1로 나뉠 때 1+2의 2가 1+1인경우 중첩
    	
    	for(int i=0;i<N;i++) {
    		System.out.println(idx+"를 구하기 위해"+(idx-money[i])+"를 구합니다.");
    		dp[idx]+=help(idx-money[i]);//dp[idx-money[i]]에서 -money[i]를 더해서 오는 루트
    	}
    	System.out.println(idx+"를 구하였습니다: "+dp[idx]);
    	System.out.println("----------------------------------------");
    	
    	return dp[idx];
    }
      */ 
    //이건 시초날걸 예상했고
//    static void help2(int pos,int won) {
//    	if(pos==N-1) {
//    		if(won%money[pos]==0) {
//    			answer++;
//    		}
//    		return;
//    	}
//
//    	int sub=won;
//    	while(sub>=0) {
//	
//    		help2(pos+1,sub);
//    		sub-=money[pos];//money[pos]원을 하나 늘리고, 다음 코인으로 넘어감.
//    	}
//    	
//    	return;
//    }
}