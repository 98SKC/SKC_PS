import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String str;
		String[] sub;
		StringBuilder sb=new StringBuilder();
		int answer;
		for(int i=0;i<N;i++) {
			str=br.readLine();
			sub=str.split(",");//split 복습
			answer=Integer.parseInt(sub[0])+Integer.parseInt(sub[1]);
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	

}