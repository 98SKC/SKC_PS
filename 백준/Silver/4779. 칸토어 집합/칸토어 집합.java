import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
	
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str=br.readLine();
            if(str==null) break;
            int N=Integer.parseInt(str);
            int len=(int)Math.pow(3,N);
            helper(len);
            
            sb.append("\n");
        }
        System.out.print(sb);
        
	}
    public static void helper(int len){
         
        if(len==1){
            sb.append("-");
        }else{
            helper(len/3);
            for(int i=0;i<len/3;i++){
               sb.append(" "); 
            }
            helper(len/3);
        }
         
    }
   
}