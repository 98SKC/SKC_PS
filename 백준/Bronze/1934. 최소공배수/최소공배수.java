import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int answer=0;
        for(int test_Case=0;test_Case<T;test_Case++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            answer=lcm(a,b);
            System.out.println(answer);
        }
    }

    public static int gcd(int a,int b){
        if(b==0) return a;

        return gcd(b,a%b);
    }

    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
}
