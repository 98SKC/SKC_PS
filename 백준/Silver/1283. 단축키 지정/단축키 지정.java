import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        //N개의 옵션. 각 옵션드른 여러 개의 단어로 옵션의 기능을 설명
        //위세어부터 차례대로 각 옵션에 단축키를 의미하는 대표 알파벳을 지정
        //하나의 옵션에 대해 왼쪽에서 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는가 확인
        //아직이면 그 알파벳을 단축키로 지정
        //모든 첫글자가 단축키로 지정이면 그 다음 알파벳을 보고, 지정안된 것을 단축키로
        
        String[] str;
        int len;
        int target;
        char b,s;
        StringBuilder sb=new StringBuilder();
        HashSet<Character> save=new HashSet<>();
        String sub;
        save.add(' ');
        boolean find=false;
        for(int i=0;i<N;i++) {
        	sub=br.readLine();
        	str=sub.split(" ");
        	len=str.length;
        	find=false;
        	for(int j=0;j<len;j++) {
        		b=str[j].toUpperCase().charAt(0);
        		s=str[j].toLowerCase().charAt(0);
        		if(!save.contains(b)){
        			find=true;
        			save.add(b);
        			save.add(s);
        			for(int k=0;k<len;k++){
        				if(j!=k) sb.append(str[k]+" ");
        				else {
        					sb.append("["+str[k].charAt(0)+"]");
        					if(str[k].length()>1) {
        						sb.append(str[k].substring(1,str[k].length()));
        						
        					}
        					sb.append(" ");
        				} 
        			}
        			break;
        		}

        		
        	}
        	
    		if(!find) {
    			for(int k=0;k<sub.length();k++) {
    				if(!save.contains(sub.charAt(k))) {
    					find=true;
    	        		b=sub.toUpperCase().charAt(k);
    	        		s=sub.toLowerCase().charAt(k);
    	        		save.add(b);
    	        		save.add(s);
    	        		sb.append(sub.substring(0, k)+"["+sub.charAt(k)+"]"+sub.substring(k+1, sub.length()));
    	        		break;
    				}
    			}
    			
    		}
    		if(!find) sb.append(sub);
        	sb.append("\n");
        	
        }
        System.out.println(sb);
    }

}
