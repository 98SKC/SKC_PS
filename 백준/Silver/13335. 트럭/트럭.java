
import java.util.*;
import java.io.*;

public class Main {

	//시뮬레이션 재활
	//클래스 세분화 실천
	public static ArrayDeque<Integer> q=new ArrayDeque<>();
	public static int turn=0;
	public static int bridge;// 다리의 단위 길이 w
	public static int weight;// 다리의 최대 하중 L
	public static int sumWeight;// 다리에 올라와 있는 트럭 무게의 합 
	//public static int sumCount;// 다리에 올라와 있는 트럭 개수의 합
    public static int N;//다리를 건너는 트럭의 수
	public static int[] truck;
    public static int pos=1;
    public static int cnt=0;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        bridge=Integer.parseInt(st.nextToken());
        weight=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        truck=new int[N+1];
        for(int i=1;i<=N;i++) {
        	truck[i]=Integer.parseInt(st.nextToken());
        }
        //w개의 빈칸을 큐에 넣어둔다.
        for(int i=0;i<bridge;i++) {
        	q.add(0);
        }
        //강을 가로지르는 다리가 하나.
        //n개의 트럭이 순서대로 지나간다.
        //트럭의 순서는 바꿀 수 없다.
        //트럭의 무게는 서로 같지 않을 수 있다.
        //다리 위에는 w대의 트럭만 동시에 올라갈 수 있다.
        //다리의 길이는 w단위길이, 트럭들은 하나의 단위 길이만큼 이동 가능하다.
        //다리위에 올라가있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
        //다리위에 완전히 올라가지 못한 트럭의 무게는 합에 포함되지 않는데.
        
        //모든 트럭이 다리를 건너는데 최단기간을 구하라.
        int out;
        while(cnt<N){//건넌 트럭이 N을 넘기까지
        	out=q.poll();
        	
        	if(out>0) {
        		sumWeight-=out;
        		cnt++;
        	}
        	if(check()){
        		sumWeight+=truck[pos];
        		q.add(truck[pos++]);
        	}else {
        		q.add(0);
        	}
//        	System.out.println("------turn: "+turn+"--------");
//        	System.out.println("큐에 들어와 있는 수: "+q.size());
//        	System.out.println("대기중인 트럭번호: "+pos);
//        	System.out.println("다리의 트럭 무게 합: "+sumWeight);
//        	System.out.println("통과한 트럭 수: "+cnt);
        	turn++;
        }
        System.out.println(turn);
    }
	
	//트럭이 올라가도 되는지 판단.
	public static boolean check() {
		boolean b=true;

		if(pos>N||sumWeight+truck[pos]>weight) {
			b=false;
		}
		
		return b;
	}
	

	
	
}
