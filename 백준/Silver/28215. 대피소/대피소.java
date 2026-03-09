import java.io.*;
import java.util.*;

public class Main {

    public static int[][] house;
    public static int[] safeZone;
    public static int N, K;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        house = new int[N][2];
        safeZone = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        System.out.println(answer);

    }

    public static void comb(int p, int cnt) {
        if (cnt == K) {
            search();
            return;
        }

        for (int i = p; i < N; i++) {
            safeZone[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    public static void search() {
        boolean[] isSafe = new boolean[N];
        for (int s : safeZone) {
            isSafe[s] = true;
        }

        int[] sub = new int[N];
        Arrays.fill(sub, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            if (isSafe[i]) {
                sub[i] = 0;
                continue;
            }

            for (int s : safeZone) {
                sub[i] = Math.min(sub[i], calDist(i, s));
            }
        }

        int subMax = 0;
        for (int i = 0; i < N; i++) {
            subMax = Math.max(subMax, sub[i]);
        }

        answer = Math.min(answer, subMax);
    }

    public static int calDist(int a, int b) {
        return Math.abs(house[a][0] - house[b][0]) + Math.abs(house[a][1] - house[b][1]);
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