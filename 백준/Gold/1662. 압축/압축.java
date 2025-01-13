import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();
        
        Stack<Integer> stack= new Stack<>();
        Stack<Integer> save=new Stack<>();
        
        
        char sub;
        int len=0;
        
        for(int i=0;i<S.length();i++) {
        	sub= S.charAt(i);
        	if(sub=='(') {
        		len-=1;// 바로 이전 숫자는 곱하기 용이기에 제외.
        		int before=S.charAt(i-1)-'0';
        		stack.add(before);
        		save.add(len);// 잠깐 저장용
        		len=0;
        		
        	}else if(sub==')') {
        		int number=stack.pop();
        		number*=len;// 잠시 저장한 시점부터 카운트해온 문자열의 길이를 곱한다.
        		len=number+save.pop();// len은 이전에 저장한 수와 이번에 곱해서 나온 수의 합
        		
        	}else {// 숫자인 경우
        		len++; //길이의 증가
        	}
        }
        
        System.out.println(len);
       
    }
}