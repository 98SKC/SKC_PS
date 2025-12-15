
import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<String>[] dictionary;
	public static HashMap<String,Integer> order=new HashMap<>();
	public static final String isCorrect=" is correct";
	public static final String isAMisspellingOf="is a misspelling of ";
	public static final String isUnknown=" is unknown";
	public static String save;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int N=Integer.parseInt(br.readLine());
        
        String str;
        dictionary=new ArrayList[27];//만약 25길이 문자열이면, 중복된 문자열을 찾기위해 26을 봐야함. 26이 사전에는 없겠지만 그래도 for문에 빈 set이라도 주기위함
        for(int i=0;i<=26;i++) {
        	dictionary[i]=new ArrayList<>();
        }
        
        for(int i=0;i<N;i++) {
        	
        	str=br.readLine();
        	order.put(str, i);
        	dictionary[str.length()].add(str);
        	
        }
        
        int T=Integer.parseInt(br.readLine());
        String answer;
        for(int i=0;i<T;i++) {
        	str=br.readLine();
        	
        	answer=search(str);
        	
        	sb.append(answer+"\n");
        }
        
        
        System.out.println(sb);
    }
    
    public static String search(String str){
    	
    	if(containsExactWord(str)) {
    		return str+isCorrect;
    	    		
    	}else if(containsSimilarWord(str)) {
    		return str+" "+isAMisspellingOf+save;
    		
    	}
    	
    	return str+isUnknown;
    	
    }
    
    public static boolean containsExactWord(String str) {
    	int len=str.length();
    	for(String s:dictionary[len]) {
    		if(str.equals(s)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    public static boolean containsSimilarWord(String str){

        int len = str.length();
        boolean find = false;
        save = "";

        //글자가 한개 누락되었는가? - 글자수가 한개 적은 곳에서 탐색
        if (len - 1 >= 1) {
            for (String s : dictionary[len - 1]) {
                //탐색 후 있으면 find=true; 후 save갱신, 그리고 break;
                int i = 0, j = 0;
                boolean skipped = false;

                while (i < str.length() && j < s.length()) {
                    if (str.charAt(i) == s.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        if (skipped) break;
                        skipped = true;
                        i++; // str 쪽에서 한 글자 건너뜀
                    }
                }

                // 아직 skip을 안 했고, 맨 끝 글자 하나가 남은 경우
                if (!skipped && i == str.length() - 1 && j == s.length()) {
                    skipped = true;
                    i++;
                }

                if (skipped && i == str.length() && j == s.length()) {
                    find = true;
                    // 입력순서가 더 빠른 단어로 갱신
                  //  System.out.println(str+ "가능: "+s);
                    if (save.equals("") || order.get(s) < order.get(save)) {
                        save = s;
                    }
                }
            }
        }

        //글자가 한개 중복되었는가?- 글자수가 한개 많은 곳에서 탐색
        if (len + 1 <= 26) {
            for (String s : dictionary[len + 1]) {
                //탐색 후 있으면 find=true; 후 save와 s를 비교하여 사전순으로 앞인걸 저장, 후 break;
                int i = 0, j = 0;
                boolean skipped = false;

                while (i < str.length() && j < s.length()) {
                    if (str.charAt(i) == s.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        if (skipped) break;
                        skipped = true;
                        j++; // s 쪽에서 한 글자 건너뜀
                    }
                }

                // 아직 skip을 안 했고, s 쪽에 마지막 글자 하나가 남은 경우
                if (!skipped && i == str.length() && j == s.length() - 1) {
                    skipped = true;
                    j++;
                }

                if (skipped && i == str.length() && j == s.length()) {
                    find = true;
                    // 입력순서가 더 빠른 단어로 갱신
                   // System.out.println(str+ "가능: "+s);
                    if (save.equals("") || order.get(s) < order.get(save)) {
                        save = s;
                    }
                }
            }
        }
        //같은 길이에서 글자가 하나만 다른가? (치환)
        for (String s : dictionary[len]) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != s.charAt(i)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) {
                find = true;
                //System.out.println(str+ "가능: "+s);
                if (save.equals("") || order.get(s) < order.get(save)) {
                    save = s;
                }
            }
        }
        //인접한 글자의 순서가 바뀌었는가? - 같은 길이의 문자열에서
        for (String s : dictionary[len]) {
            //탐색 후 있으면 find=true; 후 save와 s를 비교하여 사전순으로 앞인걸 저장, 후 break;
            for (int i = 0; i < len - 1; i++) {
                if (str.charAt(i) == s.charAt(i + 1) &&
                    str.charAt(i + 1) == s.charAt(i)) {

                    boolean same = true;
                    for (int k = 0; k < len; k++) {
                        if (k == i || k == i + 1) continue;
                        if (str.charAt(k) != s.charAt(k)) {
                            same = false;
                            break;
                        }
                    }

                    if (same) {
                        find = true;
                        // 입력순서가 더 빠른 단어로 갱신
                       // System.out.println(str+ "가능: "+s);
                        if (save.equals("") || order.get(s) < order.get(save)) {
                            save = s;
                        }
                    }
                }
            }
        }

        return find;
    }



}


