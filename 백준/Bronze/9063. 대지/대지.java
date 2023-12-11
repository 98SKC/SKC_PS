import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       int minX = Integer.MAX_VALUE; 
       int minY = Integer.MAX_VALUE; 
       int maxX = -10000; 
       int maxY = -10000;
        
       for (int i = 0; i < T; i++) {
           int x = sc.nextInt();
           int y = sc.nextInt();
           minX = Math.min(minX, x);
           maxX = Math.max(maxX, x);
           minY = Math.min(minY, y);
           maxY = Math.max(maxY, y);
       }
       int x = maxX-minX;
       int y = maxY-minY;
       System.out.println(x*y);

    }
}