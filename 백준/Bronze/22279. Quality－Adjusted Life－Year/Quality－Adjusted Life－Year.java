import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        double res = 0.0;
        
        for (int i = 0; i < n; i++) {
            double q = sc.nextDouble();
            double y = sc.nextDouble();
            res += q * y;
        }
        
        System.out.printf("%.3f\n", res);
        
        sc.close();
    }
}