import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;

//풀이 1. 배열 앞부터, 뒤를 비교해가며 자기보다 작은 수를 직접 세가며 배열을 생성. n+(n+1)+(n+2)...-> 시간복잡도 O(n^2)
//풀이 2. HashMap을 사용해서 배열을 만들때, 배열을 미리 복사. Arrays.sort 한 후에 배열 원소 위치를 map에 저장. 복사된 배열을 탐색하면서, 배열 값을 키로  map의 값을 불러옴.
//-> 풀이 2는 공간복잡도도 시간복잡도도 클 것 같다.

public class Main {
	public static boolean[] prime;
	

	//map이용 해볼까
	public static void main(String[] args) throws IOException {
 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		prime=new boolean[1000001];
		for(int i=2;i<=1000000;i++) {
			prime[i]=true;
		}

		searchPrime(1000000);
		int sub;
		int count;
		for(int i=0;i<N;i++) {
			count=0;
			sub=Integer.parseInt(br.readLine());
			for(int j=2;j<=sub/2;j++) {
				if(prime[j]&&prime[sub-j]) count++;
			}
			sb.append(count).append("\n");
		}
	  
		System.out.println(sb);
	}
	public static void searchPrime(int N) {
		for(int i=2;i<= Math.sqrt(N);i++) {
			if(prime[i]) {
				for(int j=i*i;j<=N;j+=i) {
					prime[j]=false;
				}
			}
		}
	}
}