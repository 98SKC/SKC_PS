import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
    	
    	
    	
    	//첫째줄은 진짜 약수(1과 자기 자신을 제외한 약수)의 개수
    	//둘째 줄에는 N의 진짜 약수들.
    	
    	//제일 먼저 떠오르는 건 정렬시키고, 첫번째랑 마지막을 곱하는 것.
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int N=Integer.parseInt(br.readLine());
    	int[] arr=new int[N];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	
    	for(int i=0;i<N;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	System.out.println(arr[0]*arr[arr.length-1]);
       
    }
}

