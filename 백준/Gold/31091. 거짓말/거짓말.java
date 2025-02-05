import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] up = new int[N+1];
        int[] down = new int[N+1];
        
        int sub;
        for (int i = 0;i<N; i++) {
            sub = Integer.parseInt(st.nextToken());
            if (sub > 0) {//sub명 이상이 거짓말 하고 있다
                up[sub]++;
            } else {// sub명 이하가 거짓말 하고 있다
                sub *= -1;
                down[sub]++;
            }
        }
        // 누적합의 변곡점을 이용해서 누적합 완성
        for (int i = 1; i <=N; i++) {
            up[i] += up[i - 1];
            down[i] += down[i - 1];
        }
        //System.out.println("n명 이상 거짓말: "+Arrays.toString(up));
        //System.out.println("n명 이하 거짓말: "+Arrays.toString(down));
        
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        //거짓말 하고 있는 사람이 A명 이라고 가정할 때
      	// 1~(A-1)이하가 거짓말 하고 있다 + (A+1)~N명 이상이 거짓말 하고있다 가 A여야 한다.		
      		
        for (int i = 0; i <=N; i++) { // i=N도 들어가야함
        	int upVal = (i<N) ? up[N]-up[i] : 0;// i+1~ N명까지 거짓말 하고 있다.
            int downVal = (i>0) ? down[i - 1] : 0;// 0~(i-1)까지 거짓말 하고 있다.
            //System.out.println("?? "+upVal + downVal);
            if (upVal + downVal == i) {
                answer++;
                sb.append(i + " ");
            }
            
        }
        
        System.out.println(answer);
        System.out.println(sb);
    }
}