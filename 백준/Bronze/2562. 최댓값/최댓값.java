import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
  

	//static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {

      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  
     // StringTokenizer st=new StringTokenizer(br.readLine());

      int max=0;
      int h=0;
      int sub=0;
      for(int i=0;i<9;i++) {
   	   	sub=Integer.parseInt(br.readLine());
   	   	if(sub>max) {
   	   		max=sub;
   	   		h=i+1;
   	   	}
      }

       System.out.println(max);
       System.out.println(h);
       
    }

}