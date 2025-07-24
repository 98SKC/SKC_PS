
import java.util.*;
import java.io.*;

public class Main{

	
	//문자열 생 기초부터 재활하기 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String bowls=br.readLine();
        int len=bowls.length();
        char before='.';
        char bowl;
        int answer=0;
        for(int i=0;i<len;i++) {
        	bowl=bowls.charAt(i);
        	if(bowl==before) answer+=5;
        	else answer+=10;
        	
        	before=bowl;
        }
        System.out.println(answer);
        //그릇을 같은 방향으로 쌓으면 5증가
        //반대로 쌓으면 10 증가.
        
    }
}
