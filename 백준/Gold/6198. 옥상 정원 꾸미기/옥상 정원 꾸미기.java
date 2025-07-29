
import java.util.*;
import java.io.*;

public class Main{

	public static class Building{
		
		int idx;
		int h;
		
		public Building(int idx, int h) {
			this.idx=idx;
			this.h=h;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        

        
        PriorityQueue<Building> pqByHeight=new PriorityQueue<>(new Comparator<Building>() {
        	@Override
        	public int compare(Building b1, Building b2) {
        		
        		if(b1.h==b2.h){
        			return b2.idx-b1.idx;
        		}
        		
        		return b2.h-b1.h;
        	}
        	
        });

        
        
        for(int i=0;i<N;i++) {
        	pqByHeight.add(new Building(i,Integer.parseInt(br.readLine())));
        }
        
        
        int[] index= new int[N];
        Arrays.fill(index, 80002);
        //N개의 빌딩
        //hi로 빌딩의 키가 주어짐. 오른쪽만 볼 수 있다.
        //hi 빌딩보다 높거나 같은 빌딩이 있으면 그 다음의 모든 빌딩의 옥상은 보지 못한다.
        
        //i 기준 오른쪽으로 i보다 처음으로 큰 빌딩이 나오기까지 빌딩 수들의 합을 구하는 문제
        //매번 완탐하기에는 오래걸리니 그 외에 다른 방법을 찾아야함
        Building building;
        long answer=0;
        int end=0;
        int left,right, mid;
        int target;
        TreeSet<Integer> set = new TreeSet<>();  // 처리된 건물 idx 저장

        while (!pqByHeight.isEmpty()) {
            Building b = pqByHeight.poll();
            target = b.idx;

            Integer next = set.higher(target);
            if (next == null) {
                // 더 오른쪽에 높은 건물이 하나도 없음
            	answer += (long)(N - target - 1);
            } else {
                // 바로 다음 높은 건물까지 사이에 있는 수
            	 answer += (long)(next - target - 1);
            }

            set.add(target);
        }
        
        System.out.println(answer);
        
    }
}
