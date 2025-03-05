import java.io.*;
import java.util.*;

public class Main {
	public static int[] di=new int[] {0,1,0,-1};//처음은 오른쪽. 인덱스가 증가하면 오른쪽 90도
	public static int[] dj=new int[] {1,0,-1,0};
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//보드 크기
		int K=Integer.parseInt(br.readLine());//사과 개수
		StringTokenizer st;//사과의 위치
		int[][] map=new int[N+1][N+1];
		
		int a,b;
		for(int i=0;i<K;i++) {
			 st=new StringTokenizer(br.readLine());
			 a=Integer.parseInt(st.nextToken());
			 b=Integer.parseInt(st.nextToken());
			 
			map[a][b]=2;//임시로 2을 사과
		}
		
		int L=Integer.parseInt(br.readLine());// 뱀의 방향 전환 횟수
		
		ArrayDeque<Character> q=new ArrayDeque<>();
		int[] turn=new int[L+1];
		char c;
		int end=0;
		for(int i=0;i<L;i++) {
			 st=new StringTokenizer(br.readLine());
			 a=Integer.parseInt(st.nextToken());
			 c=st.nextToken().charAt(0);
			 turn[i]=a;
			 q.add(c);
		}
		int point=0;
		int dir=0;//처음은 오른쪽
		int ni,nj;
		int hi=1,hj=1;
		int ti=1,tj=1;
		map[1][1]=1;
		HashMap<Integer,Integer> next=new HashMap<>();
		end=0;
		while(true) {
			end++;
			ni=hi+di[dir];
			nj=hj+dj[dir];
			if(ni<=0||ni>N||nj<=0||nj>N||map[ni][nj]==1){// 벽이거나 자기 몸이면 끝
				break;
			}
			
			//사과를 먹으면 
			if(map[ni][nj]==2){
				next.put(hi*(N+1)+hj, ni*(N+1)+nj);

				map[ni][nj]=1;
				hi=ni;
				hj=nj;
				
			}else {//먹지 않으면 꼬리가 짧아짐
				next.put(hi*(N+1)+hj, ni*(N+1)+nj);
				map[ni][nj]=1;
				hi=ni;
				hj=nj;
				map[ti][tj]=0;// 기존 꼬리를 삭제하고
				a=next.get(ti*(N+1)+tj);// 꼬리 위치를 다음 몸통으로 옮겨
				next.remove(ti*(N+1)+tj);
				ti=a/(N+1);
				tj=a%(N+1);

			}
			
			
			if(end==turn[point]){
				//방향전환 추가
				c=q.poll();
				if(c=='L'){ //왼쪽으로 90도
					if(dir==0){
						dir=3;
					}else{
						dir--;
					}// 문제가 0 다음에 3어떻게 가더라
				}else {//오른쪽으로 90도
					dir=(dir+1)%4;
				}
				
				point++;
			}
//			System.out.println(next.toString());
//			System.out.println(end+"턴 끝날 떄");
//			for(int[] z:map) {
//				System.out.println(Arrays.toString(z));
//			}
//			System.out.println();
		}
		
		System.out.println(end);
	}
}