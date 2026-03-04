import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  
        
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();  
            int M = sc.nextInt();  
            
            int result = countZeros(N, M);  
            
            System.out.println(result);  
        }
    }
    
 
    public static int countZeros(int N, int M) {
        int count = 0;  
        
        for (int num = N; num <= M; num++) {
            int currentNum = num;  
            if (currentNum == 0) {
                count++;  
            } else {
                while (currentNum > 0) {
                    int digit = currentNum % 10;  
                    if (digit == 0) {
                        count++;  
                    }
                    currentNum /= 10;  
                }
            }
        }
        
        return count;  
    }
    
}