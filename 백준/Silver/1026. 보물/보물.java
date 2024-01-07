import java.io.*;
import java.util.*;

public class Main {
	

	 //답을 찾아 보면 전부 문제 취지와 다르게 배열 둘다 재배열을 함. 배열1만 조작하여 풀어보고자 한다.
    public static void main(String [] args) throws IOException{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int n=Integer.parseInt(br.readLine());
    	int sum = 0;
    	int arr1[] = new int[n];
		int arr2[] = new int[n];
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<arr1.length; i++) {
			arr2[i] =Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1); // A배열 정렬
		Arrays.sort(arr2); // B배열 정렬
		
		for(int i=0; i<n; i++) {      // sum에 A배열은 최소값부터 
			sum += arr1[i]*arr2[n-1-i]; // B배열은 최대값부터 곱해서 더하기
		}
		System.out.println(sum);

    	
    }
  


}