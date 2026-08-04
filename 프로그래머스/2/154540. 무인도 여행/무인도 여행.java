import java.io.*;
import java.util.*;

class Solution {
    public int row, col;
    public int[] di=new int[]{0,1,0,-1};
    public int[] dj=new int[]{1,0,-1,0};
    public int[][] map;
    public boolean[][] v;
    
    public int[] solution(String[] maps) {

        
        col=maps[0].length();
        row=maps.length;
        
        map=new int[row][col];
        
        for(int i=0;i<row;i++){    
            for(int j=0;j<col;j++){
                if (maps[i].charAt(j)!='X') map[i][j]=maps[i].charAt(j)-'0';
            }
        }
        
        v=new boolean[row][col];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<row;i++){    
            for(int j=0;j<col;j++){
                if(map[i][j]!=0&&!v[i][j]){
                    v[i][j]=true;
                    list.add(bfs(i,j));
                }
            }
        }
        
        
        Collections.sort(list);
        
        if(list.size()==0) return new int[]{-1};
        
        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        return answer;
    }
    
    public int bfs(int pi, int pj){
        int result=0;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{pi,pj,map[pi][pj]});
        while(!q.isEmpty()){
            int[] p=q.poll();
            result+=p[2];
            
            for(int a=0;a<4;a++){
                int ni=p[0]+di[a];
                int nj=p[1]+dj[a];
                if(ni>=0&&ni<row&&nj>=0&&nj<col&&map[ni][nj]!=0&&!v[ni][nj]){
                    v[ni][nj]=true;
                    q.add(new int[]{ni,nj,map[ni][nj]});
                }
            }
        }
        return result;
    }
    
    
}