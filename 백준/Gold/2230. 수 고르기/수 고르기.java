
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());//정수가 N개
        int M=Integer.parseInt(st.nextToken());//최소 차이M
        int[] arr=new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int front=0;
        int back=1;
        int min=Integer.MAX_VALUE;
        int sub=0;
        
        
        while(back<N){
        	sub=arr[back]-arr[front];
        	//System.out.println(front+" "+back+" "+sub+" "+min);
        	//System.out.println((sub>M)+" "+(sub<min));
        	if(sub>=M&&sub<min) {
        		min=Math.min(sub, min);
        	}
        	
        	if(sub>M&&front+1<back){
        		front++;
        	}else {
        		back++;
        	}
        }
        System.out.println(min);
        
        
    }
}
