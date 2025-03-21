import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int INF=1000000007;
        int[][] dp=new int[m+1][n+1];
        int len=puddles.length;
        for(int i=0;i<len;i++){
            dp[puddles[i][0]][puddles[i][1]]=-1;
        }
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if((i==1&&j==1)||dp[i][j]==-1) continue;
                dp[i][j]=(Math.max(dp[i-1][j],0)%INF+Math.max(dp[i][j-1],0)%INF)%INF;
            }
        }
        
        // for(int i=0;i<=m;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        answer=dp[m][n]%INF;
        return answer;
    }
}