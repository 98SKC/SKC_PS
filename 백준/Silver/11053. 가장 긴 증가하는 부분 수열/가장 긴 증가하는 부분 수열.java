import java.util.*;
import java.io.*;

public class Main {
	static int[] lis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        lis=new int[N];
        lis[0]=arr[0];
        int point=0;
        int idx;
        for(int i=0;i<N;i++) {
        	if(lis[point]<arr[i]) {
        		lis[++point]=arr[i];
        	}else {
        		idx=binarySearch(0, point, arr[i]);
        		lis[idx]=arr[i];
        		
        	}
        }
        System.out.println(point+1);
        
    }
    static int binarySearch(int low, int high,int change) {
    	int mid;
    	while(low<high) {
    		mid=(low+high)/2;
    		
    		if(lis[mid]<change) {
    			 low=mid+1;
    		}else {
    			high=mid;
    		}
    	}
    	return high;
    }
}