import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
	   
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] dot = new int[6];
      
      for(int i=0;i<6;i++) {
    	  dot[i] = Integer.parseInt(st.nextToken());
      } 
 
      if((dot[2]-dot[0])*(dot[5]-dot[1])==(dot[4]-dot[0])*(dot[3]-dot[1])){
         System.out.println(-1);
         return;
      }
 
      double ab = helper(dot[0],dot[1],dot[2],dot[3]);
      double bc = helper(dot[2],dot[3],dot[4],dot[5]);
      double ca = helper(dot[4],dot[5],dot[0],dot[1]);
 
      double max = Math.max(ab,Math.max(bc,ca));
      double min = Math.min(ab,Math.min(bc,ca));
 
      System.out.println(2*(max-min));
 
   }
   public static double helper(double x1, double y1, double x2, double y2){
      return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
   }
}