import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static int answer=0;
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0,1,2개의 숫자를 가지고 3의 배수를 만든다.
        //N을 입력받아 N자리의 3의배수를 몇개 만들 수 있는지 출력하라.

        //N자리 숫자 중 0,1,2로만 이루어진 3의 배수의 개수를 구하는 문제.

        N=Integer.parseInt(br.readLine());

        //브루드포스 아닌가
        bruteForce(1,0);

        System.out.println(answer);

    }

    public static void bruteForce(int pos, int number) {
        // N자리 숫자가 완성된 경우
        if (pos > N) {
            if ((number/Math.pow(10, N-1))>=1&&number % 3 == 0) {
                answer++;
            }
            return;
        }

        // 다음 자리에 0 추가 (스킵하면 0이 추가되긴하는데, 00001같이 될 수 있으니 마지막에 확인)
        bruteForce(pos + 1, number);
        // 다음 자리에 1 추가
        bruteForce(pos + 1, number + (int)Math.pow(10, pos-1));
        // 다음 자리에 2 추가
        bruteForce(pos + 1, number + 2 * (int)Math.pow(10, pos-1));
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
