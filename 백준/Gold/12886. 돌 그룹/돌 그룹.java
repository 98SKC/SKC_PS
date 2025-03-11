import java.io.*;
import java.util.*;

public class Main{

	
	public static void main(String[] args) throws Exception{
		
		//돌의 그룹이 3개.
		//각각의 그룹의 돌의 개수는 A,B,C개
		//A==B==C가 되도록 해야하는 문제인가
		
		//크기가 같지 않은 두 그룹을 고르고, 개수가 작은쪽 X, 큰쪽 Y
		//X=X*2, Y=Y-X 로 한다.
		
		//안되는 가장 큰 경우. 세 그룹의 합이 3의 배수가 아니면
		//그럼 반대로 3의 배수가 되더라도 안되는 경우가 있나?
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[3];
		
		int sum=0;
		for(int i=0;i<3;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		if(sum%3!=0) {
			System.out.println(0);
			return;
		}
		
		//사이클이 만들어지면 안될거다 라는게 감은 오는데, 사이클을 어떻게 판별할까
		//비트마스킹? 500으로?
		//500 500 500으로 set에 넣어볼까
		
		boolean[][] v=new boolean[1501][1501];
		
		ArrayDeque<int[]> q=new ArrayDeque<>();
		int answer=0;
		q.add(arr);
		int[] sub;
		while(!q.isEmpty()){
			sub=q.poll();
			Arrays.sort(sub);
			if(sub[0]==sub[2]) {
				answer=1;
				break;
			}
			
			if(v[sub[0]][sub[1]]) {
				continue;
			}
			
			v[sub[0]][sub[1]]=true;
			
			//큰수-작은수, 작은수는 두배
			if(sub[0]*2<=1500&&!v[sub[0]*2][sub[1]-sub[0]]) q.add(new int[] {sub[0]+sub[0],sub[1]-sub[0],sub[2]});
			if(sub[0]*2<=1500&&!v[sub[0]*2][sub[1]]) q.add(new int[] {sub[0]+sub[0],sub[1],sub[2]-sub[0]});
			if(sub[1]*2<=1500&&!v[sub[0]][sub[1]*2]) q.add(new int[] {sub[0],sub[1]+sub[1],sub[2]-sub[1]});
			
			
			
		}
		
		System.out.println(answer);
		
		
	}
	
	

}