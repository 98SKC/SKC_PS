import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
  
        boolean[] isPrime=new boolean[N+1];
        int[] prime=new int[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=isPrime[1]=false;
        
        int end=1;
//        for(int i=2;i*i<=N;i++) {
//        	if(isPrime[i]) {
//        		prime[end]=i;
//        		end++;
//        		for(int j=i*i;j<=N;j+=i) {
//        			isPrime[j]=false;
//        		}
//        	}
//        }
        for (int i = 2; i * i <= N; i++) { // i의 제곱이 N을 초과하지 않는 범위까지만 수행
            if (isPrime[i]) {
        		end++;
                for (int j = i * i; j <= N; j += i) { // i의 배수를 모두 제거
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
        		prime[end]=i;
        		end++;
            }
        }

        int[] preSum=new int[end+1];
        preSum[0]=prime[0];
        for(int i=1;i<=end;i++) {
        	preSum[i]=preSum[i-1]+prime[i];
        }
        int sum=0;
        int answer=0;
        int left=0;
        int right=0;
      //  System.out.println(Arrays.toString(prime));
      //  System.out.println(Arrays.toString(preSum));
      //  System.out.println("end: "+end);
        while(left<end&&right<end) {
        	//System.out.println(left+" "+right);
        	//if(left==0&&right==5) System.out.println("왜 안되는 경우?: "+preSum[right]+" "+preSum[left]+" "+prime[left]+" "+prime[right]+" "+N);
    		
        	if(preSum[right]-preSum[left]==N) {
        		answer++;
        		//System.out.println("되는 경우: "+preSum[right]+" "+preSum[left]+" "+prime[left]+" "+prime[right]+" "+N);
        		right++;
        	}else if(preSum[right]-preSum[left]>N){
        		left++;
        	}else {
        		right++;
        	}
        }
        System.out.println(answer);
        
    }
}