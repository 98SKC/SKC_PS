import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//정육면체 상자가 일렬로
		//앞의 상자가 뒤의 상자보다 작으면, 앞의 상자를 뒤의 상자에 넣을 수 있다.
		
		//최장증가부분순열을 구하는 문제
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] lis=new int[N];
		
		int left,right,mid;
		int end=0;//들어갈 수 있는 공란
		for(int i=0;i<N;i++) {
			left=0;
			right=end;
			
			//lower bound
			while(left<right){
				mid=left+(right-left)/2;

				if(lis[mid]<arr[i]){//상자가 오른쪽으로 가야함
					left=mid+1;
				}else{
					right=mid;
				}
				
				
			}
			lis[left]=arr[i];
			//System.out.println(Arrays.toString(lis));
			if(left==end) end++;
		}
		
		System.out.println(end);
		
		
	}
	
	

}