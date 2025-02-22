import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] arr=new long[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		//System.out.print(Arrays.toString(arr));
		long fix;
		int left,right,mid;
		long[] answer=new long[3];
		long min=3000000001L;
		long sum;
		for(int i=0;i<N-2;i++) {// arr[i]를 확정으로 가졌을 때, 가장 작은 요소로 arr[N-3]이 최대		
			fix=arr[i];
			
			for(int j=i+1;j<N-1;j++) {//arr[j]와의 합이 0에 가장 가까운 나머지 하나를 구하는 for문
				left=j+1;
				right=N-1;
				while(left<=right){
					mid=left+(right-left)/2;
					sum=Math.abs(arr[j]+arr[mid]+fix);
					
					//System.out.println("fix: "+fix+" j와 두번째 고정: "+j+" "+arr[j]+" "+"left와 right, 그리고 mid인 마지막 요소: "+left+" "+right+" "+arr[mid]+" sum: "+sum);
					
					if(sum<min) {
						//System.out.println("원래 최소: "+min);
						answer[0]=fix;
						answer[1]=arr[j];
						answer[2]=arr[mid];
						min=sum;
						//System.out.println("정답후보: "+answer[0]+" "+answer[1]+" "+answer[2]);
					}
					//fix+arr[j]+arr[mid]>0   -5   8  이라고 하면 양수 arr[mid]가 더 작아지면(right가 작아지면) 0에 가까워 질 수 있음
					//fix+arr[j]+arr[mid]<0   -5  -4  이라고 하면 arr[mid]가 더 커지면(left가 더 커져야) 0에 가까움
					if(fix+arr[j]>=-arr[mid]) {
						right=mid-1;
					}else {
						left=mid+1;
					}
				}
			}

		}
		
		System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
		
		
	}
	
	
}