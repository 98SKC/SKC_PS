import java.io.*;
import java.util.*;
public class Main {

    static Set<Integer>[] set = new HashSet[10];
    static final int MOD = 1234567;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        init();

        int[][] dp=new int[1001][10];// 길이가 i일때 j로 끝날 수 있는 비밀번호의 개수
        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=1000;i++){
            for(int j=0;j<10;j++){//j로 끝날 수 있으려면
                int sum = 0;
                for (int k : set[j]) {      // k에서 j로 올 수 있음
                    sum += dp[i - 1][k];
                    if (sum >= MOD) sum %= MOD;
                }
                dp[i][j] = sum;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());

            int answer=0;

            for (int j = 0; j < 10; j++) {
                answer += dp[N][j];
                answer %= MOD;
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }



    public static void init() {

        for (int i = 0; i <= 9; i++) {
            set[i] = new HashSet<>();
        }

        // 0
        set[0].add(7);

        // 1
        set[1].add(2);
        set[1].add(4);

        // 2
        set[2].add(1);
        set[2].add(3);
        set[2].add(5);

        // 3
        set[3].add(2);
        set[3].add(6);

        // 4
        set[4].add(1);
        set[4].add(5);
        set[4].add(7);

        // 5
        set[5].add(2);
        set[5].add(6);
        set[5].add(8);
        set[5].add(4);

        // 6
        set[6].add(3);
        set[6].add(5);
        set[6].add(9);

        // 7
        set[7].add(4);
        set[7].add(8);
        set[7].add(0);

        // 8
        set[8].add(7);
        set[8].add(5);
        set[8].add(9);

        // 9
        set[9].add(8);
        set[9].add(6);
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