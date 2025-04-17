import java.util.*;
import java.io.*;
	
public class Main {
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
	
		String str = br.readLine();
		int len = str.length();
	
		boolean tag = false;		
		for(int i=0; i<len; i++) {
			if(str.charAt(i) == '<') {
				tag = true;
				while( !stack.isEmpty() ) {
					sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
			}else if(str.charAt(i) == '>') {
				tag = false;
				sb.append(str.charAt(i));
			}else if(tag == true) {
				sb.append(str.charAt(i));
			}else if( tag == false) {
				if(str.charAt(i) == ' ') {
					while( !stack.isEmpty() ) {
						sb.append(stack.pop());
					}
					sb.append(str.charAt(i));
				}else {
					stack.push(str.charAt(i));
				}
			}
		}

		while( !stack.isEmpty() ) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

		
	} 
} 