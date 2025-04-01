import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // N==1인 경우 
        if(N == 1) {
            System.out.println("A");
            return;
        }
        
        // N==2인 경우
        if(N == 2) {
            if(arr[0] == arr[1]) System.out.println(arr[0]);
            else System.out.println("A");
            return;
        }
        
        // N>=3인 경우: 우선 전체 수열이 모두 같은지 확인
        boolean allEqual = true;
        for(int i = 1; i < N; i++) {
            if(arr[i] != arr[0]) {
                allEqual = false;
                break;
            }
        }
        if(allEqual) {
            System.out.println(arr[0]);
            return;
        }
        
        // 수열이 모두 같지 않은데 첫 두 수가 같은 경우는 규칙을 구할 수 없으므로 "B"
        if(arr[0] == arr[1]) {
            System.out.println("B");
            return;
        }
        
        // 첫 세 수를 이용해 a와 b를 구함 (a와 b는 정수여야 함)
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];
        if(diff1 == 0 || diff2 % diff1 != 0) {
            System.out.println("B");
            return;
        }
        int a = diff2 / diff1;
        int b = arr[1] - arr[0] * a;
        
        // 구한 a와 b가 전체 수열에 대해 성립하는지 검증
        for(int i = 1; i < N; i++) {
            if(arr[i] != arr[i-1] * a + b) {
                System.out.println("B");
                return;
            }
        }
        
        // 모두 검증되었으므로 다음 수 출력
        System.out.println(arr[N-1] * a + b);
    }
}
