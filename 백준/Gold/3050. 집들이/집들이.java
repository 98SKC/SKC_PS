
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

    public static int N,M;
    //public static int answer=0;
    public static int[][] preSum;
    //public static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        preSum = new int[N+1][M+1];
        String str;

        for(int i=1;i<=N;i++){
            str=br.readLine();
            for(int j=1;j<=M;j++){
                if(str.charAt(j-1)=='.'){
                    preSum[i][j]=preSum[i][j-1]+1;
                }
            }
        }

        int answer=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(preSum[i][j]!=0){
                answer=Math.max(answer,search(i,j));
                }
            }
        }

        if(answer!=0) answer-=1;

        System.out.println(answer);
    }

    //우측 상단에서 가능한만큼 내려간다.
    public static int search(int ri,int rj){
        int answer=0;

        int row=preSum[ri][rj];
        int h=1;

        for(int i=ri;i<=N;i++){
            if(preSum[i][rj]==0) break;
            row=Math.min(row,preSum[i][rj]);
            answer=Math.max(answer,row*2+h*2);
            h++;
        }


        return answer;

    }

}
