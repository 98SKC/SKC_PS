import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String str;
		HashMap<String,Integer> book=new HashMap<>();
		for(int i=0;i<N;i++) {
			str=br.readLine();
			book.put(str, book.getOrDefault(str,0)+1);
		}
		int max=0;
		String best="";
		for(String key:book.keySet()) {
			if(book.get(key)>max) {
				max=book.get(key);
				best=key;
			}else if(max==book.get(key)&&key.compareTo(best)<0){
				//문자열의 사전 순 비교 복습. a.compareTo(b) a가 b보다 사전순으로 앞섭니다
				best=key;
			}
		}
		System.out.println(best);
			
		
	}
	
	

}