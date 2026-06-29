import java.io.*;
import java.util.*;

class Solution {
    public int[][] dp;
    public char[][] map;
    public int[] di=new int[]{1,0,-1,0};
    public int[] dj=new int[]{0,-1,0,1};
    
    public int len1,len2;
    public int solution(String[] board) {
        
        int answer = -1;
        
        len1=board.length;
        len2=board[0].length();
        
        map=new char[len1][len2];
        dp=new int[len1][len2];
    
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        int gi=-1;
        int gj=-1;
        
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                map[i][j]=board[i].charAt(j);
                dp[i][j]=Integer.MAX_VALUE;
                if(map[i][j]=='R'){
                    q.offer(new int[]{i,j,0});
                    dp[i][j]=0;
                }else if(map[i][j]=='G'){
                    gi=i;
                    gj=j;
                }
                
            }
        }
        
        
        while(!q.isEmpty()){
            int[] p=q.poll();
            
            for(int a=0;a<4;a++){
                int[] next=helper(p[0],p[1],a);
                
                if(dp[next[0]][next[1]]>p[2]+1){
                    dp[next[0]][next[1]]=p[2]+1;
                    q.offer(new int[]{next[0],next[1],dp[next[0]][next[1]]});
                }
                
            }
            
        }
        

        
        if(dp[gi][gj]!=Integer.MAX_VALUE) answer=dp[gi][gj];
        return answer;
    }
    
    public int[] helper(int i,int j, int dir){
        
        int pi=i;
        int pj=j;
        
        int ni=pi+di[dir];
        int nj=pj+dj[dir];
        

        
        while(ni>=0&&ni<len1&&nj>=0&&nj<len2&&map[ni][nj]!='D'){
            pi=ni;
            pj=nj;

            
            ni=pi+di[dir];
            nj=pj+dj[dir];
        
        }
        
        return new int[]{pi,pj};
    
    }
}