import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());
        //int[][] block=new int[N+1][M+1];
       
        ArrayList<Integer>[] block=new ArrayList[N+1];
        int[][] dp=new int[N+1][H+1];
        
        String[] str;
        int sub;
        for(int i=1;i<=N;i++) {
        	block[i]=new ArrayList<>();
        	str=br.readLine().split(" ");
        	for(int j=0;j<str.length;j++) {
        		block[i].add(Integer.parseInt(str[j]));
        	}
        }
        
        for(int i=0; i<=N; i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=N;i++) {// N번까지의 학생을 고려했을 때
        	for(int j=1;j<=H;j++){// j높이를 구할 수 있는 경우
        		for(Integer number:block[i]) {
        			if(j-number>=0) {
        				dp[i][j]+=dp[i-1][j-number];
        				dp[i][j]%=10007;
        			}
        		}
        		dp[i][j]+=dp[i-1][j];
        		dp[i][j]%=10007;
        	}
        }

        System.out.println(dp[N][H]);
    }
}