import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();  
            int n = str.length();  
            boolean check = true;
            if (str.equals("0")) break;
            for (int i = 0; i <= n/2; i++) {
                if (str.charAt(i) != str.charAt(n-i-1)) check = false; 
            }
            if (check) {  
                sb.append("yes").append("\n");
            } else {  
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }
}