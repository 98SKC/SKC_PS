
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       String a=br.readLine();
       String b=br.readLine();
       
       int[][] arr=new int[a.length()+1][b.length()+1];
   
       
       for(int i=1;i<=a.length();i++) {
    	   for(int j=1;j<=b.length();j++) {
    		   if(a.charAt(i-1)==b.charAt(j-1)) {
    			   arr[i][j]=arr[i-1][j-1]+1;
    		   }else {
    			   if(arr[i-1][j]>arr[i][j-1]) {
    				   arr[i][j]=arr[i-1][j];
    			   }else {
    				   arr[i][j]=arr[i][j-1];
    			   }
    		   }
    	   }
       }
       System.out.println(arr[a.length()][b.length()]);
        
    }
}
