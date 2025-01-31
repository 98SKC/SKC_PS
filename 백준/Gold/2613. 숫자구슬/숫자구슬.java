import java.util.*;
import java.io.*;

public class Main {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[] arr=new int[N];

        
        st=new StringTokenizer(br.readLine());
        arr[0]=Integer.parseInt(st.nextToken());

        int left=arr[0];
        int right=0;
        for(int i=1;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	left=Math.max(left, arr[i]);
        	right+=arr[i];
        }

        int mid, totalCount, result = right;
        while (left < right) {
            mid = left + (right - left) / 2;
            
            // mid 값으로 M개의 그룹을 만들 수 있는지 확인
            int currentSum = 0;
            totalCount = 1; // 첫 그룹 포함

            for (int i = 0; i < N; i++) {
                if (currentSum + arr[i] > mid) { 
                    totalCount++; // 새로운 그룹 시작
                    currentSum = arr[i]; // 새로운 그룹의 첫 원소
                } else {
                    currentSum += arr[i]; // 기존 그룹에 추가
                }
            }

            if (totalCount > M) { // 그룹이 너무 많음 -> mid가 너무 작음
                left = mid + 1;
            } else { // 그룹이 M개 이하로 가능 -> mid 값 감소 가능
                right = mid;
                result = mid;
            }
        }
        
        System.out.println(left);
        // 🔹 M개의 그룹을 정확히 나누는 과정
        StringBuilder sb = new StringBuilder();
        int sum = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > left) { // 새로운 그룹 생성
                M--;
                sum = arr[i];
                sb.append(cnt).append(" ");
                cnt = 1;
            } else {
                cnt++;
            }

            if (M == N - i) break; // 남은 그룹이 남은 원소 개수와 같아지면 중단
        }

        while (M-- > 0) {
            sb.append(cnt).append(" ");
            cnt = 1;
        }

        System.out.println(sb);
    }
    
 
}