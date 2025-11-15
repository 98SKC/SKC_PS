import java.util.*;
import java.io.*;
import java.math.BigInteger;   // BigInteger 추가



public class Main {

	public static int N;
	public static Stack[] stack=new Stack[4];
    public static StringBuilder sb=new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //하노이탑
        //세장의 장대가 있고, 첫번째 장대에 반경이 다른 N개의 원판이 쌓여있다.
        //다른 장대로 원판을 옮길 수 있으나, 위의 원판은 아래 원판보다 항상 작아야 한다.
        //첫번째 장대에서 세번째 장대로 옮기는 최소한의 이동횟수의 이동 순서를 출력하라.
        //N이 20 이상이면 과정은 출력할 필요가 없다.
        
        N=Integer.parseInt(br.readLine());
        
        // 이동 횟수는 재귀 말고, 점화식 K(n) = 2*K(n-1) + 1 로 BigInteger로 계산
        BigInteger moves = BigInteger.ZERO;      // K(0) = 0
        BigInteger two   = BigInteger.valueOf(2); // 2 상수
        
        for (int i = 0; i < N; i++) {
            moves = moves.multiply(two).add(BigInteger.ONE); // K(n) = 2*K(n-1) + 1
        }
       
        System.out.println(moves.toString()); // 첫 줄: 총 이동 횟수 출력
        
        // 실제 이동 과정(순서)은 N이 20 이하일 때만 구한다.
        if (N <= 20) {
            for(int i=1;i<=3;i++) {
            	stack[i]=new Stack<Integer>(); 
            }
            
            for(int i=N;i>0;i--) {
            	stack[1].push(i);
            }
            
            boolean p=true;   // N<=20일 때만 호출하므로 항상 출력 모드
            
            Hanoi(N,1,2,3,p);
            System.out.println(sb);
        }
    }
    
    
    
    //						 N개를   from에서  mid를 보조로 to로 옮기려 한다. 분할정복 느낌
    public static void Hanoi(int N, int from, int mid, int to, boolean p) { 

    	// 이동할 원반의 수가 1개라면?
    	if (N == 1) {
    		if(p) sb.append(from+" "+to+"\n");
    		stack[to].push(stack[from].pop());
    		return;
    	} 
     
    	// A -> C로 옮긴다고 가정할 떄,
    	
    	// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
    	// A의 가장 큰 원판을 C로 옮기기 위해 그 위의 모든것들을 B로 옮기는 것.
    	Hanoi(N - 1, from, to, mid,p);
    	
    	// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
    	if(p) sb.append(from+" "+to+"\n");
    	stack[to].push(stack[from].pop());
    	
    	// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
    	Hanoi(N - 1, mid, from, to,p);// 이 그대로 C의 목적지로 옮기는 것이 목표이기에.
    }
}
