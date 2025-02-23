import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }

        int M=Integer.parseInt(br.readLine());
        
        
        boolean[][] dp=new boolean[N+1][N+1];//i~j까지 팰리드롬인가
        //각 배열의 단일 항은 팰리드롬이다
        for(int i=1;i<=N;i++) {
        	dp[i][i]=true;
        }
        
        if(N>=2) {
            //길이가 2인 경우 인접한 두 원소가 같으면 팰리드롬이다
            for(int i=1;i<=N-1;i++) {
            	if(arr[i]==arr[i+1]) dp[i][i+1]=true;
            }
        }

        
        //길이가 3 이상인 경우dp[i][j]는 arr[i] arr[j]가 같고 dp[i+1][j-1]rk 팰리드롬일 때 성립한다.
        if(N>=3) {
            for (int len = 3; len <= N; len++) {
                for (int i = 1; i <=N - len+1; i++) {
                    int j = i + len - 1;
                    if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                   
                    }
                }
            }
        }

        
        StringBuilder sb=new StringBuilder();
        int s,e;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	s=Integer.parseInt(st.nextToken());
        	e=Integer.parseInt(st.nextToken());
        	if(dp[s][e]) {
        		sb.append("1\n");
        	}else {
        		sb.append("0\n");
        	}
        	
        }
        System.out.println(sb);
    }
}