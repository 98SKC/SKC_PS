import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        
        sb.append((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+(a/b)+"\n"+(a%b));
        
        System.out.println(sb);
    }
}