import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int i = 1; i <= T; i++) {
            
            int A = 0;
            int B = 0;
            
            StringTokenizer st;
            st = new StringTokenizer(sc.nextLine()); 
            A = sc.nextInt(); 
            B = sc.nextInt(); 
            int min = Math.min(A, B); 
            if (min == A) {
                while (true) {
                    if (B - A < A) break; 
                    B /= 2; 
                }
            } else {
                while (true) {
                    if (A - B < B) break; 
                    A /= 2; 
                }
            }

            while (A != B) {
                if (A > B) {
                    A /= 2; 
                    if (A == B) break; 
                    B /= 2; 
                } else {
                    B /= 2; 
                    if (A == B) break; 
                    A /= 2; 
                }
            }

            System.out.print((A * 10) + "\n");
        }
    }
}