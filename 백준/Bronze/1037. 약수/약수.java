import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
    	
    	
    	
    	//첫째줄은 진짜 약수(1과 자기 자신을 제외한 약수)의 개수
    	//둘째 줄에는 N의 진짜 약수들.
    	//제일 먼저 떠오르는 건 정렬시키고, 첫번째랑 마지막을 곱하는 것.
    	//찾아보니 정렬을 안해도, 최대 최소를 꺼낼 수 있음. 배열 넣는 과정에서 진행
    	//근데 이렇게 해보니, 배열을 굳이 만들어야하나?
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int N=Integer.parseInt(br.readLine());
    	//int[] arr=new int[N];
    	int sub=0;
    	StringTokenizer st=new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    	
    	for(int i=0;i<N;i++) {
    		sub=Integer.parseInt(st.nextToken());
    		min=Math.min(min, sub);
    		max=Math.max(max, sub);
    	}
    	
//    	Arrays.sort(arr);

    	
    	System.out.println(max*min);
       
    }
}


