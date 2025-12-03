import java.io.*;
import java.util.*;

public class Main {
	
//	public static class Land{
//		int ob1;
//		int ob2;
//		int dist;
//		
//		public Land(int ob1, int ob2, int dist) {
//			this.ob1=ob1;
//			this.ob2=ob2;
//			this.dist=dist;
//		}
//	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //N개의 돌섬이 있다. 이 중 M개를 제거하여 학생들이
        //최대한의 멀리뛰기 엽습 효율을 이끌어낸다.
        //각 돌섬을 점프한 거리의 최솟값을 최대한 크게 돌을 제거하여 최소거리의 최댓값을 구하라
        
        
        int D=Integer.parseInt(st.nextToken()); // 탈출구까지의 거리 (MAX)
        int N=Integer.parseInt(st.nextToken()); // 돌섬의 개수
        int M=Integer.parseInt(st.nextToken()); // 제거할 섬의 수
        
        
        int[] islands = new int[N+1];
        
        
        for (int i = 1; i <= N; i++)  islands[i] = Integer.parseInt(br.readLine());  
        
        Arrays.sort(islands);  
  
        int start = 0;  
        int end = D;  
        int answer = 0;  
        
        while (start <= end) {  
            int mid = (start + end) / 2;  // 최소거리의 한계. 이보다 작은 거리는 없도록 섬을 제거.
            //즉 모든섬의 거리는 mid보다 크다.
            
            //pt는 앞의 섬. i는 뒤의 섬이자 현재.
            int pt = 0, count = 0;  
            
            for (int i = 1; i <= N; i++) {  
                if (mid <= islands[i] - islands[pt]) {// 지금 섬과 앞의 섬 거리가 mid보다 크면  
                    pt = i;  //지금을 앞의 섬으로
                } else {  
                    count++;  // 지금 섬을 제거하는 형식. 
                }  
            }  
  
            //너무 많은 섬을 지웠으면 더 짧은 거리까지 허용
            if (count > M) {  
                end = mid - 1;  
            } else {  // M과 같거나 더작으면 answer을 갱신. 원래 mid==M일때 answer을 갱신하지만
            	//비교하나, 일단 갱신하나 연산횟수는 같으니 더 짧도록
                answer = mid;  
                start = mid + 1;  
            }  
        }  
  
        System.out.println(answer);  
    
    }

}
