
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        String pattern="(100+1+|01)+";
        StringBuilder sb=new StringBuilder();
        String str;
        for(int t=1;t<=T;t++) {
        	str=br.readLine();
            if(str.matches(pattern)) sb.append("YES\n");
            else sb.append("NO\n");

        }
        System.out.println(sb);
        
    }
}
