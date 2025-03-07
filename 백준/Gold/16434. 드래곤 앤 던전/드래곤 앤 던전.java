import java.io.*;
import java.util.*;

public class Main{

	
	
	
	public static void main(String[] args) throws Exception{
		
		int N;
		long atk;
		long originAtk;
		long maxHp, curHp;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		atk=Integer.parseInt(st.nextToken());
		int[][] map=new int[N+1][3];
		
		//dp? 그리디? 백트래킹?
		// 물약이 문제인데, 회복량이 maxHp를 넘으면, 어떻게 할 것인가
		// 한 50 초과해. 그럼 maxhp가 지금보다 몇이 더 높도록 해야할 것인가
		
		long damage=1, turn=0;
		//maxHp의 최대: 받은 데미지 전체+1
		originAtk=atk;
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			map[i][0]=Integer.parseInt(st.nextToken());
			map[i][1]=Integer.parseInt(st.nextToken());
			map[i][2]=Integer.parseInt(st.nextToken());
			if(map[i][0]==1){//몬스터라면
				turn = (long)Math.ceil((double)map[i][2] / atk);
				damage+=map[i][1]*(turn-1);
			//	System.out.println(i+" 위치 몬스터 잡는데 걸리는 시간 "+turn+" 받은 데미지: "+(map[i][1]*(turn-1)));
			}else{//포션이라면
				atk+=map[i][1];
			}
		}
		long left=1, right=damage;
		long mid;
		boolean possible;
		while(left<=right) {
			mid=left+(right-left)/2;
			possible=true;
			curHp=mid;//시작 HP는 최대 HP
			atk=originAtk;//공격력 초기화
			for(int i=1;i<=N;i++){
				if(map[i][0]==1){//몬스터라면
					turn = (long)Math.ceil((double)map[i][2] / atk);
					curHp-=map[i][1]*(turn-1);
					//System.out.println(i+" 위치 몬스터 잡는데 걸리는 시간 "+turn+" 남은 hp: "+curHp);
					if(curHp<=0){
						possible=false;
						break;
					}
				}else{//포션이라면
					atk+=map[i][1];
					curHp=Math.min(mid, curHp+map[i][2]);
				}
			}
			
			if(possible) {
				right=mid-1;
			}else {
				left=mid+1;
			}
			
		}

		System.out.println(left);
		
		
	}
	
	
}
