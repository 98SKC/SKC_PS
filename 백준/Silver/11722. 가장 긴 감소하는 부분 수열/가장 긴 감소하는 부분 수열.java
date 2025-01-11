import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        int[] dp = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int length = 0; // LDS의 길이
        
        for (int i = 0; i < N; i++) {
            int left = 0, right = length;
            
            // 이분 탐색으로 dp 배열에서 arr[i]가 삽입될 위치를 찾음
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] > arr[i]) { // 감소하는 방향
                    left = mid + 1;
                } else { // dp[mid] <= arr[i]
                    right = mid;
                }
            }
            
            dp[left] = arr[i]; // 해당 위치를 갱신
            if (left == length) length++; // 새로운 길이를 확장
           // System.out.println(Arrays.toString(dp));
        }
        
        System.out.println(length);
    }
}