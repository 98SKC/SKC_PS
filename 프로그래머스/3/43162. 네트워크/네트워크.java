import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v=new boolean[n];
        
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int node=0;
        
        for(int i=0;i<n;i++){
            if(v[i]) continue;
            v[i]=true;
            q.add(i);
            while(!q.isEmpty()){
                node=q.poll();
                
                for(int j=0;j<n;j++){
                    if(computers[node][j]==1&&!v[j]){
                        v[j]=true;
                        q.add(j);
                    }
                }
            
            }
            answer++;
        }
        
        return answer;
    }
}