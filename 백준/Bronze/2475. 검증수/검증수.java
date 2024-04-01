import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
  

	//static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {
    	
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    //   int N=Integer.parseInt(br.readLine());
       StringTokenizer st=new StringTokenizer(br.readLine());

       int sum=0;
       for(int i=0;i<5;i++) {
    	   sum+=Math.pow(Integer.parseInt(st.nextToken()), 2);
       }

       System.out.println(sum%10);
       
    }

}