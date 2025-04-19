import java.io.*;
import java.util.*;

public class Main{

	public static ArrayList<String> answer;
	public static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
	
		
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=T;t++) {
			answer=new ArrayList<>();
			N=Integer.parseInt(br.readLine());
			
			//dfs(int pos,String str,int last,int result)
			dfs(2,"1",1,0);
			Collections.sort(answer);
			for(String a:answer) {
				sb.append(a+"\n");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
		
	}
	public static void dfs(int pos,String str,int last,int result) {
		//System.out.println("??: "+pos+" "+str);
		if(pos==(N+1)) {
			if(result+last==0) {
				answer.add(str);
			}
			return;
		}
		String sub;
		//pos 앞에 다음 중 하나를 더한다. 
		
		//str ~
		
		//+ 
		//last를 결과에 더하고 last가 지금 pos가 된다.
		sub=str+"+"+pos;
		dfs(pos+1,sub,pos,result+last);
		
		//-
		//last를 결과에 더하고 last가 지금 -pos가 된다.  
		sub=str+"-"+pos;
		dfs(pos+1,sub,-pos,result+last);
		
		//공백
		//last 절댓값에 pos를 더하고, 부호를 그대로 따른다.
		sub=str+" "+pos;
		if(last<0) {
			dfs(pos+1,sub,last*10-pos,result);
		}else {
			dfs(pos+1,sub,last*10+pos,result);
		}
		
	}

}