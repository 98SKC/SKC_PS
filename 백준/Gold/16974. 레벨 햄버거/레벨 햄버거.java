import java.io.*;
import java.util.*;

public class Main{

    public static int N;
    public static long X;
    public static long[] dp;
    public static long[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 레벨 N버거
        X=Long.parseLong(st.nextToken()); // 아래부터 X장을 먹음


        //패티만 생각하면 이러면 되다만. 빵이 포함된 층이라 흐음
        //문자열로 관리해야하나.
        dp=new long[N+1];
        height=new long[N+1];

        dp[0]=1;
        height[0]=1;

        dp[1]=3;
        height[1]=height[0]*2+3;//5

        init();
        //
        //레벨 1오를때마다 이번보다 dp[i-1]*2+3 개씩. 대충 2배씩 는다고하면 2^50
        long answer=calculater(N,X);

        //완탐은 오래걸리고.
        //아래부터 n장이 이전 dp의 얼마를 포함하냐가 중요할듯


        System.out.println(answer);


    }

    //L에 따른 패티수의 dp를 채워넣음
    public static void init(){
        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]*2+1;
            height[i]=height[i-1]*2+3;
        }
       // System.out.println(Arrays.toString(height));
    }


    //L레벨 버거의 h높인에는 패티가 몇장 있는가
    public static long calculater(int L, long h){

        // 빵만있는 공간
        if (h <= 0) return 0;

        //패티만 있는 레벨
        if (L == 0) return 1;

        ///햄버거 통째로 
        if (h == height[L]) return dp[L];

        long mid = height[L]/2 + 1;

        if (h == mid) return dp[L-1] + 1;

        if (h < mid) {
            return calculater(L-1, h-1);
        } else {
            return (dp[L-1] + 1) + calculater(L-1, h-mid);
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