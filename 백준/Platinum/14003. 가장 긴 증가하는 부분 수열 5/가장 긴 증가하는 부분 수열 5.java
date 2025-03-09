
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] arr=new int[N];
        int[] record=new int[N];
        int[] lis=new int[N];
        int len=0;
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int left,right,mid;
        for(int i=0;i<N;i++) {

        	if((len == 0||arr[i]>lis[len-1])){
        		lis[len]=arr[i];
        		record[i]=len+1;
        		len++;
        	}else {
            	left=0;
            	right=len;
        		while(left<right) {

            		mid=left+(right-left)/2;
            		
            		if(lis[mid]<arr[i]) {
            			left=mid+1;
            		}else{
            			right=mid;
            		}
            		
            	}	
                lis[left]=arr[i];
                record[i]=left+1;
        	}

        }
        
        StringBuilder sb=new StringBuilder();
        sb.append(len+"\n");
       
        Stack<Integer> stack =new Stack<>();
        
        for(int i=N-1;i>=0;i--) {
        	//System.out.println(len+" "+record[i]);
        	if(record[i]==len){
        		//System.out.println(len);
        		stack.push(arr[i]);
        		len--;
        	}
        	if(len==0) break;
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()+" ");
        }

        System.out.println(sb);
        
        
    }
}
