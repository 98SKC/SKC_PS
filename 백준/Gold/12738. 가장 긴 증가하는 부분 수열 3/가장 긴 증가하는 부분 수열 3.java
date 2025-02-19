import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  
        int N=Integer.parseInt(br.readLine());
        if(N==1) {
        	System.out.println(1);
        	return;
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[N];
        int sub;
        int left=0;
        int right=0;
        int mid;
        int length=0;
        for(int i=0;i<N;i++) {
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
        //System.out.println(Arrays.toString(dp));
        System.out.println(length);
    }
}