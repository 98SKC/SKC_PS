
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        //HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	//map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        Arrays.sort(arr);
 
   
        //3명으로 구성된 팀을 구성
        //코딩 실력이 좋으면 팀워크가 낮고, 팀워크가 좋으면 코딩 실력이 낮다.
        //세 팀원의 코딩 실력의 합이 0이되는 팀을 만든다.
        //이러한 조건 하에 만들 수 있는 팀의 개수를 구하라.
        //각자 다른 팀으로 나누는게 아니라 만들 수 있는 팀의 경우의 수를 구함.
        
        //N명의 코딩 실력 Ai가 -10000~10000 사이의 정수로 주어질 때 합이 0이되는 3인조를 만들 수 있는 경우의 수를 구하라.
        long answer = 0L;

        // i와 j를 고정하고, 세 번째 값 target 을 찾는데, 같은 개수가 여러개 있을 수 있으니 upper, lower 둘다 사용.
        for (int i = 0; i < N - 2; i++) {
           
        	// 가지치기. arr[i]가 양수면 이후는 모두 양수 -> 합이 0 불가
            if (arr[i] > 0) break;

            for (int j = i + 1; j < N - 1; j++) {
                int target = - (arr[i] + arr[j]);

                // 탐색 구간은 j+1 .. N-1
                int left = lowerBound(arr, j + 1, N, target);
                if (left == N || arr[left] != target) continue; // 없음

                int right = upperBound(arr, j + 1, N, target);
                answer += (right - left);
            }
        }
        //이분탐색은 떠올렸는데, 두 번 할 생각을 안해서 답을 보았다. 좀더 직관적으로 생각해보자....
        System.out.println(answer);
    }

    // arr[mid] >= x 가 처음 성립하는 위치. 즉 찾는값이 처음 있는 위치
    private static int lowerBound(int[] arr, int from, int to, int x) {
        int l = from, r = to; // [l, r)
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    // arr[mid] > x 가 처음 성립하는 위치. 즉 찾는 값이 끝나는 위치.
    private static int upperBound(int[] arr, int from, int to, int x) {
        int l = from, r = to; // [l, r)
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}