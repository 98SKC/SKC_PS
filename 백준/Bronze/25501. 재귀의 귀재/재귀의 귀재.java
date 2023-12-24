import java.io.*;
import java.util.*;

public class Main {
	 
	static public StringBuilder sb=new StringBuilder();
	static public int sub=0;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int answer=2;
		for(int i=0;i<N;i++) {
			answer=isPalindrome(br.readLine());
			sb.append(answer).append(" ").append(sub).append("\n");
			
		}
		System.out.println(sb);
		
 
		
	}
 
	// 출력값:isPalindrome반환값, recursion함수 호출 횟수
	public static int recursion(String str, int front, int back,int count){
	    if(front>=back) {
	    	sub=count;
	    	return 1;
	    }else if(str.charAt(front)!=str.charAt(back)) {
	    	sub=count;
	    	return 0;
	    }else {
	    	return recursion(str,front+1,back-1,count+1);
	    }
		
	}
	

	public static int isPalindrome(String str) {
		return recursion(str,0,str.length()-1,1);
		//isPalindrome 반환값:recursion값?
	} 
}