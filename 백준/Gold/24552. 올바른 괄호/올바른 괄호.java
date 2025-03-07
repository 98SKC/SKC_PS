
import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str=br.readLine();
		int len=str.length();
		int[][] arr=new int[len][2];
		int left=0;
		int right=0;
		
		for(int i=0;i<len;i++) {
			if(str.charAt(i)=='(') {
				left++;
			}else {
				right++;
			}
			
		}
		
		int sum=0;
		int answer=0;
		
        if(left>right){
            left = 0;
            right = 0;
            for(int i=0; i<len; i++){
                if(str.charAt(i) == '(') left++;
                else right++;
                if(left == right){
                    left = 0;
                    right = 0;
                }
            }
            System.out.println(left);
        }
        else {
            left = 0;
            right = 0;
            for(int i=len-1; i>=0; i--){
                if(str.charAt(i) == '(') left++;
                else right++;
                if(left == right){
                    left = 0;
                    right = 0;
                }
            }
            System.out.println(right);
        }
		

		
	}
	
	

}