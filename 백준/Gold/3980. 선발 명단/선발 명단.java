

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

    public static int[][] map;
    public static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb=new StringBuilder();
        for(int test_case=1;test_case<=T;test_case++){
            map=new int[11][11];

            for(int i=0;i<11;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<11;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            v = new boolean[11];

            sb.append(dfs(0, 0) +"\n");


        }

        System.out.println(sb);

    }


    public static int dfs(int player, int sum) {
        // 11명 모두 배치 완료
        if (player == 11) {
            return sum;
        }

        int max = 0;

        // 현재 선수를 어느 포지션에 넣을지 시도
        for (int pos = 0; pos < 11; pos++) {

            // 능력치가 0이면 배치 불가
            // 이미 누가 쓰고 있는 포지션이면 불가
            if (map[player][pos] == 0 || v[pos]) continue;

            v[pos] = true;
            max = Math.max(max, dfs(player + 1, sum + map[player][pos]));
            v[pos] = false; // 되돌리기

        }
        return max;

    }
}