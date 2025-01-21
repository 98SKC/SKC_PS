import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        
        Stack<Integer> stack=new Stack<>();
        ArrayList<int[]> list=new ArrayList<>();
        
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)=='(') {
        		stack.add(i);
        	}else if(str.charAt(i)==')') {
        		list.add(new int[]{stack.pop(),i});
        	}
        }
        HashSet<String> answer=new HashSet<>();  //중복 방지
        
        int index=list.size();
        for(int mask=1; mask<(1<<index);mask++) {
        	boolean[] remove = new boolean[str.length()];// 삭제할 문자의 위치에 true
        	
            for (int i = 0; i < index; i++) {// ex) mask가 3 일때 이진수로 표현한 경우 어디에 1이 있는지 탐색.
            	// 0101d을   1, 10, 100, 100.... 과 &연산을 하여 1이 있는 i, 즉 삭제할 괄호쌍의 인덱스(키)를 찾는다.
                if ((mask & (1 << i)) != 0) { // i번째 괄호 쌍 포함 여부 확인
                    remove[list.get(i)[0]] = true; // 여는 괄호 제거
                    remove[list.get(i)[1]] = true; // 닫는 괄호 제거
                }
            }
            //이제 문자열을 탐색하며 삭제하지 않았으면 sb에추가
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!remove[i]) {
                    sb.append(str.charAt(i));
                }
            }

            answer.add(sb.toString()); // 중복 방지
        	
        }
        
        // 4. 결과 정렬 및 출력
        List<String> result = new ArrayList<>(answer);
//        for(String a: answer) {
//        	result.add(a);
//        }
        
        Collections.sort(result);
        StringBuilder sb=new StringBuilder();
        for (String r:result) {
        	sb.append(r+"\n");
        }

        System.out.println(sb);
        
        
    }
}