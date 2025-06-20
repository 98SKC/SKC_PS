import java.io.*;
import java.util.*;

public class Main {

	public static int D,P;
	public static int maxValue;
	public static int[] number;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		D=Integer.parseInt(st.nextToken()); //자리 수
		P=Integer.parseInt(st.nextToken()); //연산 횟수
		number=new int[P];
		maxValue=(int) (Math.pow(10, D)-1);
		//System.out.println(D+"자리 수 최대: "+maxValue);
		//D자리까지 출력되는 계산기
		//가장 처음 표시되는 수는 1. 
		//정확하게 P번만큼 곱셈
		//한번의 곰셈에 화면에 나와있는 수에 2와9를 포함해서 그 사이의 자연수를 곱한다.
		//수를 곱한 결과는 D자리 이하여야 한다.
		//P번의 곱셈을 해서 구할 수 있는 가중 큰 수를 구하라
		
		//1*(?*?*?*?*?*?*?)의 최대. 자연수의 순서는 중요하지 않다.
		//그리디처럼 큰 수로 곱하다가, 값이 커지면 백트래킹?
		System.out.println(backtracking(1, 9 ,0));
	}
	
	public static int backtracking(int val, int max, int cnt) {
		if(val>maxValue) return -1;
		//System.out.println(cnt+"번: "+val+" "+Arrays.toString(number));
		if(cnt>=P) {
			//System.out.println(cnt+"시발 대체 왜"+P);
			return val;
		}
		// 7 7 2 
		int answer=-1;
		int sub;
		for(int i=max;i>=2;i--) {
			number[cnt]=i;
			sub=backtracking(val*i, i,cnt+1);
			answer=Math.max(sub, answer);
		}
		
		return answer;
	}
	

}