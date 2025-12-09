
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name=br.readLine();
        int len=name.length();
        
        int[] alpha=new int[26];
        
        for(int i=0;i<len;i++) {
        	alpha[name.charAt(i)-'A']++; 
        }
        
        
        HashSet<Integer> odd=new HashSet<>(); 
        
        for(int i=0;i<26;i++) {
        	 if(alpha[i]%2!=0) odd.add(i);
        }
        
        if(odd.size()>1) {
        	System.out.println("I'm Sorry Hansoo");
        	return;
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<26;i++) {
       	 	if(alpha[i]!=0) {
       	 		len=alpha[i]/2;
       	 		for(int j=0;j<len;j++) {
       	 			sb.append((char)('A'+i));
       	 		}
       	 	}
       }
       
       if(!odd.isEmpty()) {
    	   for(Integer o:odd) {
    		   sb.append((char)('A'+o));
    	   }
       }
       
       for(int i=25;i>=0;i--) {
      	 	if(alpha[i]!=0) {
      	 		len=alpha[i]/2;
      	 		for(int j=0;j<len;j++) {
      	 			sb.append((char)('A'+i));
      	 		}
      	 	}
      }
      System.out.println(sb);
        //영어단어의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들고자 한다.
        //
        
        
        
    }
        
}


