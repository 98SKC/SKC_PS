import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chino=br.readLine();
        
        int len=chino.length();
        int under=0;
        int alpha=0;
        for(int i=1;i<len-1;i++) {
        	if(chino.charAt(i)=='_') {
        		under++;
        	}else {
        		alpha++;
        	}
        }
        
        int answer=len+2+(under*5);
        System.out.println(answer);
    }
}