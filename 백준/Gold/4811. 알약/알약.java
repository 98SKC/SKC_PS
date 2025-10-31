import java.io.*;
import java.util.*;

public class Main{

	public static int N;
	public static long[][] dp=new long[31][31];
    public static void main(String[] args) throws Exception {
        
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer=0;
    	StringBuilder sb=new StringBuilder();
        
    	dp[0][0] = 1;
        
    	helper(30,0);
    	for(int t=0;t<1000;t++) {
        	N=Integer.parseInt(br.readLine());
        	if(N==0) break;
        	
        	//정리하면 w라는 약이 N개 있음
        	//w약을 꺼내면 h약을 넣음
        	//H약이 나오면 그대로 소모
        	//꺼낸 약을 기록하며 2n길이의 문자열을 만듬.
        	//2N길이의 문자열이 서로 다른 형식으로 몇개가 생길 수 있는가
        	// 즉 N개의 W와 N개의 H로 문자열을 만드는데,
        	// H는 앞서 나온 W보다 더 많이 나올 수 없다.
        	
        	
        	
        	sb.append(dp[N][0]+"\n");
        	
        	
        }
    	
    	System.out.println(sb);
        
        
        
    }
    //가칭 heper 메서드 : N크기에 따라 값을 계산
    public static long helper(int H, int W){
        //문자열이 완성되었을 때
        
    	if(dp[H][W] != 0){
          return dp[H][W];
        }
        
        long w = 0;
        long h = 0;
        
        //한 조각의 약을 꺼냄
        if(H > 0){
          h = helper(H-1,W+1);
        }
        
        //반 조각의 약을 꺼냄
        if(W > 0){
          w = helper(H,W-1);
        }
        
        dp[H][W] = h + w;
        return dp[H][W];
    
    	
    }

}
