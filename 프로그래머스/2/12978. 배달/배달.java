import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        //N 노드 개수
        //간선은 양방향
        //K이하의 거리의 마을과 연결
        //시작노드는 1
        ArrayList<int[]>[] edge=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            edge[i]=new ArrayList<>();
        }
        for(int i=1;i<=road.length;i++){
            edge[road[i-1][0]].add(new int[]{road[i-1][1],road[i-1][2]});
            edge[road[i-1][1]].add(new int[]{road[i-1][0],road[i-1][2]});
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
            
        });
        
        int[] dijk=new int[N+1];
        boolean[] v=new boolean[N+1];
        for(int i=1;i<=N;i++){
            dijk[i]=Integer.MAX_VALUE;
        }
        int[] node;
        pq.add(new int[]{1,0});

        
        while(!pq.isEmpty()){
            node=pq.poll();
            if(v[node[0]]) continue;
            v[node[0]]=true;
            answer++;
            //System.out.println("가능한 마을: "+node[0]+" 거리: "+node[1]);
            for(int[] next:edge[node[0]]){
                //next[0] 다음 노드, next[1] 가중치
                
                if(dijk[next[0]]>node[1]+next[1]&&node[1]+next[1]<=K){
                    dijk[next[0]]=node[1]+next[1];
                    pq.add(new int[]{next[0],node[1]+next[1]});
                }
            }
        }
        return answer;
    }
}