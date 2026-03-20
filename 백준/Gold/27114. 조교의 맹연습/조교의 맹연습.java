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

    public static int K;
    public static int[] energy=new int[3];
    public static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //k만큼의 에너지를 사용했을 때, d방향을 보고있는 최소 횟수



        for(int i=0;i<3;i++){
            energy[i]=Integer.parseInt(st.nextToken());
        }

        K=Integer.parseInt(st.nextToken());
        dp=new int[K+1][4];

        for(int i=0;i<=K;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=K+1;
            }
        }

        dp[0][0]=0;// 0에너지로 0방향은 디폴트.

        for(int i=1;i<=K;i++){
            //이 j행동으로
            for(int j=0;j<3;j++){
                //k 방향이려면
                for(int k=0;k<4;k++){
                    int b=beforeDir(k,j);// 이전이 이 방향
                    // b에서 j가 되려면 에너지는 energy[j]를 썼겠네?
                    if(i-energy[j]<0) continue;

                    dp[i][k]=Math.min(dp[i-energy[j]][b]+1,dp[i][k]);
                }
            }
        }

        if(dp[K][0]==(K+1)){
            System.out.println(-1);
        }else{
            System.out.println(dp[K][0]);
        }

    }


    //                         원래방향, 바뀌는 행동 -0 좌로돌아, 1우로돌아, 2 뒤로돌아
//    public static int changeDir(int d, int c){
//        int answer=1;
//
//        //앞 좌 뒤 우
//        if(c==0){
//            if(d==0) answer=3;
//            else answer=d-1;
//        }else if(c==1){
//            if(d==3) answer=0;
//            else answer=d++;
//        }else{
//            answer=(d+2)%4;
//        }
//        return answer;
//    }


    //                         원래방향, c행동으로 d가 되려면 이전에 answer방향을 보고 있어야함.
    public static int beforeDir(int d, int c){
        int answer=1;

        //앞 좌 뒤 우
        if(c==0){ //좌로 돌아서 d가 되려면
            if(d==0) answer=3;
            else answer=d-1;
        }else if(c==1){
            if(d==3) answer=0;
            else answer=d+1;
        }else{
            answer=(d+2)%4;
        }
        return answer;
    }
}