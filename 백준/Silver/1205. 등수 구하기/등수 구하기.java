import java.util.*;

public class Main {
	public static int n,score,p;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		score=sc.nextInt();
		p=sc.nextInt();
		arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		if(n==p&&arr[n-1]>=score) {
			System.out.println(-1);
			System.exit(0);
		}
		
		// 이외의 경우라면 자신의 랭킹을 구한다.
		int rank=1;
		for(int i=0;i<n;i++) 
			if(arr[i]>score)
				rank++;
			else
				break;
	
		System.out.println(rank);
	}

}