import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int min=Integer.MAX_VALUE;
		
		int max=0;
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			min=Math.min(min, arr[i]);
			max=Math.max(max, arr[i]);
		}
		
		int left=0;
		int right=max-min;
		//System.out.println(left+" "+right);
		int mid;
		
		while(left<=right) {
			
			mid=left+(right-left)/2;//최대값이 mid일 때 M개 이하의 그룹으로 만들 수 있는가
			//System.out.print(mid+" ");
			int subMin=Integer.MAX_VALUE;
			int subMax=0;
			int count=0;
			for(int i=0;i<N;i++) {
				if(count>=M) break;
				subMin=Math.min(subMin, arr[i]);
				subMax=Math.max(subMax, arr[i]);
				if(subMax-subMin<=mid) {
					continue;
				}else {
					//System.out.print(subMax+" "+subMin+" "+(subMax-subMin));
					//System.out.print("다음 "+i+"부터 ");
					count++;// 그룹 하나 생성
					i--;//여기부터 다시
					subMin=Integer.MAX_VALUE;
					subMax=0;
				}
				
			}
			//System.out.println(count+1);
			if(count+1>M) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		
		
		System.out.println(left);
		
	}
	
	
}