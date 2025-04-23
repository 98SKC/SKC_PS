import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		StringBuilder reverse;
		String[] sub;
		int len;
		for(int i=0;i<N;i++) {
			sub=br.readLine().split(" ");
			len=sub.length;
			for(int j=0;j<len;j++) {
				reverse=new StringBuilder(sub[j]);//문자열 뒤집기는 StringBuilder의 함수. 복습
				sb.append(reverse.reverse()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	

}