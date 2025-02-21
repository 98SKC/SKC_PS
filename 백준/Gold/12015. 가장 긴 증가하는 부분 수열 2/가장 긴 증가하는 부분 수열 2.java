import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[N];
        int left=0;
        int right=0;
        int mid;
        int length=0;
        int sub;
        for(int i=0;i<N;i++) {//arr[i]가 들어갈 위치를 이분탐색으로 찾는다.
        	sub=arr[i];
        	left=0;
        	right=length-1;
        	while(left<=right) {
        		mid=left+(right-left)/2;
        		if(arr[i]>dp[mid]) {
        			left=mid+1;
        		}else {
        			right=mid-1;
        		}
        	}
        	dp[left]=sub;
        	if(left==length) {
        		length++;
        	}
        }
        System.out.println(length);
        
    }
}