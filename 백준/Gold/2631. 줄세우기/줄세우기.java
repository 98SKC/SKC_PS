
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int[] copy=new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        int[] lis=new int[N];
        lis[0]=arr[0];
        int point=1;//현 lis길이
        int left,right,mid;
        for(int i=0;i<N;i++) {
        	
        	left=0;
        	right=point;
        	
        	
        	
        	//lower bound
        	while(left<right) {
        		mid=left+(right-left)/2;
        		
        		if(lis[mid]<arr[i]) {
        			left=mid+1;
        		}else{
        			right=mid;
        		}
        			
        			
        	}
        	
        	lis[left]=arr[i];
        	if(left==point) point++;
        }
        
        System.out.println(arr.length-point);
        
        
        
        
    }
}
