import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static long[] dp;
    public static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        dp=new long[N+1];
        dp[2]=1; //컵이 두개면 서로 교환하면 끝

        for(int i=4;i<=N;i+=2){
            //i개를 교환하는 법. i와 교환할 대상 하나를 선택하는 (i-1)과 i-2개에서 i-2개를 교환할 방법
            dp[i]=((i-1)*dp[i-2])%MOD;
        }

        System.out.println(dp[N]);
        //N개의 서로 다른 음료가 있다.
        //오름차순으로 정렬된 컵중에서 두 컵을 골라 위치를 바꾼다. 이를 N/2번 반복한다.
        //모든 컵은 정확히 한번씩 위치가 바뀌어야 한다.


        //컵이 배열되는 경우의 수가 몇개인가

        //분할정복이라고 하던가?


        //n개중 2개를 먼저 교환한다고 고정하면 경우의수는 NC2 * fn(n-2)
    }




}
