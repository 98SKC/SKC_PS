
import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		// 2^25까지의 숫자를 저장. 원소 하나에 2^5개 저장 가능. (2^25 / 2^5) 20크기의 배열이 필요 
		int[] number=new int[1<<20 +1];
		StringBuilder sb=new StringBuilder();
        int pos;
        int mod;
        int sub;
		while (st.hasMoreTokens()) {
           sub=Integer.parseInt(st.nextToken());
           pos=sub/32;
           mod=sub%32;
           if((number[pos]&1<<mod)==0) {
        	   number[pos]|=1<<mod;
        	   sb.append(sub+" ");
           }
        }
		System.out.println(sb);
		
	}
	
	
}