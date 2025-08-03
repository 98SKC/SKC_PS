
import java.util.*;
import java.io.*;

public class Main{

	
	
	public static int[][] arr=new int[10][10]; //0,1,2,3,4,5,6,7,8,9인 i를 0,1,2,3,4,5,6,7,8,9 인 j로 바꾸는데 필요한 반전 수  
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); //N개의 층이 있는 빌딩
        int K=Integer.parseInt(st.nextToken()); //디스플레이 자리 수
        int P=Integer.parseInt(st.nextToken()); //반전 가능한 수
        int X=Integer.parseInt(st.nextToken()); //멈춰있는 층 수
        
        int[] seg = {
        	    0b1111110, // 0
        	    0b0110000, // 1
        	    0b1101101, // 2
        	    0b1111001, // 3
        	    0b0110011, // 4
        	    0b1011011, // 5
        	    0b1011111, // 6
        	    0b1110000, // 7
        	    0b1111111, // 8
        	    0b1111011  // 9
        };
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int diff = seg[i] ^ seg[j];
                int cnt = 0;
                // 매 반복마다 최하위 비트를 검사하고 오른쪽으로 시프트
                while (diff != 0) {
                    cnt += (diff & 1);
                    diff >>>= 1;
                }
                arr[i][j] = cnt;
            }
        }
        int tmpX=X;
        int[] display=new int[K];
        for(int i=K-1;i>=0;i--){
        	if(tmpX==0) break;
        	display[i]=tmpX%10;
        	tmpX/=10;
        }
        
        int answer = 0;
        for (int num = 1; num <= N; num++) {
            if (num == X) continue;  // 현재 표시된 층은 제외

            // num을 K자리로 분할
            int[] cand = new int[K];
            int tmp = num;
            for (int i = K - 1; i >= 0; i--) {
                cand[i] = tmp % 10;
                tmp /= 10;
            }

            // 반전 필요 횟수 누적
            int need = 0;
            for (int i = 0; i < K; i++) {
                need += arr[display[i]][cand[i]];
                if (need > P) break;  // 이미 초과하면 더 볼 필요 없음
            }

            if (need <= P) answer++;
            
        }
        
        System.out.println(answer);
    }
}
