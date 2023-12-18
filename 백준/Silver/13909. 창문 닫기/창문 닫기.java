import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;

//1번째 생각-> 약수의 개수를 구해서, 홀수면 1, 짝수면 0을 배열에 저장
//2번째 생각-> 배열 굳이 안쓰고 count해도 될것 같았다.
//3번째 생각-> count를 사용하니 시간초과가 일어났고, 배열로 해보니 메모리 초과가일어남. 
//-> 약수의 개수가 홀수인 것은 완전제곱수 뿐이라는 것을 이용하는 것은 동일하나, Math.sqrt(N)사용시 N의 정수범위가 N이하의 완전제곱수의 개수이기도 한다고 한다.

public class Main {
	public static boolean[] prime;
	

	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int count=0;
		int N=Integer.parseInt(br.readLine());
		//int[] windows=new int[N+1];


		count=(int)Math.sqrt(N);
		
		System.out.println(count);
	
	}
//	public static int search(int n) {
//		// 다 돌릴 필요없이 완전제곱수면 약수가 홀수.
//		근데 
//		int count=0;
//		for(int i=1;i<=Math.sqrt(n);i++) {
//			if(n%i==0&&i!=Math.sqrt(n)) {
//				count+=2;
//			}else if(n%i==0&&i==Math.sqrt(n)){
//				count+=1;
//			}
//		}		
//		return count;
//	}
}