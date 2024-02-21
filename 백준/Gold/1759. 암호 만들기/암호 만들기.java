import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static HashSet<Character> set=new HashSet<>();
	static char[] c; 
	static int L,C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		c=new char[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			c[i]=st.nextToken().charAt(0);
		}
		
		Arrays.sort(c);
		
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		comb(0,"");
		System.out.println(sb);
		
	}
	
	static void comb(int start, String str) {
	
		if(str.length()==L) {
			if(check(str)) {
				sb.append(str).append("\n");
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
			
			//System.out.println("문자열 추가");
			comb(i+1,str + c[i]); // 현재 문자 c[i]를 추가하여 재귀 호출
			//System.out.println("문자열 제거");

		}
		
	}
	
	
	static boolean check(String str) {
		boolean aeiou=false;
		int count=0;
		
		
		for(int i=0;i<str.length();i++) {
			if(set.contains(str.charAt(i))) {
				aeiou=true;
			}else {
				count++;
			}
		}
		if(aeiou&&count>=2) {
			return true;
		}
		return false;
		
		
	}
	
}