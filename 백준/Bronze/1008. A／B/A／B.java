import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
  

	static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
       
       double a=Double.parseDouble(st.nextToken());
       double b=Double.parseDouble(st.nextToken());
       double answer=a/b;
       System.out.println(answer);
        
    }

}