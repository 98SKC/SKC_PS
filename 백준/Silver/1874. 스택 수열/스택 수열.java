import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
  
	
	static int N,answer;
	static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       N=Integer.parseInt(br.readLine());
       Stack<Integer> stack=new Stack<>();
       answer=0;
       ArrayList<Integer> list=new ArrayList<>();
       int[] arr=new int[N];
       int sub=0;
       for(int i=0;i<N;i++) {
    	   sub=Integer.parseInt(br.readLine());
    	   list.add(sub);
    	   arr[i]=sub;
       }
       
       Collections.sort(list);
       int point=0;

       while(!stack.isEmpty()||list.size()!=0) {
    	   if(stack.isEmpty()&&list.size()!=0) {
    		   stack.push(list.remove(0));
    	       sb.append("+").append("\n");
    	   }	   
    	   if(stack.peek()!=arr[point]){
    		   stack.push(list.remove(0));
    		   sb.append("+").append("\n");
    		  // System.out.println(stack.peek()+"이 push됨");
    	   }
    	   
    	   if(stack.peek()==arr[point]) {
    		   stack.pop();
    		  // System.out.println(stack.pop()+"이 pop됨"); 
    		   point++;
    		   sb.append("-").append("\n");

    	   }
    	   if(list.size()==0) {
    		 //  System.out.println("반복 나옴");
    		   break;
    	   }
       }
       
       if(!stack.isEmpty()) {
    	   while(!stack.isEmpty()) {
    		   if(stack.peek()==arr[point]) {
        		   stack.pop();
        		   point++;
        		   sb.append("-").append("\n");
        	   }else {
        		   System.out.println("NO");
        		   return;
        	   }
    	   }
       }

       System.out.println(sb);
        
    }

}