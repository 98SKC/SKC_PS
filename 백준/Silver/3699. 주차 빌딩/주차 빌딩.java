
import java.util.*;
import java.io.*;

public class Main {

	public static class Car{
		int number;
		int height;
		int width;
		public Car(int number, int height, int weight) {
			this.number =number;
			this.height =height ;
			this.width =weight ;
		}
		
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //빌딩 가운데에 엘리베이터가 있다.
        //차는 엘리베이터를 이용해서 층 사이를 이동한다.
        //각 층에는 거대한 '원형' 컨테이어 벨트가 있으며, 이 위에 차가 있다.
        //벨트는 시계, 반시계로 움직을 수 있다.
        
        //주차 빌딩의 손님을 순서대로 받는다.
        
        //엘리베이터는 차가 있는 곳으로 이동하고, 
        //컨테이어 벨트는 차를 엘리베이터에 싣고,
        //다시 내려가 고객에게 차를 전달한다.
        
        //엘리베이터가 층을 이동하는데 걸리는 시간은 10초, (1층 단위인가)
        //컨테이어 벨트가 차 한대만큼 시계, 혹은 반시계로 이동하는데 걸리는 시간은 5초이다.
        //근데 최단거리를 구하라고 하던지, 짧은 루트를 찾아 선택된다는 조건을 넣어두던지
        //진짜 암묵적 합의 이러지좀 말고 제발 명시좀 하면 안되나? 일단은 '문제'인데 
        
        
        //모든 손님이 차를 찾는데 걸리는 시간을 구하라.
        
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int H,I;
        int[][] building;
        
        PriorityQueue<Car> pq;
        int answer;
        int sub;
        for(int test_case=1;test_case<=T;test_case++) {
        	st=new StringTokenizer(br.readLine());
        	H=Integer.parseInt(st.nextToken());// 빌딩 높이
        	I=Integer.parseInt(st.nextToken());// 벨트 길이
        	//building=new int[H+1][I+1];
        	
        	pq=new PriorityQueue<>(new Comparator<Car>() {
        		@Override
        		public int compare(Car c1,Car c2) {
        			return Integer.compare(c1.number, c2.number);
        		}
        	});
        	//모든 손님은 1층에서 차를 찾아간다. 엘리베이터는 첫번째 위치에 있다.
        	for(int h=1;h<=H;h++) {
        		st=new StringTokenizer(br.readLine());
        		for(int i=1;i<=I;i++) {
//        			building[h][i]=Integer.parseInt(st.nextToken());
//        			if(building[h][i]!=-1)pq.add(new Car(building[h][i],h,i));
        			sub=Integer.parseInt(st.nextToken());
        			if(sub!=-1)pq.add(new Car(sub,h,i));
        		}
        	}
        	//그러니까 1번부터 max까지 차례대로 차를 꺼내서 가져가는 시간을 모두 합하라?
        	int[] goal=new int[2];
        	int[] mid=new int[H+1];// 각 층에서 엘리베이터에 위치하고 있는 벨트 인덱스
        	for(int i=1;i<=H;i++) {
        		mid[i]=1;
        	}
        	Car car;
        	answer=0;
        	//System.out.println("꺼내야 하는 차: "+pq.size());
        	while(!pq.isEmpty()) {
        		car=pq.poll();
        		goal[0]=car.height;
        		goal[1]=car.width;
        		
        		//answer는 높이*2, 시계 반시계 중 더 짧은 곳
        		//System.out.println(car.number+"차 이동");
        		//System.out.println("엘리베이터 이동 시간: "+(goal[0]-1)*2*10);
        		answer+=(goal[0]-1)*2*10;//층별 이동 10초. 왕복 필요
        		
        		//벨트는 어디가 엘리베이터에 있는지 매번 다름
        		//System.out.println("컨테이어벨트 시간: "+Math.min(Math.abs(goal[1]-mid[goal[0]]),I-mid[goal[0]]+goal[1])*5);
        		
        		//System.out.println();
        		
        		answer += Math.min(
        		        (goal[1] - mid[goal[0]] + I) % I,
        		        (mid[goal[0]] - goal[1] + I) % I
        		) * 5;
        		mid[goal[0]]=goal[1];
        		/*
        		 * 3이 1로 가는 방향
        		 * 시계로 돌았을 때->   1 2 3 4 5   goal[1]-mid[goal[0]]
        		 * 반시계로 돌았을 때->  1 2 3 4 5  I-goal[1]+mid[goal[0]];
        		 * */
        		
        		
        	}
        	sb.append(answer+"\n");
        	
        }
        
        System.out.println(sb);
        
    }
        
}


