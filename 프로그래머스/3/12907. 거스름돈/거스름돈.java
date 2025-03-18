import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int asnwer=0;
        long[] dp = new long[n+1];
        Arrays.sort(money);

        int len=money.length;
        
        // for(int i=0;i<len;i++){
        //     answer[money[i]]=1;
        // }
        dp[0]=1;
        
        for(int i=0;i<len;i++){
            for(int j=money[i];j<=n;j++){
                dp[j]+=dp[j-money[i]];
            }
        }
        //System.out.println(Arrays.toString(dp));
        asnwer=(int) (dp[n]%1000000007);
        return asnwer;
    }
}