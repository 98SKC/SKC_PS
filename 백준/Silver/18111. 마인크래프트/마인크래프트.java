import java.util.*;
import java.io.*;

public class Main {
  
	
	static int N,M,B,min,max,answer;
	
    public static void main(String[] args) throws Exception {
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
       StringTokenizer st=new StringTokenizer(br.readLine());
       
       N=Integer.parseInt(st.nextToken());
       M=Integer.parseInt(st.nextToken());
       B=Integer.parseInt(st.nextToken());
       
       max=0;
       min=Integer.MAX_VALUE;
       answer=Integer.MAX_VALUE;
       int answerH=0;
       // 높이는 결국 최소와 최대 사이의 어딘가.
       
       
       int map[][]=new int[N][M];
       
       for(int i=0;i<N;i++) {
    	   st=new StringTokenizer(br.readLine());
    			for(int j=0;j<M;j++) {
    				map[i][j]=Integer.parseInt(st.nextToken());
    				min=Math.min(min, map[i][j]);
    				max=Math.max(max, map[i][j]);
    	   }
       }
       
       int sub=0;
       int bag;
       
       if(min==max) {
    	   System.out.println(0+" "+min); 
    	   return;
       }
       for(int h=min;h<=max;h++) {
    	   
    	   bag=B;
    	   sub=0;
    	   for(int i=0;i<N;i++) {
    		   for(int j=0;j<M;j++) {
    			   if(map[i][j]>h) {
    				   bag+=map[i][j]-h;
    				   sub+=2*(map[i][j]-h);
    			   }else if(map[i][j]<h) {
    				   bag-=h-map[i][j];
    				   sub+=h-map[i][j];
    			   }
    		   }
    	   }
    	   if(bag>=0) {
    		   if(answer>=sub) {
    			   answer=sub;
    			   answerH=h;
    		   }
    	   }
       }
       System.out.println(answer+" "+answerH);
        
    }
}