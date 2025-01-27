import java.io.*;
import java.util.*;

public class Main {

	
	
	// 식재료 N개에의 영양분이 제공
	// 각 영양분의 최소치가 정해짐
	// 조건이 만족되는 비용이 최소가 되야함
	static int N,price;
	static int[] goal;
	static int[][] food;
	static boolean[] choice;
	static ArrayDeque<Integer> q=new ArrayDeque<>();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		goal=new int[4]; 
		food=new int[N][5];
		choice=new boolean[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		//각 영양소의 최소치
		
		goal[0]=Integer.parseInt(st.nextToken());
		goal[1]=Integer.parseInt(st.nextToken());
		goal[2]=Integer.parseInt(st.nextToken());
		goal[3]=Integer.parseInt(st.nextToken());
		// 각 음식별로 영양소 저장
		price=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			food[i][0]=Integer.parseInt(st.nextToken());
			food[i][1]=Integer.parseInt(st.nextToken());
			food[i][2]=Integer.parseInt(st.nextToken());
			food[i][3]=Integer.parseInt(st.nextToken());
			food[i][4]=Integer.parseInt(st.nextToken());// 가격
			price+=food[i][4];
		}
		price+=1;
		int over=price;
		backT(0, 0, 0, 0, 0, 0);
		
		if(price==over) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb=new StringBuilder();
		sb.append(price+"\n");
		while(!q.isEmpty()) {
			sb.append(q.poll()+" ");
		}
		
		System.out.println(sb);
		
	}
	public static void backT(int pos,int mp,int mf,int ms,int mv,int value) {
		if(price<=value) return;
		if(check(mp,mf,ms,mv)){
			q=new ArrayDeque<>();
			price=value;
			//System.out.println("price 후보: "+price);
			for(int i=0;i<N;i++) {
				if(choice[i]) q.add(i+1);
			}
			return;
		}
		if(pos>=N) return;
		
		
		choice[pos]=true;
		backT(pos+1,mp+food[pos][0],mf+food[pos][1],ms+food[pos][2],mv+food[pos][3],value+food[pos][4]);
		choice[pos]=false;
		backT(pos+1,mp,mf,ms,mv,value);
		
	}
	public static boolean check(int mp,int mf,int ms,int mv) {
		if(goal[0]<=mp&&goal[1]<=mf&&goal[2]<=ms&&goal[3]<=mv)return true;
		return false;
	}
		
	
}