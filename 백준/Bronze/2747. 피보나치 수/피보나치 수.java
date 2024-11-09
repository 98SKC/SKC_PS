import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] fibo=new int[46];
        fibo[1]=1;
        for(int i=2;i<=N;i++) {
        	fibo[i]=fibo[i-1]+fibo[i-2];
        }
        System.out.println(fibo[N]);
    }
}