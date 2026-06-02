import java.io.*;
import java.util.*;

class Solution {

    int[] di=new int[]{0,1,0,-1};
    int[] dj=new int[]{1,0,-1,0};
    int[][] map;
    int[][][] v;
    int N;

    public int solution(int[][] board) {
        int answer = 0;
        N=board.length;
        v=new int[N][N][4];
        map=board.clone();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<4;k++){
                    v[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }

        // 0-위치,1-위치, 2-이전 dir, 3-비용
        PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[3], o2[3]);
            }
        });

        for(int a=0;a<4;a++){
            int ni=di[a];
            int nj=dj[a];
            if(check(ni,nj,a,100)) {
                v[ni][nj][a] = 100;
                pq.offer(new int[]{ni,nj,a,100});
            }
        }

        while(!pq.isEmpty()){
            int[] p=pq.poll();



            for(int a=0;a<4;a++){
                int ni=p[0]+di[a];
                int nj=p[1]+dj[a];
                int cost=getCost(p[2],a);
                //직전이동거리면 100, 코너면 500
                if(check(ni,nj,a,p[3]+cost)){
                    v[ni][nj][a]=p[3]+cost;
                    pq.add(new int[]{ni,nj,a,p[3]+cost});
                }
            }


            //우측 하단에 이동하는 방법은 수직낙하, 우측이동 뿐.
            answer=Math.min(v[N-1][N-1][0],v[N-1][N-1][1]);

        }

        return answer;
    }

    public boolean check(int i, int j,int dir, int cost){

        if(i>=0&&i<N&&j>=0&&j<N&&map[i][j]!=1&&v[i][j][dir]>cost){
            return true;
        }
        return false;

    }
    public int getCost(int pos, int next){
        //pos가 지금 위치에 온 방향
        //next가 다음 위치
        if(pos==next) return 100;
        //우 하 좌 상
        //0  1 2  3

        return 600;

    }
}