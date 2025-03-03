
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
        //두개의 합을 담을 리스트: x+y
        List<Integer> sum = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum.add(arr[i]+arr[j]);
            }
        }
        //원본 배열과 합 리스트를 정렬
        Arrays.sort(arr);
        Collections.sort(sum);
        
        int left, right, mid;
        boolean found=false;
        //k-z를 합 리스트에서 찾는다.k가 가장 커지는 경우로
        for (int k = N-1; k>=0; k--){//k가 가장 커야하니 N-1부터 시작
            for (int z = N-1; z>=0; z--){
                int minus = arr[k] - arr[z];

                left = 0;
                right = sum.size() - 1;
                found = false;
                
                while (left <= right) {
                    mid = (left + right) / 2;
                    int midValue = sum.get(mid);
                    
                    if (midValue < minus) {
                        left = mid + 1;
                    } else if (midValue > minus) {
                        right = mid - 1;
                    } else {
                        found = true;
                        break;
                    }
                }
                
                if (found) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}
