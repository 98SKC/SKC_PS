import java.io.*;
import java.util.*;


public class Main {


	static int[][] arr;
	static int N;
	static int min=Integer.MAX_VALUE;
	static List<int[]> list=new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr=new int[N][2];
		
		for(int i=0;i<N;i++) {//음식 배열 생성.
			st=new StringTokenizer(br.readLine());	
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		helper(0);
		System.out.println(min);
	}
	static void helper(int count) {
		if(count==N) {
			if(list.size()==0) return;
			min=Math.min(min,taste());
			return;
		}
		
		//System.out.println(count);
		list.add(arr[count]);
		helper(count+1);
		list.remove(list.size()-1);
		helper(count+1);
		
	}
	
	static int taste( ){
		int sub=0;
		int sour=1;
		int bitter=0;
		for(int[] a:list) {
			sour*=a[0];
			bitter+=a[1];
		}
		
		sub=Math.abs(sour-bitter);

		return sub;
	} 

}