import java.util.*;
import java.io.*;

public class Main {
    public static int first;
    public static int second;

    public static void main (String[] args) throws Exception {


        //(x,y,z) 좌표로 이루어진 마을들. 각 마을의 친밀도는 맨헤튼거리
        //세 마을의 친밀도는 중앙을 j로 둘때 ij의 친밀도+jk의 친밀도.


        //중앙 하나를 선택해서 완탐하는 경우 N^3
        // 그럼 다익스트라, 프림, 크루스칼 이런 느낌인가.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x,y,z;
        int[][] point=new int[N][3];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            z=Integer.parseInt(st.nextToken());

            point[i][0]=x;
            point[i][1]=y;
            point[i][2]=z;



        }

        //n^2의 풀이
        int answer=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            first=Integer.MAX_VALUE;
            second=Integer.MAX_VALUE;

            for(int j=0;j<N;j++){
                if(i==j) continue;
                changeState(calDist(point[i],point[j]));
            }

            answer=Math.min(answer,first+second);


        }
        System.out.println(answer);

    }

    public static int calDist(int[] p1, int[] p2){

        int x=Math.abs(p1[0]-p2[0]);
        int y=Math.abs(p1[1]-p2[1]);
        int z=Math.abs(p1[2]-p2[2]);
        return x+y+z;

    }
    public static void changeState(int num){
        if(num<first){
            second=first;
            first=num;
        }else if(num<second){
            second=num;
        }
    }
}
