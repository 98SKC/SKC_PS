
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
       
        //1. 암호화에 사용할 단어 고르기
        //2. 1에서 선정한 단어에 알파벳이 중복되지 않도록 추출해 단어 키를 만든다.
        //3. 암호화 표를 만든다.
        int len=str.length();
        ArrayList<Character> list=new ArrayList<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<len;i++) {
        	if(set.contains(str.charAt(i))) continue;
        	set.add(str.charAt(i));
        	list.add(str.charAt(i));
        	
        }
        
       
        char p='A';
        HashMap<Character,Character> map=new HashMap<>();
        for(char l:list) {
        	map.put(p++,l);
        }
        
        for(char i='A';i<='Z';i++) {
        	if(set.contains(i)) continue;
        	map.put(p++, i);
        	
        }
        
        StringBuilder sb=new StringBuilder();
        str=br.readLine();
        len=str.length();
        
        for(int i=0;i<len;i++){
        	sb.append(map.get(str.charAt(i)));
        }
        
        System.out.println(sb);
    }
        
}


