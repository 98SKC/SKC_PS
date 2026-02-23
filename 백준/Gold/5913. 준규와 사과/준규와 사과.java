import java.io.*;
import java.util.*;
public class Main {

    public static int answer=0;
    public static int K;
    public static int total=25;
    public static int[] di=new int[]{0,1,0,-1};
    public static int[] dj=new int[]{1,0,-1,0};
    public static boolean[][] v=new boolean[6][6];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        //5*5 격자의 1,1 과 5,5에서 출발해서 방문 가능한 맵을 모두 방문하고 서로 만날 수 있는 경우의 수
        StringTokenizer st;

        int r,c;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            r=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            v[r][c]=true;

        }
        //total개만큼 사과를 수확해야한다.
        total-=K;
        v[1][1]=true;
        v[5][5]=true;
        bfs(1,1,5,5,2);

        System.out.println(answer);
    }

    public static void bfs(int x1, int y1, int x2, int y2,int apple){

        int ni,nj;
        int mi,mj;
        //System.out.println("어디까지 오나 "+x1+" "+y1+" "+x2+" "+y2+" "+apple);

        for(int a=0;a<4;a++){
            ni=x1+di[a];
            nj=y1+dj[a];
            if(!check(ni,nj)||v[ni][nj]) continue;
            v[ni][nj]=true;
            for(int b=0;b<4;b++){
                mi=x2+di[b];
                mj=y2+dj[b];
                if(check(mi,mj)){//맵의 범위 내인데
                    if(v[mi][mj]){ //이미 방문한 곳이다?
                        //System.out.println(total+" "+apple);
                        if(ni==mi&&nj==mj&&apple==(total-1)){//둘이 만날 수 있으면
                            answer++;
                        }
                    }else{
                        v[mi][mj]=true;
                        bfs(ni,nj,mi,mj,apple+2);
                        v[mi][mj]=false;
                    }
                }

            }
            v[ni][nj]=false;
        }


    }

    public static boolean check(int i, int j){

        if(i>0&&i<=5&&j>0&&j<=5) return true;
        return false;

    }

}

//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}