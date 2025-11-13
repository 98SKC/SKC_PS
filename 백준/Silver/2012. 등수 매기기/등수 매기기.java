
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        //모든 학생들은 자신이 몇등을 할 것인지 예상하여 제출 (N이하)
        //예상등수A와 실제 등수B가 다를 때, 불만도는 |A-B|
        //불만도의 합이 최소가 되도록 등수를 부여해라
        
        //그리디? 정렬?
        
        /*
         * 1 2 3 4 5 6 7 8 9
         * 1 2 2 3 3 3 4 5 6
         *  
         *  1 2 3 4 5 6 7 8 9
         *  1 1 1 6 7 8 6 9 6
         *  
         *  1 2 3 4 5 6 7 8 9
         *  1 1 1 6 6 6 7 8 9
         */
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        arr[0]=-1;
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        long answer=0;
       // System.out.println(Arrays.toString(arr));
        
        for(int i=1;i<=N;i++) {
        	answer+=Math.abs(i-arr[i]);
        }
        
        System.out.println(answer);
    }
        
}


