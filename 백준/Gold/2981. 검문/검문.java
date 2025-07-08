import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
  
        Arrays.sort(arr);
        // A1, A2, A3, A4 ..... 를 M으로 나누었을 때 나머지가 같은 M의 값
        // A1=M*a1+r
        // A2=M*a2+r      a1과 a2는 몫
        // A1-A2=M(a1-a2)   
        // M은 (A1-A2)의 약수이므로 A1과 A2의 공약수
        // 따라서 A1-A2와 A2-A3, A3-A4....들의 공약수를 구하면 된다.
        // 이때 A1-A2의 최대공약수를 구하면 그 공약수와 A2-A3의 최대공약수를 구하는 방식.
        
        int dividend=arr[1]-arr[0];
        for(int i=2;i<N;i++) {
        	dividend=gcd(dividend,arr[i]-arr[i-1]);
        }
        //System.out.println(Arrays.toString(arr));
        StringBuilder sb=new StringBuilder();
        //System.out.println(dividend);
        for(int i=2;i<=dividend;i++) {
        	if(dividend%i==0) {
        		sb.append(i+" ");
        	}
        }
        
        
        System.out.println(sb);
        
    }
    
    
    public static int gcd(int a1, int a2) {
    	while(a2!=0){
    		int r=a1%a2;
    		a1=a2;
    		a2=r;
    	}
    	
    	return a1;
    }

}
