import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		
		String[] str=new String[N];
		
		for(int i=0;i<N;i++) {
			str[i]=br.readLine();
		}
		Arrays.sort(str,new Comparator<String>(){
			
			@Override
			public int compare(String s1,String s2) {// 이곳의 반환형은 무조건 int
				if(s1.length() == s2.length()) {
	   	 			return s1.compareTo(s2);// 사전순 정렬.
	   	 			//s1과 s2가 같으면 o을 반환
	   	 			
	   	 		}else {
	   	 			return s1.length() - s2.length();
	   	 		}
			}
		});
		
		for(int i=0;i<N;i++) {
			if(i!=0&&str[i].equals(str[i-1])) {//중복이면
				//str[i]==str[i-1]은 작동 안됨. 왜지?
				continue;
			}
			sb.append(str[i]).append("\n");
		}

		System.out.println(sb);
	}
}