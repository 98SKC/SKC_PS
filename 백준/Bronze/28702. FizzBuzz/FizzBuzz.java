import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num=0;
        String str;
        for(int i=0;i<3;i++) {
        	str=br.readLine();
        	if(str.charAt(0)-'0'<=9) {
        		num=Integer.parseInt(str);
        		num=num+(3-i);
        		break;
        	}
        }
        String answer="";
        if(num%3==0) {
        	if(num%5==0) {
        		answer="FizzBuzz";
        		num=-1;
        	}else {
        		answer="Fizz";
        		num=-1;
        	}
        }else {
        	if(num%5==0) {
        		answer="Buzz";
        		num=-1;
        	}else {
        		System.out.println(num);
        	}
        }
        if(num==-1) {
        	System.out.println(answer);
        }

    }
}