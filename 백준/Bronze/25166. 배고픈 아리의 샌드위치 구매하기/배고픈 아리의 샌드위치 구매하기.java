
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // int의 비트 표기법
        int a=0b10001;
        int b=0b01110;
        
        // 비트연산 예시
        int and = a & b;  // 0b10001 & 0b01110 = 0b00000 (0)
        int or  = a | b;  // 0b10001 | 0b01110 = 0b11111 (31)
        int xor = a ^ b;  // 0b10001 ^ 0b01110 = 0b11111 (31)
        
        //비트를 반전시키기 ->1을 xor
        int mask = 0b11111;           
        int reverse=a^mask;
        //--------------------------------------------------
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int S=Integer.parseInt(st.nextToken()); //센드위치 가격
        int M=Integer.parseInt(st.nextToken()); //빌려줄 수 있는 돈
        
        int ari=0b1111111111;
        
        //아리가 가진 금액만으로 빵을 살 수 있다면 No thanks
        //아리가 가진 모든 금액을 사용하고, 돈을 빌려서 살 수 있다면 thanks
        //그래도 살 수 없다면 Impossible;
        
        int need;
        //System.out.println("air: "+ari);
        if(ari>=S) {
        	System.out.println("No thanks");// air의 동전 조합의 합보다 낮은 가격은 모두 표현 가능
        }else{
        	need=S-ari;
        	//need의 모든 1 부분이 M의 1부분과 일치해야함.
        	int check=need&M;// 
        	if(need==check) System.out.println("Thanks");
        	else System.out.println("Impossible");
        	
        }
        
    }
}
