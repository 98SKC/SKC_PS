
import java.util.*;
import java.io.*;

public class Main {
	
	
	public static int[] cutPoint;
	public static int L,K,C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		L=Integer.parseInt(st.nextToken()); //통나무 길이
		K=Integer.parseInt(st.nextToken()); //자를 수 있는 위치의 개수
		C=Integer.parseInt(st.nextToken()); //자를 수 있는 횟수
		

		cutPoint=new int[K+1];
		cutPoint[K]=L;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			cutPoint[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cutPoint); 
		
		int answer=L;
		int left=1;
		int right=L;
		int sub;
		int f=-1;
		

		while(left <= right) {
			int mid = left + (right-left)/2;
			
			sub = getCutCount(mid); 
			
			if(sub > C) {           
				left = mid + 1;
			}else{                  
				answer = mid;
				right = mid - 1;
			}
		}
		
		f = getFirst(answer);      
		
		System.out.println(answer+" "+f);
	}
	

	public static int getCutCount(int cutLength){
		int lc = L;        // 현재 조각의 오른쪽 끝
		int cutsUsed = 0;  // 실제로 자른 횟수

	
		for(int i=K-1;i>=0;i--) {
			int now = cutPoint[i];
			int nx  = (i==0 ? 0 : cutPoint[i-1]); 

			// [now, lc] 조각 하나가 이미 cutLength를 넘으면 불가능
			if(lc - now > cutLength) return Integer.MAX_VALUE;
			
			// [nx, lc] 까지 한 조각으로 쓰면 cutLength를 넘는 경우,
			// 가장 오른쪽인 now에서 한 번 잘라야 함
			if(lc - nx > cutLength) {
				cutsUsed++;
				lc = now;
			}
		}

		// 마지막 조각 [0, lc] 도 cutLength 이내여야 함
		if(lc > cutLength) return Integer.MAX_VALUE;
		
		return cutsUsed;
	}
	
	// mid(=최대 조각 길이)가 정해졌을 때,
	// 조건을 만족하면서 잘랐을 때의 "첫 번째 자르는 위치"를 구한다.
	public static int getFirst(int mid) {
		int fc = Integer.MAX_VALUE; // first cut 후보 (최소값 찾기)
		int lc = L;
		int cnt = C;                // 남은 자를 수 있는 횟수
		
		// 뒤에서부터 그리디하게 자르면서,
		// 실제로 자른 위치들 중 가장 왼쪽(값이 작은) 것을 fc로 갱신
		for(int i=K-1;i>=0;i--){
			int now = cutPoint[i];
			int nx  = (i==0 ? 0 : cutPoint[i-1]);

			if(lc - now > mid){
				return now;
			}


			if(lc - nx > mid){
				if(cnt == 0) break; // 이론상 안 나와야 함 
				lc = now;
				if(lc != 0) {
					fc = Math.min(fc, lc);
				}
				cnt--;
			}
		}


		if(cnt > 0 && K > 0) {
			fc = Math.min(fc, cutPoint[0]);
		}
		

		if(fc == Integer.MAX_VALUE) {
			fc = (K > 0 ? cutPoint[0] : 0);
		}
		
		return fc;
	}
}
