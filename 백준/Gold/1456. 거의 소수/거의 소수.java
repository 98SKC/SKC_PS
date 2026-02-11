import java.io.*;
import java.util.*;

public class Main {

    public static long A,B;
    public static final int maxSqrt =10000000;
    public static final long max=100000000000000L;
    public static boolean[] isPrime=new boolean[maxSqrt +1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //어떤 수가 소수의 N제곱이면, 그 수를 거의 소수라고 한다.
        //정수 A와 B가 주어지면 A<= X <=b 인 거의소수 X의 개수를 출력하라
        // A,B 는 long이다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        A=Long.parseLong(st.nextToken());
        B=Long.parseLong(st.nextToken());


        // 에라토스테네스 + 누적합 이라기에는 1번 완탐이 백조인데
        // 누적합 배열을 만드는데 100조는 벌써 글렀는데
        // 백조까지 에라토스테네스의 체를 만드는건? NlogN
        // 백조 루트면? 10000000 어라 할만한가.
        // 근데 누적합 만들려면 어차피 완탐해야하는거 아닌가.
        // 누적합 안만들고 바로해도 될 것 같은데
        long answer=0;
        getPrime();

        for(int i=2;i<=maxSqrt;i++){
            if(isPrime[i]){//소수면 A부터 B사이의 거의소수를 카운트
                long p = (long) i * i;
                while(p<=B){
                    if(p>=A&&p<=B) answer++;
                    if (p > B / i) break; // 오버플로우 방지
                    p*=i;

                }
            }
        }

        System.out.println(answer);
    }

    public static void getPrime(){
        //거의 소수가 소수의 제곱이니, 소수를 10000000이상의 소수의 제곱이 백조 안에 있을리 없음. 그러니 천만까지의 소수만 구함.
        int len= (int) Math.sqrt(maxSqrt)+1; //int 변환했으니 안전하게 +1까지

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= len; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxSqrt; j += i) {
                    isPrime[j] = false;
                }
            }
        }

    }

}


//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
