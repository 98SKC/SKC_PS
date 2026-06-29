import java.io.*;
import java.util.*;

class Solution {
    public char[][] map;
    
    public int[] di=new int[]{0,1,0,-1};
    public int[] dj=new int[]{1,0,-1,0};
    
    public int solution(String[] maps) {
        int answer = -1;
        int len1=maps.length;
        int len2=maps[0].length();
        
        map=new char[len1][len2];
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        boolean[][] v=new boolean[len1][len2];
        for(int i=0;i<len1;i++){
            String str=maps[i];
            for(int j=0;j<len2;j++){
                map[i][j]=str.charAt(j);    
                if(map[i][j]=='S'){
                    q.offer(new int[]{i,j,0});
                    v[i][j]=true;
                }
            }
        }
        
     
        
        while(!q.isEmpty()){
            int[] p=q.poll();
            if(map[p[0]][p[1]]=='L') {
                
                q.clear();
                q.offer(new int[]{p[0],p[1],p[2]});
               // System.out.println("1차: "+p[2]);
                v=new boolean[len1][len2];
                v[p[0]][p[1]]=true;
                break;
            }
            
            for(int a=0;a<4;a++){
                int ni=p[0]+di[a];
                int nj=p[1]+dj[a];
                if(ni>=0&&ni<len1&&nj>=0&&nj<len2&&map[ni][nj]!='X'&&!v[ni][nj]){
                    v[ni][nj]=true;
                    q.offer(new int[]{ni,nj,p[2]+1});
                }
            }
            

        }
        
        while(!q.isEmpty()){
            int[] p=q.poll();
            
            if(map[p[0]][p[1]]=='E') {
                answer=p[2];
                break;
            }
            
            for(int a=0;a<4;a++){
                int ni=p[0]+di[a];
                int nj=p[1]+dj[a];
                if(ni>=0&&ni<len1&&nj>=0&&nj<len2&&map[ni][nj]!='X'&&!v[ni][nj]){
                    v[ni][nj]=true;
                    q.offer(new int[]{ni,nj,p[2]+1});
                }
            }
            

        }
        
        return answer;
    }
}