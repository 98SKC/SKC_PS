import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str1=br.readLine();
		String str2=br.readLine();
		
		int start=0;
		int end=0;
		
		int idx1=str1.length()-1;
		int idx2=str2.length()-1;

		int shortLength = Math.min(str1.length(), str2.length());

		if(str1.equals(str2)) {//같으면 변화가 없고
			System.out.println(0);
			return;
		}else {// 다르면 그냥 붙이냐, 자르고 붙이냐. 자르고 붙이면 str2가 더 짧을 수 있
			while(start<shortLength&&str1.charAt(start)==str2.charAt(start)) {
				start++;	
			}
			
			while(end<shortLength&&str1.charAt(idx1-end)==str2.charAt(idx2-end)) {	
				end++;
			}
		}

		if (start >= shortLength - end) {
		    if (str1.length() > str2.length()) {
		        System.out.println(0);
		    } else {
		        System.out.println(str2.length() - str1.length());
		    }
		} else {
		    System.out.println(str2.length() - end - start);
		}
		
	}
}