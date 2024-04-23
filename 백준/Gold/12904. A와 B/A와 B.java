import java.util.*;
import java.io.*;

public class Main {

	
	static String goal;
	static boolean check;
	static int cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        //반대로 생각-> t를 s로 바꿔보자
        while (S.length() < T.length()&&T.length()>0) {//t가 s보다 긴동안. 혹시 모르니 0이상일 경우도
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            }else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();// 문자열을 뒤집는다.
            }
        }
        if(T.toString().equals(S.toString())) {
        	System.out.println(1);
        	return;
        }
       
        System.out.println(0);
    }
    
    
 
}