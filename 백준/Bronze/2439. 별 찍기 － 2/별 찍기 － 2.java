import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
  

	static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {
    	
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int N=Integer.parseInt(br.readLine());
//       StringTokenizer st=new StringTokenizer(br.readLine());
//       
//       double a=Double.parseDouble(st.nextToken());
//       double b=Double.parseDouble(st.nextToken());
//       double answer=a/b;
//       System.out.println(answer);
        
       for(int i=0;i<N;i++) {
    	   for(int j=i;j<N-1;j++) {
    		   System.out.print(" ");
    	   }
    	   for(int j=N-i;j<=N;j++) {
    		   System.out.print("*");
    	   }
    	   System.out.println();
       }
       
    }

}