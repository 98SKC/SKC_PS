import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws Exception{
	
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayDeque<Character> s;
		
		for(int tc=1;tc<=10;tc++) {
			boolean check=false;
			s=new ArrayDeque<>();
			int N=Integer.parseInt(br.readLine());
			String str=br.readLine();
			char sub;
			for(int i=0;i<N;i++) {
				sub=str.charAt(i);
				if(sub=='{'||sub=='('||sub=='['||sub=='<') {
					s.push(sub);
				}else {
					switch(sub) {
					
					case '}':
						if(s.pop()=='{') {
							break;
						}
						check=true;
						break;
						
					case ')': 
						if(s.pop()=='(') {
							break;
						}
						check=true;
						break;
						
					case ']': 
						if(s.pop()=='[') {
							break;
						}
						check=true;
						break;
						
					case '>': 
						if(s.pop()=='<') {
							break;
						}
						check=true;
						break;
						
					}
					if(check) break;
				}
				
				
			}
			if(check) {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}else {
				sb.append("#").append(tc).append(" ").append(1).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}