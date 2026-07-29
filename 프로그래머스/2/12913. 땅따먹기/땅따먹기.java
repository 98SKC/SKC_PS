import java.util.*;
import java.io.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int row=land.length;
        int col=land[0].length;
        int[][] dp=new int[row][col];
        
        
        for(int i=0;i<col;i++){
            dp[0][i]=land[0][i];
        }
        
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int max=0;
                for(int k=0;k<col;k++){
                    if(j==k) continue;
                    max=Math.max(max,dp[i-1][k]);
                }
                dp[i][j]=land[i][j]+max;
            }
        }
        
        // for(int[] m:dp){
        //     System.out.println(Arrays.toString(m));
        // }
        
        
        for(int i=0;i<col;i++){
            answer=Math.max(answer,dp[row-1][i]);
        }
        
        return answer;
    }
}