
import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static long N;
    static int[] time;

    public static void main(String[] args) throws Exception {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[M];
        st = new StringTokenizer(br.readLine());
        int maxT = 0;
        for (int i = 0; i < M; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            if (time[i] > maxT) maxT = time[i];
        }

        // 0초에 M명이 바로 탐승
        if(N<=M){
           System.out.println(N); // N번째 아이는 N번 놀이기구
           return;
        }

        // 이분 탐색으로 최소 시간 t 찾기
        // t초동안 놀이기구가 몇대 돌아갈 수 있는 지.
        // t초에 N이상 돌 수 있으면 더 짧은 시간, N을 다 못돌면 긴 시간.
        long lo = 0, hi = (long) maxT * N; // 충분히 큰 상한
        
        
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (boarded(mid) >= N) hi = mid;
            else lo = mid + 1;
        }
        
        
        long t = lo; // 최소 시간 t

        // t-1까지 탄 인원
        long before = boarded(t - 1);
        long k = N - before; // t 시각에 탑승할 k번째 아이

        // t에 비는 기구를 번호 순으로 확인
        for (int i = 0; i < M; i++) {
            if (t % time[i] == 0) {
                k--;
                if (k == 0) {
                    System.out.println(i + 1); 
                    return;
                }
            }
        }
        
    }

    
    
    // 시간 t까지 탑승한 총 인원
    static long boarded(long t) {
        if (t < 0) return 0;
        long sum = M; // 0초 탑승
        for (int i = 0; i < M; i++) {
            sum += t / time[i];
        }
        return sum;
    }
}
