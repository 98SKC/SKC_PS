import java.util.*;
import java.io.*;

class Solution {
    
    public int[][] map;
    public int[] answer;
    public int r,c;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int len=queries.length;
        answer = new int[len];
        r=rows;
        c=columns;
        
        init();
        
        for(int i=0;i<len;i++){
            turn(i,queries[i]);
        }
        
        
        
        return answer;
        
    }
    
    
    public void turn(int round, int[] query){
        int min=Integer.MAX_VALUE;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int x1=query[1];
        int y1=query[0];
        int x2=query[3];
        int y2=query[2];


        for(int i=x1;i<x2;i++){
            q.add(map[y1][i]);
        }


        for(int i=y1;i<y2;i++){
            q.add(map[i][x2]);
        }


        for(int i=x2;i>x1;i--){
            q.add(map[y2][i]);
        }


        for(int i=y2;i>y1;i--){
            q.add(map[i][x1]);
        }


        //----------------------

        for(int i=x1+1;i<x2;i++){
            map[y1][i]=q.poll();
            min=Math.min(map[y1][i],min);
        }
        for(int i=y1;i<y2;i++){
            map[i][x2]=q.poll();
            min=Math.min(map[i][x2],min);
        }        
        for(int i=x2;i>x1;i--){
            map[y2][i]=q.poll();
            min=Math.min(map[y2][i],min);
        }

        for(int i=y2;i>=y1;i--){
            map[i][x1]=q.poll();
            min=Math.min(map[i][x1],min);
        }

        answer[round]=min;

    }
    
    
    public void init(){
        map=new int[r+1][c+1];
        
        int cnt=1;
        
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                map[i][j]=cnt++;
            }
        }
        
        
    }


}