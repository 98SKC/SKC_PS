import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N,B;
	static int[] h;
	static int answer;
	//조합 문제. 구성 요소가 아닌 합만 있으면 되기에 sum을 매개변수로 전달.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= test; t++) {
			st=new StringTokenizer(br.readLine());
			answer=0;
			N=Integer.parseInt(st.nextToken());//N명의 점원
			B=Integer.parseInt(st.nextToken());//B높이의 선반
			h=new int[N];//점원들의 키를 저장할 배열
			
			st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				h[i]=Integer.parseInt(st.nextToken());
				answer+=h[i];// answer의 최대값은 모든 사람 키의 합
			}
			powerSet(0,0);
			sb.append("#"+t+" "+(answer-B)+"\n");
		}
		System.out.println(sb);
	}
	
	
	//사람으로 탑을 쌓을 때, 사람의 순서가 상관이 없다. a-b-c 탑거ㅣ b-c-a 탑이 같다.
	//한 사람이 탑을 두 번 쌓을 수 없다. 
	//선택할 사람의 수는 1~N명까지 자유롭다.
	//-> 순열X, 조합X, 부분집합O
	public static void powerSet(int sum,int pos) {
		if(answer==B) return;// 원하는 높이와 딱 맞는 합을 찾으면 종료.
		
		if(pos==N) {// 조합을 선택했을 때 sum이 선반 높이보다 높아야 후보군에 들 수 있다.
			if(sum>=B) answer=Math.min(sum, answer);// 선반보다 높은 sum 중 가장 작은 값을 선별
			return;
		}
		// 다 더하지 않았는데, 현 answer보다 sum이 크면 탐색하지 않는다.
		if(sum>=answer) return;
				
				
		powerSet(sum,pos+1);// pos사람을 포함 안했을 경우의 수
		powerSet(sum+h[pos],pos+1);// pos사람을 포함한 경우의 수
		
	}
}