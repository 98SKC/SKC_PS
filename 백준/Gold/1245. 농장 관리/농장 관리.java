
//import java.io.*;
//import java.util.*;
//
//public class Main{
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//    }
//}

import java.io.*;
import java.util.*;

public class Main{

    public static int answer=0;
    public static int N,M;
    public static int[] di=new int[]{0,1,0,-1,1,1,-1,-1};
    public static int[] dj=new int[]{1,0,-1,0,1,-1,1,-1};
    public static int[][] map;
    public static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[N][M];


        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //0이 아니고, 산봉우리가 아닌 것으로 판명나지 않았으면
                if(map[i][j]!=0&&!v[i][j]){
                    //System.out.println(i+" "+j);
                    if(bfs(i,j,map[i][j])){
                        answer++;
                    }
                }
            }
        }

        //N*M 격자
        //산봉우리의 개수를 구함
        //같은 높이를 가지는 하나 이상의 인접한 격자들의 집합 = 산봉우리
        //x,y 좌표 차이가 모두 1이하인 거리가 인접하다의 정의
        //산봉우리와 인접한 격자는 모두 산봉우리의 높이보다 작아야한다.

        System.out.println(answer);
    }

    public static boolean bfs(int pi, int pj, int h){

        ArrayDeque<int[]> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[N][M];
        visited[pi][pj]=true;
        q.add(new int[]{pi,pj});

        //System.out.println("시작");

        while(!q.isEmpty()){
            int[] p=q.poll();
            //System.out.println(p[0]+" "+p[1]);
            v[p[0]][p[1]]=true;
            for(int a=0;a<8;a++){

                int ni=p[0]+di[a];
                int nj=p[1]+dj[a];

                if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!=0&&!visited[ni][nj]){
                    if(map[ni][nj]>h) return false;
                    visited[ni][nj]=true;
                    if(map[ni][nj]==h){
                        q.add(new int[]{ni,nj});
                        //System.out.println(ni+" "+nj);
                    }

                }
            }
        }
        //System.out.println("봉우리 : "+pi+" "+pj);
        return true;
    }
}
/*
8 7
4 3 2 2 1 0 1
3 3 3 2 1 0 1
2 2 2 2 1 0 0
2 1 1 1 1 0 0
1 1 0 0 0 1 0
0 0 0 1 1 1 0
0 1 2 2 1 1 0
0 1 1 1 2 1 0
* */