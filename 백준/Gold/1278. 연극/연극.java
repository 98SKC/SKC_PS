
import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int init;
	public static boolean[] v;
	public static int max=0;
	
	
	//해설. 그레이코드를 만든다.
	//그레이 코드: 연속된 비트들이 하나의 비트만 차이가 나는 코드

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
     
       
        //N명의 배우들이 출연하는 연극
        //연극은 연속된 K개의 장면으로 구성
        //각 장면에는 한명 이상의 배우
        //각 장면에는 단한명의 배우만 이동. 새로운 배우가 나오거나, 한명이 들어감.
        //시작전과 끝난 후는 무대가 비어있어야한다. 첫번째와 마지막 장면에 한명만 있어야 한다.
        //각 장면에서의 배우 구성은 달라야한다.
        //연극은 가능한 많은 장면으로 구성되어있어야 한다.
        
        //N이 주어질 때 첫번째로 최대 장면의 수K, 이후 변동있는 배우의 번호를 K번 출력한다.

        
        
        int mask=(1 << N)-1; // N비트 모두 1
        v=new boolean[mask+1];//가능한 경우의 수
        init=0&mask; // N비트 모두 0 (결국 0)
        
        int[] gray = buildGray(N);   // 길이 = 2^N, gray[0] = 0(공집합), gray[1..] = 장면들

        StringBuilder sb=new StringBuilder();
        
        //장면의 수는 공집합(00000)을 제외한 수.
        int K = (1 << N) - 1;
        int[] scene = new int[K];
        for (int i = 1; i <= K; i++) scene[i - 1] = gray[i];
        
        sb.append(K+"\n");
        //첫 장면 배우 번호 (LSB부터 켜진 비트 위치 + 1)
        
        //찾는 것은 비트 인덱스가 아닌 번호. 0부터 시작 vs 1부터 시작
        sb.append((bitIndex1(scene[0]) + 1)+"\n");
        //변동 배우 번호들 K-1줄
        for (int i = 1; i < K; i++) {
            int diff = scene[i - 1] ^ scene[i]; // 인접 장면은 항상 1비트만 다름
            sb.append((bitIndex1(diff) + 1)+"\n");
        }

        //마지막 장면 배우 번호
        sb.append((bitIndex1(scene[K-1]) + 1)+"\n");
        
        System.out.println(sb);
    }
    
    
    //그레이크드 작성 메서드
    //작동 원리
    //G1 = [0, 1]
    //Gn = [ 0 + G(n-1),    1 + reverse(G(n-1)) ] ... 로 만든다.
    //0 + X 는 맨 앞에 0비트를 붙인다. 1 + X는 맨 앞에 1을 붙인다.
    //Gn은 이미 그레이코드가 달성되어있다. n-1의 그레이코드에서 n비트로 늘리려면
    //Gn-1의 그레이코드의 맨 앞에 0을 붙인 것은 그대로 그레이코드
    //그리고 뒤집은 Gn-1의 맨 앞에 1을 붙이고, 이를 Gn에 연결하면 Gn의 중간은 맨앞 비트가 0,1 로만 다른
    //두 원소가 연결되고, 그 뒤로 쭈욱 그레이코드.
    //Gn을 구하는 그레이코드를 재귀로 방문한다.
    static int[] buildGray(int n) {
    	
        if (n == 1) {
            return new int[]{0, 1};
        }
        
        int[] prev = buildGray(n - 1);          // 길이 2^(n-1)
        
        
        int half = prev.length;                 // = 2^(n-1)
        int[] cur = new int[half << 1];         // 길이 2^n
        int add = 1 << (n - 1);                 // 상위비트(앞에 '1' 프리픽스)

        // 앞 절반: 앞에 0 붙이기 → 값 변화 없음
        // 예) prev = [0,1,3,2]  →  [0,1,3,2]
        for (int i = 0; i < half; i++) {
            cur[i] = prev[i];
        }

        // 뒤 절반: reverse(prev)에 앞에 1 붙이기 → add OR 연산
        // 예) reverse(prev) = [2,3,1,0]
        // 여기에 add(=1<<(n-1))를 OR: [2|add, 3|add, 1|add, 0|add]
        for (int i = 0; i < half; i++) {
            cur[half + i] = prev[half - 1 - i] | add;
        }

        return cur;
    }


    static int bitIndex1(int x) {
        int idx = 0;
        while ((x & 1) == 0) { // LSB부터 오른쪽으로 이동
            x >>= 1;
            idx++;
        }
        return idx;
    }
    
}
