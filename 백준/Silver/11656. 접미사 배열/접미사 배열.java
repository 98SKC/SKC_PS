import java.io.*;
import java.util.*;

public class Main{

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int len=str.length();
		String[] s=new String[len];
		for(int i=0;i<len;i++) {
			s[i]=str.substring(i);//subString 복습
		}
		Arrays.sort(s);
		StringBuilder sb=new StringBuilder();
		for(String answer:s) {
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	

}