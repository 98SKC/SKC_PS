import java.io.*;
import java.util.*;

public class Main{

    public static long[][] dp=new long[65][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        calDp();

        for(int test_case=1;test_case<=T;test_case++){
            int N=Integer.parseInt(br.readLine());
            long answer=dp[N][0]+dp[N][1]+dp[N][2]+dp[N][3]+dp[N][4]+dp[N][5]+dp[N][6]+dp[N][7]+dp[N][8]+dp[N][9];
            sb.append(answer+"\n");
        }


        System.out.println(sb);
    }

    public static void calDp(){
        for(int i=0;i<=9;i++){
            dp[1][i]=1;
        }
        //dp[i]는 i자리로 이루어진 줄어들지 않는 4자리.
        for(int i=2;i<=64;i++){
            //dp[i][j]는 j로 끝나는 줄어들지 않는 i자리
            for(int j=0;j<=9;j++){
                for(int k=0;k<=j;k++){
                    dp[i][j]+=dp[i-1][k];
                }

            }

            //System.out.println(">>: "+dp[i][0]+dp[i][1]+dp[i][2]+dp[i][3]+dp[i][4]+dp[i][5]+dp[i][6]+dp[i][7]+dp[i][8]+dp[i][9]);
        }
    }
}

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