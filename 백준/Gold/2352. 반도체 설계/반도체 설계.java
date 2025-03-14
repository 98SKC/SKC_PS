
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int[] lis=new int[N];
        int len=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        int target;
        int left,right,mid;
        lis[len++]=arr[0];
        for(int i=1;i<N;i++) {
        	target=arr[i];
        	left=0;
        	right=len;
        	if(lis[len-1]<arr[i]) {
        		lis[len++]=arr[i];
        	}else {
            	while(left<right) {
            		mid=left+(right-left)/2;
            		
            		if(lis[mid]<target) {
            			left=mid+1;
            		}else {
            			right=mid;
            		}
            		
            	}     	
            	lis[right]=target;
        	}

        	
        }
        System.out.println(len);
        
        
        //이전 선분들의 도착점보다 더 큰 숫자로 향해야함
    }
}
