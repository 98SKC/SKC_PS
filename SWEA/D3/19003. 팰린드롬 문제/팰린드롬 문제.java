
import java.util.*;
import java.io.*;


class Solution
{

    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
        	String[] str2=br.readLine().split(" ");
        	int N=Integer.parseInt(str2[0]);// 문자열의 개수
        	int M=Integer.parseInt(str2[1]);// 문자열의 길이
        	int answer=0;
        	int count=0;
        	boolean check=false;// 단독 팰린드롬 하나 찾으면 true
        	ArrayList<String> list=new ArrayList<String>();
        	for(int i=0;i<N;i++) {// 문자열 저장 및 단독 팰린드롬 탐색 
        		String sub=br.readLine();
        		StringBuffer sb = new StringBuffer(sub).reverse();     		
        		if(sub.equals(sb.toString())) {
        			check=true;
        		}else {
        			list.add(sub);// 팰린드롬 아닌것들만 모아둠.
        		}	
        	}
        	for(int i=0;i<list.size();i++) {
        		String a=list.get(i);
        		StringBuffer ra = new StringBuffer(a).reverse();  
        		for(int j=i+1;j<list.size();j++) {
        			String b=list.get(j); 
        			if(ra.toString().equals(b)) {
        				count=count+2;
        				//list.remove(j);
        				break;
        			} 
        		}
        	}
        	if(check) {
        		answer=M+count*M;
        	}else {
        		answer=count*M;
        	}
        	System.out.println("#"+test_case+" "+answer);
       	
        }
    }


}
