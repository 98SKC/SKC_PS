import java.io.*;
import java.util.*;

 
class Main {

	static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max=(int) Math.pow(10, N);
        isPrime(max);

        helper(0,N);
        System.out.println(sb);
        
    }
   
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static void helper(int output, int n) {
        if (n == 0) {
            if (isPrime(output)) sb.append(output).append("\n");
            return;
        }
        
        for (int i=0; i<10; i++) {
            int next = output*10+i;
            if (isPrime(next)) helper(next, n-1);
        }
    }
    
   
}