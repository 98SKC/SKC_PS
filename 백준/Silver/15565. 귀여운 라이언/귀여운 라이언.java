import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;

        int rionCount = 0;

        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {

            //right가 늘어나면  라이언이 증가.
            if (arr[right] == 1) {
                rionCount++;
            }

            // 라이언이 K개 이상이면 K개보다 적어질 때 까지 그룹크기 갱신, 라이언 k개 미만으로 줄이기.
            while (rionCount >= K) {
                answer = Math.min(answer, right - left + 1);

                
                //사라진 라이언의 개수
                if (arr[left] == 1) {
                    rionCount--;
                }
                left++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
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
