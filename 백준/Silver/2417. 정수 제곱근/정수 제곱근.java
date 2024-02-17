import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long q = (long)Math.sqrt(n);
        if((q*q) < n) q++;
        System.out.println(q);
    }
}