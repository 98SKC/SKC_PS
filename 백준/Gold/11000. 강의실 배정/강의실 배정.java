import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] preSum=new int[2*N];
		StringTokenizer st;
		int a,b;
		int max=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<2*N;i=i+2) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			map.put(a, map.getOrDefault(a, 0)+1);
			map.put(b, map.getOrDefault(b, 0)-1);
			preSum[i]=a;
			preSum[i+1]=b;
		}
		
		int answer=0;
		Arrays.sort(preSum);
		int count=0;
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		int before=-1;
		for(int i=0;i<2*N;i++) {
			if(i!=0&&preSum[before]==preSum[i]) continue;
			sb1.append(preSum[i]+" ");
			sb2.append(map.get(preSum[i])+" ");
			count+=map.get(preSum[i]);
			answer=Math.max(answer, count);
			before=i;
		}
		//System.out.println(sb1);
		//System.out.println(sb2);
		//System.out.println();
		System.out.println(answer);
		
	}
	
	
}