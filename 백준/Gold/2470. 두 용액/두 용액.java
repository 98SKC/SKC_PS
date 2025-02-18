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
        Arrays.sort(arr);
        int left,right,mid;
        int sum;
        int min=Integer.MAX_VALUE;
        int a=0;
        int b=0;
        //arr[i]와의 합이 1에 가장 가까운 수를 찾는 이분탐색
        for (int i = 0; i < N-1; i++) {
        	left=i+1;
    		right=N-1;
        	
        	while(left<=right) {
        		mid=left+(right-left)/2;
        		sum=Math.abs(arr[i]+arr[mid]);
        		if(min>sum) {
        			min=sum;
        			a=i;
        			b=mid;
        		}
        		if(arr[mid]>=-arr[i]) {//arr[i]+arr[mid]>0 -> arr[i]+arr[mid]가 작아지는 방향에 0이 있따.
        			right=mid-1;
        		}else {//arr[i]+arr[mid]<=0  -> arr[i]+arr[mid]가 커지는 방향에 0이 있다
        			left=mid+1;
        		}
        	}
        }
        System.out.println(arr[a]+" "+arr[b]);
        
    }


}