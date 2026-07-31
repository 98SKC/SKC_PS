import java.io.*;
import java.util.*;

class Solution {
    public int[] dp;
    public final int mod=1000000007;
    public int solution(int n) {
        
        dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]+=(dp[i-1]%mod+dp[i-2]%mod)%mod; 
        }    
        
        return dp[n];
    }
    
}