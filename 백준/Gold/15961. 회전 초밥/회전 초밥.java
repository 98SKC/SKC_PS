import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};

	
	//가장 먼저 떠오르는건 BFS. -> 문제점: 모든 외각을 판단하고, 외각에서 다 bfs를 해야함.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int cnt=0;
		
		Queue<Integer> q=new ArrayDeque<>();
		HashSet<Integer> set=new HashSet<>();
		
		int[] dish=new int[N];
		int[] sushi=new int[d+1];
		
		for(int i=0;i<N;i++) {//초밥의 입력
			dish[i]=Integer.parseInt(br.readLine());
		}
		
		set.add(c);
		sushi[c]=1;
		for(int i=0;i<K;i++) {
			q.add(dish[i]);
			sushi[dish[i]]++;
			set.add(dish[i]);
		}
		
		int max=set.size();
		int point=K;
		int sub=0;
		
		//초기출력
//		for(int a:set) {
//			System.out.print(a+" ");
//		}
//		System.out.println();
//		System.out.println("-----------");
		//초기출력
		
		
		while(cnt<N) {
		
			q.add(dish[point]);
			sushi[dish[point]]++;
			set.add(dish[point]);
//			System.out.println("배열 인덱스: "+point);
//			System.out.println("들어온 것: "+dish[point]);
			sub=q.poll();
//			System.out.println("빠진것: "+sub);
			if(sub!=c&&--sushi[sub]==0) {
				set.remove(sub);
			}
//			System.out.println("지금 상태");
//			for(int a:set) {
//				System.out.print(a+" ");
//			}
//			System.out.println();
//			System.out.println("cnt: " +cnt);
//			System.out.println("-------------------------");
			max=Math.max(max, set.size());
			if(max==K+1) {
//				System.out.println("답빨리찾음");
				System.out.println(max);
				return;
			}
			point=(point+1)%N;
			cnt++;
		}
//		System.out.println();
		System.out.println(max);
		
		//max=k+1// k접시 다 다른 종류에 쿠폰까지 사용한 경우가 최대.
		//접시수는 N, 초밥 종류는 D
		
	}

  
}