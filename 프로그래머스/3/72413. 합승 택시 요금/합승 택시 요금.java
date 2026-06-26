import java.io.*;
import java.util.*;

class Solution {
    
    public int[] toStart;
    public int[] toA;
    public int[] toB;
    public List<int[]>[] edges;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        edges=new List[n+1];
        toStart=new int[n+1];
        toA=new int[n+1];
        toB=new int[n+1];
        
        for(int i=1;i<=n;i++){
            edges[i]=new ArrayList<>();
        }
        
        for(int[] f:fares){
            int c=f[0];
            int d=f[1];
            int ff=f[2];
            edges[c].add(new int[]{d,ff});
            edges[d].add(new int[]{c,ff});
        }
        
        //b를 거쳐 A를 가는 최소 코스트와
        //A를 거쳐 B를 가는 최소 코스트
        
        //다익스트라가 아니라 플로이드와샬 아닌가
        //플로이드 = N^3
        //3개의 점에서 다익스트라
        //플로이드가 더 편하긴 하겠는데 다익스트라가 더 빠른가
        //나머지는 집에가서 풀기
        calDijk(n,s,toStart);
        calDijk(n,a,toA);
        calDijk(n,b,toB);
        
        for(int i=1;i<=n;i++){
            answer = Math.min(answer,
                toStart[i] + toA[i] + toB[i]);
        }
        return answer;
    }
    
    
    //
    public void calDijk(int N,int start, int[] dp){
        
        for(int i=1;i<=N;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        pq.add(new int[]{start,0});
        dp[start]=0;
        
        while(!pq.isEmpty()){
            
            int[] p=pq.poll();
            if(p[1] > dp[p[0]]) continue;
            
            
            for(int[] next : edges[p[0]]){
                
                
                if(dp[next[0]]>next[1]+p[1]){
                    dp[next[0]]=next[1]+p[1];
                    pq.add(new int[]{next[0],dp[next[0]]});
                }
            }

        }
        
        
    }
    
    
    
}