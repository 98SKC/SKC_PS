
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        int[][] dp=new int[N+1][N+1];
        
        int f,s;
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine());
        	f=Integer.parseInt(st.nextToken());
        	s=Integer.parseInt(st.nextToken());
        	dp[f][s]=-1;//f가 먼저면 -1, 뒤면 1
        	dp[s][f]=1;//
        	

        }
        
        //k사건을 거칠 때
        for(int k=1;k<=N;k++) {
        	for(int i=1;i<=N;i++) {//i사건과
        		for(int j=1;j<=N;j++) {//j사건
            		if(dp[i][k]==-1&&dp[k][j]==-1) {
            			dp[i][j]=-1;
            			dp[j][i]=1;
            			
            		}else if(dp[j][k]==-1&&dp[k][i]==-1) {
            			dp[j][i]=-1;
            			dp[i][j]=1;
            			
            		}
            	}
        	}
        }
        
        int S=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S;i++) {
        	st=new StringTokenizer(br.readLine());
        	f=Integer.parseInt(st.nextToken());
        	s=Integer.parseInt(st.nextToken());
        	
        	sb.append(dp[f][s]+"\n");
        }
        System.out.println(sb);
        //사건의 개수 n개.
        //사건의 전후 관계의 개수 k개
        //앞의 사건이 뒤의 사건보다 먼지 일어났음을 알리는 k개의 입력값
        //사건의 전후 관계를 알고싶은 사건 쌍의 수 s
        //그 s의 입력값
        //s줄에 걸쳐 각 줄에 만일 앞의 있는 번호가 사건이 먼저면 -1, 뒤가 먼저면 1, 모르면 0을 출력
        
    }
}
