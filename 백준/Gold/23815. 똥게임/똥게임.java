
import java.util.*;
import java.io.*;

public class Main {

	
	public static int N;
    public static int[][] dp;
    public static int[][][] query;
    public static int answer=0;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1][2];// N 0=패스를 안쓰고 올 수 있는 최대
        				   // N 1=패스를 쓰고 올 수 있는 최대
        query=new int[N][2][2];
        int number;
        char cal;
        String sub;
        
        //패스를 할거면 무조건 뺴기 혹은 나누기에서 실행.
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<2;j++) {
        		sub=st.nextToken();
        		cal=sub.charAt(0);
        		if(cal=='+'){
        			query[i][j][0]=0;
        		}else if(cal=='-'){
        			query[i][j][0]=1;
        		}else if(cal=='*') {
        			query[i][j][0]=2;
        		}else {
        			query[i][j][0]=3;
        		}
        		query[i][j][1]=Integer.parseInt(sub.substring(1,sub.length()));
        	}
        }
        
        search(0,1,0);
        if(dp[N][0]<=0&&dp[N][1]<=0) System.out.println("ddong game"); 
        else System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
        
	public static void search(int p, int subAnswer, int chance){

		dp[p][chance]=subAnswer;
		if(p==N) {
			return;
		}
		int cal1,cal2;
		

		
		cal1=query[p][0][0];
		cal2=query[p][1][0];
		
		int next1=0;
		int next2=0;
		int next;
		boolean branch=(cal1%2==0)||(cal1%2==0); //둘다 감소면 false
	
		// 두 쿼리가 모두 증가면 더 큰 쪽으로 	
		// 두 쿼리의 증감이 다르면 증가로
		if(branch) {
			next1=calculate(cal1, subAnswer, query[p][0][1]);
			next2=calculate(cal2, subAnswer, query[p][1][1]);
			//System.out.println(p+"턴 "+next1+" "+next2);
			next=Math.max(next1, next2);
			if(dp[p+1][chance]<next) {
				search(p+1,next,chance);
			}
		}else{// 두 쿼리가 둘 다 감소면 패스 혹은 더 적게 줄어드는 쪽으로

			//그냥 패스
			if(chance==0) {
				if(dp[p+1][1]<subAnswer) {
					search(p+1,subAnswer,1);
				}
			}
			//더 적은쪽
			next1=calculate(cal1, subAnswer, query[p][0][1]);
			next2=calculate(cal2, subAnswer, query[p][1][1]);
			next=Math.max(next1, next2);
			if(dp[p+1][chance]<next) {
				search(p+1,next,chance);
			}
			
		}


	}
	public static int calculate(int c, int n, int q) {
		if(c==0) {
			return n+q;
		}else if(c==1){
			return n-q;
		}else if(c==2){
			return n*q;
		}else {
			return n/q;
		}
		
	}
}


