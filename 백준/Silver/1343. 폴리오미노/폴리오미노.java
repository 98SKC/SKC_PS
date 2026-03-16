

import java.util.*;
import java.io.*;

public class Main {

	public static String str;
	public static String A="XXXX";
	public static String B="XX";
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine();
        
        int len=str.length();
        int s=0;
        StringBuilder sb=new StringBuilder();
        //AAAA BB 둘 다 짝수개이기에 
        while(s<len){
        	if(str.charAt(s)=='.') {
        		sb.append(".");
        		s++;
        		continue;
        	}
        	//AAAA를 둘 수 있는가
        	if(s+4<=len&&str.substring(s,s+4).equals(A)){
        		sb.append("AAAA");
        		s+=4;
        	}else if(s+2<=len&&str.substring(s, s+2).equals(B)){//BB는 둘 수 있는가
        		sb.append("BB");
        		s+=2;
        	}else {
        		//System.out.println("???: "+s);
        		System.out.println(-1);
        		
        		return;
        	}
        }
        System.out.println(sb);
    }
        
}


