
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        //두 빌딩의 사이
        //길이가 x인 사다리는 오른쪽 빌딩의 아래를 받침대.
        //길이가 y인 사다리는 왼쪽 빌딩의 아래를 받쳐 서로의 기둥에 기대어 있다.
        //그리고 두 사다리는 땅에서 c인 위치에서 서로 교차한다.
        // 두 빌딩이 떨어져 있는 거리를 구하라
        double x=Double.parseDouble(st.nextToken());
        double y=Double.parseDouble(st.nextToken());
        double c=Double.parseDouble(st.nextToken());
        
        double h1,h2,width;
    	
        double res;
        
        double left=0;
        double right=Math.min(x, y);
        double mid;
        
        // 실수 이분탐색: 정확히 같은 값을 못 맞추므로,
        // 구간 폭이 충분히 작아질 때(오차 허용범위)까지 반복
        // 출력은 소수 셋째자리까지.
        while (right - left > 1e-3) {
            width = (left + right) / 2.0;  // w 후보값
            
            // 현재 w에서 각 사다리의 벽 높이
            h1 = Math.sqrt(x * x - width * width);
            h2 = Math.sqrt(y * y - width * width);
            
            // 교차 높이 c'(w) = (h1*h2) / (h1 + h2)
            // (h1+h2는 양수. 단, width가 min(x,y)에 극도로 가까우면 h가 0에 근접)
            res = (h1 * h2) / (h1 + h2);
            
            
            // c'(w) > c  ⇒ 현재 w가 너무 작다(사다리가 덜 눕고 교차점이 더 높음) ⇒ w를 키움
            // c'(w) < c  ⇒ 현재 w가 너무 크다 ⇒ w를 줄임
            if (res > c) {
                left = width;
            } else {
                right = width;
            }
        }
        
        // 수렴 후 right(또는 left, mid 아무거나) 출력
        // 문제 요구 포맷에 맞게 소수점 셋째자리까지 출력
        System.out.printf("%.3f\n", right);
        
        
        
        
    }
}
