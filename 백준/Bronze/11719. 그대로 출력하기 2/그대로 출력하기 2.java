import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        String str;
        while(true) {
            str = br.readLine();
            if(str == null) {
                break;
            }
            sb.append(str).append("\n");
        }

		System.out.println(sb);
	}
	
	

}