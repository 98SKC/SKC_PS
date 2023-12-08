import java.io.*;
import java.util.*;

public class Main {

	public static int[] arr;
	public static int count1=1;
	public static int count2=0;
	
    public static void main(String[] args) throws IOException {
        
    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        
        fibo1(n);
        fibo2(n);
    	System.out.println(count1+" "+count2);
    	
    	
    }
    
    public static int fibo1 (int n) {// 재귀
    	if(n<=2){
            return 1;
        }
    	count1++;
        return fibo1(n-1)+fibo1(n-2);
		
    }  	
    

    public static int fibo2 (int n) {//동적
    	for(int i=3;i<=n;i++) {
    		count2++;
    		arr[i]=arr[i-1]+arr[i-2];
    	}
		return arr[n];
    }
}