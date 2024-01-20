import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        
        n /= 100;
        n *= 100;
        int f = Integer.parseInt(br.readLine());
        

        while (n % f != 0) {
            n++;
            answer++;
        }
        if (answer < 10) {
            System.out.print("0" + answer);
        } else {
            System.out.print(answer);
        }
    }
}