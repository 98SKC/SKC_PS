import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        //세로가 n, 가로가 m
        int N=land.length;
        int M=land[0].length;
        boolean[][] v=new boolean[N][M];
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        
        int[] di=new int[]{0,1,0,-1};
        int[] dj=new int[]{1,0,-1,0};
        int count=0;
        int[] pos;
        int ni,nj;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==1&&!v[i][j]){
                    q.add(new int[]{i,j});
                    v[i][j]=true;
                    count=0;
                    set=new HashSet<>();
                    set.add(j);
                    while(!q.isEmpty()){
                        pos=q.poll();
                        count++;
                        set.add(pos[1]);
                        for(int a=0;a<4;a++){
                            ni=pos[0]+di[a];
                            nj=pos[1]+dj[a];
                            if(ni>=0&&ni<N&&nj>=0&&nj<M&&land[ni][nj]==1&&!v[ni][nj]){
                                q.add(new int[]{ni,nj});
                                v[ni][nj]=true;
                            }
                        }
                    }
                    for(Integer s:set){
                        if(map.containsKey(s)){
                            map.put(s,map.get(s)+count);
                        }else{
                            map.put(s,count);
                        }
                    }
                }
            }
        }
        int max=0;
        for(int j=0;j<M;j++){
            if(map.containsKey(j)){
                max=Math.max(max,map.get(j));
            }
        }
        answer=max;
        return answer;
    }
}