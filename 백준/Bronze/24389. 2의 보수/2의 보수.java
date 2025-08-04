

import java.util.*;
import java.io.*;

public class Main {
    //비트마스킹 연습
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
        // 2) 시프트 연산
        int leftShift       = a << 2;   // 0b10001 << 2 = 0b1000100 (68)    : 왼쪽으로 2비트 이동 (×4)
        int signedRight     = a >> 2;   // 0b10001 >> 2 = 0b000100 (4)      : 부호 비트 유지하며 오른쪽으로 2비트 이동 (÷4)
        int unsignedRight   = a >>> 2;  // 0b10001 >>> 2 = 0b001000 (8)     : 0을 채우며 오른쪽으로 2비트 이동
        
        
        //-------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int comp=~N+1;    // 2의 보수
        int answer=0;
        
        // 방법1. 메서드 사용. a 와 comp 사이에 다른 비트(1로 나오는 자리)의 개수
        int diffBits = Integer.bitCount(a ^ comp);
        
        // 방법2. 시프트하며 순회
        int x=N^comp;//같으면 0이나옴
        while(x!=0) {
        	answer+=x&1;// 다른 개수를 찾음
        	x>>>=1;
        }
        
        
        System.out.println(answer);
        
    }
}
