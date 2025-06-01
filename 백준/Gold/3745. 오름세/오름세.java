
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,len;
        int[] arr;
        int[] lis;
        StringTokenizer st;
        String input;
        StringBuilder sb=new StringBuilder();
        while((input=br.readLine())!=null) {
        	if(input.isEmpty()) break;
        	N = Integer.parseInt(input.trim());
        	st=new StringTokenizer(br.readLine());
        	arr=new int[N];
        	lis=new int[N];
        	len=1;
        	for(int i=0;i<N;i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        	}
        	lis[0]=arr[0];
        	int left,right,mid;
        	int target;
        	for(int i=1;i<N;i++) {
        		target=arr[i];
        		left=0;
        		right=len;
        		//lower
        		while(left<right) {
        			mid=left+(right-left)/2;
        			
        			if(lis[mid]<target){//지금 위치가 지금 찾는 값보다 작다. 오른쪽을 봐야 한다.
        				left=mid+1;
        			}else {
        				right=mid;
        			}
        			
        		}
        		
        		//System.out.println("right: "+right);
        	    if (right == len) {
        	        lis[len++] = target;
        	    } else {
        	        lis[right] = target;
        	    }
        	}
        	
        	//System.out.println("lcs: "+Arrays.toString(lis));
        	sb.append(len+"\n");
        	
        	
        	
        	
        }
        
        System.out.println(sb);
        
    }
    
    
    
    
}
