import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N,B;
	static int[] h;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= test; t++) {
			st=new StringTokenizer(br.readLine());
			answer=0;
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			h=new int[N];
			
			st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				h[i]=Integer.parseInt(st.nextToken());
				answer+=h[i];
			}
			comb(0,0);
			sb.append("#"+t+" "+(answer-B)+"\n");
		}
		System.out.println(sb);
	}
	
	public static void comb(int sum,int pos) {
		if(answer==B) return;
		if(pos==N) {
			if(sum>=B) answer=Math.min(sum, answer);
			return;
		}
		if(sum>=answer) return;
		
		comb(sum,pos+1);
		comb(sum+h[pos],pos+1);
		
	}
}