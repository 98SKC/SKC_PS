
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //키보드가 일부 망가졌다.
        //키보드에서 작동하는 키의 개수를 m이라고 하자.
        //입력하려문 문장이 주어졌을 때, 키보드의 레이아웃을 바꾸지 않고 입력할 수 있는
        //연속하는 문자의 최댓값을 구하라....?
        
        //최대 m개의 서로 다른 문자로 이루어진 가장 긴 부분 문자열을 찾아라. 공백도 문자다.
        int m,len;
        String str;
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map;
        int left,right;
        int answer=0;
        char c;
        int cnt=0;
        while(true){
        	
        	m=Integer.parseInt(br.readLine());
        	if(m==0) break;
        	str=br.readLine();
        	len=str.length();
        	map=new HashMap<>();
        	left=0;
        	right=0;
        	cnt=0;
        	answer=0;
        	while (right < len) {

        	    c = str.charAt(right);
        	    map.put(c, map.getOrDefault(c, 0) + 1);
        	    right++;

        	    while (map.size() > m) {
        	        char lc = str.charAt(left);
        	        map.put(lc, map.get(lc) - 1);
        	        if (map.get(lc) == 0) map.remove(lc);
        	        left++;
        	    }

        	    answer = Math.max(answer, right - left);
        	}
        	
        	sb.append(answer+"\n");
        	
        }
        
        
        System.out.println(sb); 
        
        
    }
        
}


