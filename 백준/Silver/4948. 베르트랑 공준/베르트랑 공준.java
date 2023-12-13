import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] prime;
    public static int[] primeNumber;
    public static int M;
    public static int increase=0;
    public static int max=246912;//123456*2
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int number=1;
        int answer=0;
        primeNumber=new int[max+1];
        prime=new boolean[max+1];
        primeNumber[0]=0;
        primeNumber[1]=0;

        for(int i=2;i<=max;i++){// 초기화
            prime[i]=true;
        }
        isPrime();
        checkPrime();

        while(number!=0){
            number=Integer.parseInt(br.readLine());
            if(number==0) continue;
            answer=primeNumber[number*2]-primeNumber[number];
            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }

    public static void isPrime(){// 해당 수가 소수인지 판별

        for(int i=2;i<=Math.sqrt(max+1);i++){
            if(prime[i]){
                for(int j=i*i;j<=max;j+=i){
                    prime[j]=false;// 0은 소수가 아님을 의미
                }
            }

        }
    }
    public static void checkPrime(){// 지금 숫자를 포함한 이전 숫자에 소수가 몇개인지 저장.

        for(int i=0;i<prime.length;i++){
            if(prime[i]) increase++;
            primeNumber[i]=increase;
        }
    }



}
