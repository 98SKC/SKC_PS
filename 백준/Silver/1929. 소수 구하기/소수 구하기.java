import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] prime;
    public static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        prime=new boolean[M+1];
        isPrime(prime);



        for(int i=N;i<=M;i++){

            if(prime[i]){

                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void isPrime(boolean[] prime){


        for(int i=2;i<=M;i++){
            prime[i]=true;
        }

        for(int i=1;i<=Math.sqrt(M);i++){// 시간 단축을 위해 제곱근까지만 체크. 1은 소수가 아님
            if(prime[i]){// 소수가 맞으면
                for(int j=i*i;j<=M;j+=i){// 그 소수의 모든 배수는 소수가 아님.

                    prime[j]=false;
                }
            }


        }
    }



}
