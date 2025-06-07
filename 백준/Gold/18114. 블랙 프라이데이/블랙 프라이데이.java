
import java.io.*;
import java.util.*;

public class Main{

    public static int N, C;
    public static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 딱 C인 값이 있는가? 1개만으로 해결이 가능한가?
        int left = 0, right = N, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        //left는 C보다 큰 첫 인덱스 or N
        if (arr[left - 1] == C) {
            System.out.println(1);
            return;
        }

        // 2개로 C를 만들 수 있는가?
        int max = left;
        left = 0;
        right = max - 1;// 
        int sum;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum > C) {
                right--;
            } else if (sum < C) {
                left++;
            } else {
                System.out.println(1);
                return;
            }
        }

        // 3개로 C를 만들 수 있는가?
        // arr[0..max-1] 까지가 C 이하의 값이므로, max-1을 우측 끝으로 사용
        for (int i = 0; i < max - 2; i++) {
            int l = i + 1;
            int r = max - 1;
            while (l < r) {
                int sum3 = arr[i] + arr[l] + arr[r];
                if (sum3 == C) {
                    System.out.println(1);
                    return;
                } else if (sum3 < C) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(0);
    }
}
