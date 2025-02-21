import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
  
        int left=0;
        int right=N-1;
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int answerLeft=0;
        int answerRight=N-1;
        int min=Integer.MAX_VALUE;
        while(left<right) {
        	//System.out.println(left+" "+right);
        	if(Math.abs(arr[left]+arr[right])<min) {
        		answerLeft=left;
        		answerRight=right;
        		min=Math.abs(arr[left]+arr[right]);
        	}
        	if(arr[left]+arr[right]>=0) {
        		right--;
        	}else{
        		left++;
        	}
        }
        
        
        System.out.println(arr[answerLeft]+" "+arr[answerRight]);
    }
}