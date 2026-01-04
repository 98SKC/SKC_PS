
import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static ArrayDeque<String> q;
	public static HashSet<String> v;
	public static HashSet<String>[] words;
	public static int max=0;// 사전에 저장한 문자열 중 최대의 길이
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        String start=st.nextToken();
        words=new HashSet[81];
        for(int i=1;i<=80;i++) {
        	words[i]=new HashSet<>();
        }
        
        q=new ArrayDeque<>();
        v=new HashSet<>();
        
        String word;
        int l;
        for(int i=0;i<N;i++){
        	word=br.readLine();
        	l=word.length();
        	max=Math.max(max, l);
        	words[l].add(word);
        }

        
        q.add(start);
        v.add(start);
        String answer="";
        
        //여기서 관건은 set을 완탐하냐 안하냐. 단어 개수는 1000개
        //1000번 탐색을 몇번함? 1000번함. 고로 완전탐색을 할 것
        //단어 하나씩 늘어나며 추가해도 1000번 함. 여기서 문제. 줄일 수 있는 방법이 있냐?
        //있다. 문자열 길이마다 set을 넣으면 작은 길이는 점프 가능.
        //여기서 의문은 이 방법을 채택함으로써 얻는 시간복잡도의 이점이, 단어 길이별로 HashSet의 배열을 만듬으로써 잃는 공간복잡도의 단점보다 크냐?
        //자 단어의 길이는 최대 80글자. 그럼 최대 HashSet[81]<String> set이 만들어짐.
        String w;
        
        while(!q.isEmpty()){
        	w=q.poll();
        	if(w.length()>answer.length()) answer=w;
        	
        	search(w);
        }
        
        
        System.out.println(answer);
        
    }
    
    
//    //word의 뒤로 이어지는 문자열을 추가- 문자열의 앞부분이 word와 같음
//    public static void searchTail(String word) {
//    	int start=word.length();
//    	for(int i=start+1;i<=max;i++){
//    		for(String s:words[i]){
//    			if(!v.contains(s)&&word.equals(s.substring(0,word.length()))){//이미 나온 단어가 아니며
//        			v.add(s);
//        			q.add(s);
//        		}
//    		}
//    	}
//    	
//    }
//    
//    //word의 중간에 단어를 추가해서 만들 수 있는 문자열을 추가- 문자열의 앞,뒤가 적절히 나누어짐
//    //차라리 이걸로 다 하는게 나은거 아닌가.
//    public static void searchBody(String word) {
//    	int start=word.length();
//    	for(int i=start+1;i<=max;i++){
//    		for(String s:words[i]){
//    			
//    			//중간까지 잘라서
//    			for(int j=1;j<s.length()-1;j++){
//    				
//    			}
//    			
//    			if(!v.contains(s)&&word.equals(s.substring(0,word.length()))){//이미 나온 단어가 아니며
//        			v.add(s);
//        			q.add(s);
//        		}
//    		}
//    	}
//    }
//    
//    //word의 앞부분에 단어를 추가해 만들 수 있는 문자열을 추가- 사전의 뒷부분이 word와 같음
//    public static void searchHead(String word) {
//    	int start=word.length();
//    	// 단어의 뒤를 자르는 메서드- subString(시작 인덱스, 포함하지 않을 인덱스); 
//    	// 길이 9면 인덱스 8까지 있고, word가 3글자면 8 7 6을 해야하고, 6을 산출하려면 length-word.length
//    	for(int i=start+1;i<=max;i++){
//    		for(String s:words[i]){
//    			if(!v.contains(s)&&word.equals(s.substring(s.length()-word.length()))){//이미 나온 단어가 아니며
//        			v.add(s);
//        			q.add(s);
//        		}
//    		}
//    	}
//    }
    
    //한글자라는게 알파벳 기준이였음
    public static void search(String word) {
        int wLen = word.length();
        int i = wLen + 1;
        if (i > max) return;

        for (String s : words[i]) {
            if (v.contains(s)) continue;

            // head: word == s의 앞부분 (뒤에 1글자 추가)
            if (word.equals(s.substring(0, wLen))) {
                v.add(s);
                q.add(s);
                continue;
            }

            //body: 중간에 '한'놈만 들어가는거. 한글자가 한 단어인줄 알고 길이별로 다해버렸네
            for (int j = 1; j < wLen; j++) {
                if (word.substring(0, j).equals(s.substring(0, j)) &&
                    word.substring(j).equals(s.substring(j + 1))) {
                    v.add(s);
                    q.add(s);
                    break;
                }
            }
            if (v.contains(s)) continue;

            // tail: word == s의 뒷부분 (앞에 1글자 추가)
            if (word.equals(s.substring(1))) { 
                v.add(s);
                q.add(s);
            }
        }
    }

    
        
}


