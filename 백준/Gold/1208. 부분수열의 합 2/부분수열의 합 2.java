import java.io.*;
import java.util.*;

public class Main {
	
	public static int N,S;
	public static int[] arr;
	public static ArrayList<Integer> left=new ArrayList<>();
	public static ArrayList<Integer> right=new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		getLeft(0,0);
		getRight(N/2,0);
		
		Collections.sort(left);
		Collections.sort(right);
		
		long answer=getAnswer();
		if(S==0) answer--;
		
		System.out.println(answer);
	}
	
	public static void getLeft(int pos, int sum){
		if(pos==(N/2)) {
			left.add(sum);
			return;
		}
		getLeft(pos+1,sum+arr[pos]);
		getLeft(pos+1,sum);
	}
	
	public static void getRight(int pos,int sum) {
		if(pos==N) {
			right.add(sum);
			return;
		}
		getRight(pos+1,sum+arr[pos]);
		getRight(pos+1,sum);
	}
	
	public static long getAnswer() { 
		long answer=0; 
		int pl=0;
		int pr=right.size()-1;
		while(pl<left.size() && pr>=0){
			int sum=left.get(pl)+right.get(pr);
			
			if(sum==S){
				long al=0; 
				int bl=left.get(pl);
				while(pl<left.size() && left.get(pl)==bl) {
					al++;
					pl++;
				}
				
				long ar=0; 
				int br=right.get(pr);
				while(pr>=0 && right.get(pr)==br) {
					ar++;
					pr--;
				}
				
				answer+=al*ar;
			} else if(sum<S){
				pl++;
			} else {
				pr--;
			}
		}
		
		return answer;
	}
}
