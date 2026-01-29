import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N개의 문제와 T일의 제출 기한
        //제출 기한 내에 문제를 제출 못하며, 문제마다 정해진 벌금을 내야한다.
        //내야하는 벌금이 최소가 되도록

         //dp인데? 가방문제?

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());

        int[][] subject=new int[N+1][2];
        int total=0;

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            subject[i][0]=Integer.parseInt(st.nextToken());
            subject[i][1]=Integer.parseInt(st.nextToken());
            total+=subject[i][1];
        }

        int[][] dp=new int[N+1][T+1];


        int time,cost;
        //i까지의 과제를 고려할 때
        for(int i=1;i<=N;i++){
            //j시간까지 최소 벌금
            time=subject[i][0];
            cost=subject[i][1];
            for(int j=0;j<=T;j++){
                dp[i][j] = dp[i-1][j];
                if(j-time>=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-time]+cost);
                  //  System.out.println(i+" "+j+" "+dp[i][j]);
                }

            }
        }
        //t시간이 있을 때


        System.out.println(total-dp[N][T]);



    }

}



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
