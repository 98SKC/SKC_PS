import java.util.*;
import java.io.*;

public class Main {

    // 오늘부터 N+1일 째 되는 날 퇴사. 
    // 최대한 많은 업무를 하려고 한다.
    // 스케줄러같은데 스케줄러 어떻게 하더라 dp던가 스케줄러가 아니였네
    // 단위가 일일 단위. 시간인 줄
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        int day,price;
        int[][] arr=new int[N+2][2];
        int[] dp=new int[N+2];
        ArrayList<Integer>[] list=new ArrayList[N+2];
        for(int i=1;i<N+1;i++) {
        	st=new StringTokenizer(br.readLine());
        	arr[i][0]=Integer.parseInt(st.nextToken());
        	arr[i][1]=Integer.parseInt(st.nextToken());// 지울 것 같기도
        	
//        	if(arr[i][0]+i<N+1) {
//        		dp[i]=arr[i][1];
//        	}
        	list[i]=new ArrayList<>();
        }
        
        list[N+1]=new ArrayList<>();
        
        for(int i=1;i<N+2;i++) {

        	if(i+arr[i][0]<=N+1) {
        		list[i+arr[i][0]].add(i);
        	}
        }
       // System.out.println("초기");
//        for(int a: dp) {
//        	System.out.print(a+" ");
//        }
       // System.out.println();     
        // 리스트는 맞는데
        for(int i=1;i<N+2;i++) {
        	//System.out.print(i+"날 올수 있는 날: ");
        	for(Integer a:list[i]) {
        		//System.out.print(a+"날에 일을 하면 "+dp[a]+" "+arr[a][1]+"로 "+(dp[a]+arr[a][1])+"을 번다");
        		dp[i]=Math.max(dp[i], dp[a]+arr[a][1]);
        	//	System.out.println();
        	}
        	//System.out.println();
        	dp[i]=Math.max(dp[i],dp[i-1]);// 전날에서 일 그냥 안할 수 있음.
        }
        
        
//        for(int a: dp) {
//        	System.out.print(a+" ");
//        }
//        
//        System.out.println();
        System.out.println(dp[N+1]);
        //dp[n]=Math.max(dp[n]+n으로 올 수 있는 어떤 날,dp[n-1]);
        //
        
        	
       
        
        
    }
}