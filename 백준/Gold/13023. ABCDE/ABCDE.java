import java.io.*;
import java.util.*;

public class Main {
	
	
	//A는 B의 친구
	//B는 C와 친구
	//C는 D와 친구
	//D는 E와 친구
	//5명이 꼬리를 물어서 친구인 경우가 있는지 확인
	
	//문제점1: 친구 관계는 N:N의 관계
	//문제점2: 사이클이 형성 될 수 있음.
	
	static int N,M;// N과 M
	static ArrayList<Integer>[] arr;
	static boolean[] v;
	static boolean answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());// 사람의 수
		M= Integer.parseInt(st.nextToken());// 관계의 수
		
		int a;
		int b;
		arr= new ArrayList[N];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			arr[b].add(a);
			arr[a].add(b);
		}
		
		for(int i=0;i<N;i++) {
			v[i]=true;
			Find(i,1);
			v[i]=false;
			//if(answer) break;
			if(answer) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
		
		//System.out.println(answer?1:0);
		
	}

	static void Find(int number, int rank) {
		if(rank==5) {
			answer=true;
			return;
		}
		for(int a:arr[number]) {
			if(!v[a]) {
				v[a]=true;
				Find(a,rank+1);
				if(answer) return;// 정답을 찾았으면 재귀를 끝냄.
				v[a]=false;
			}	
		}		
	}
	
}