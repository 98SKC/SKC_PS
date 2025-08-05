import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//둘이서 게임을 한다.
		//서로 턴을 번갈아가며 돌을 가져간다. 
		//돌은 1개 또는 3개를 가져간다.
		//마지막 돌을 가져가는 사람이 진다.
		//두사람이 완벽하게 게임을 했을 때 이기는 사람을 구하라
		//시작은 상근이가 먼저 시작한다.
		//상근이가 이기면 SK, 창영이가 이기면 CY를 출력
		
		
		int N=Integer.parseInt(br.readLine());
		
		boolean[] turn=new boolean[N+1];//1개씩 가져가도 최대 N턴 진행
		
		if(N>=2) turn[2]=true;//2개 남았다면 1개만 가져가야 다음 사람이 다 가져가서 승리 가능
		
		if(N>=3) {
			for(int i=3;i<=N;i++) {
				//i개 남았을 때,
				//내가 지금 1개 가져가고, 
				//		상대가 1개 혹은 3개를 가져갔을 때 내가 승리할 수 있다면 승리
				//내가 지금 3개 가져가고, 
				//		상대가 1개 혹은 3개를 가져갔을 때 내가 승리할 수 있다면 승리
				//다음 차례가 1개가져가도, 3개 가져가도 패배라면 나는 승리
				if(!turn[i-1]&&!turn[i-3]) {
					turn[i]=true;
				}
				
			}
		}

		
		if(turn[N]) System.out.println("SK");
		else System.out.println("CY");
		
		
		
	}
	
	

}