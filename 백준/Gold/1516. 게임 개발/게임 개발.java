import java.io.*;
import java.util.*;
 

 
public class Main {
	
	static class Building implements Comparable<Building> {
	    int number;
	    int time;
	 
	    Building(int num, int time) {
	        this.number = num;
	        this.time = time;
	    }
	 
	    @Override
	    public int compareTo(Building o) {
	        return time - o.time;
	    }
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sub;
        StringTokenizer st;
        PriorityQueue<Building> pq = new PriorityQueue<>(); // 건물을 짓는 데 걸리는 시간을 기준으로 오름차순 정렬.
        List<Integer>[] list;
        
        list=new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i]=new ArrayList<>();
        }
 
        int[] indegree = new int[N + 1]; // 특정 건물을 짓기 전에 먼저 지어야 할 건물의 개수- 
        Building[] buildings = new Building[N + 1];
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildings[i] = new Building(i, time);//i건물과 짓는 시간
 
            while (true) {
                sub = Integer.parseInt(st.nextToken());
                if (sub == -1) {
                    break;
                }
                list[sub].add(i);// i가 있으려면 sub가 지어져 있어야 한다. sub에서 i로 간선을 뻗는다. 
 
                indegree[i]++;//i의 inner 차수 증가
            }
        }
 
        // 먼저 지어야할 건물이 없는 건물을 큐에 집어 넣음.
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(buildings[i]);
            }
        }
 
        while (!pq.isEmpty()) {
            int now = pq.poll().number;
 
            for (int next : list[now]) {// 간선 제거 
                indegree[next]--;// 간선을 제거함
                if (indegree[next] == 0) {// 지을 차례가 된 건물이 있으면 pq에 넣는다.다음으로 뻗는 노드들의 건설 시간에 지금 건물을 짓는 시간을 추가함
                    buildings[next].time += buildings[now].time;// 지을 차례인 노드만 신경쓰면된다. 결국 최종점 기준으로 가장 가중치 큰 방향 하나만 생각.
                    pq.offer(new Building(next, buildings[next].time));
                }
            }
        }
 
        // 특정 건물을 짓는 데 걸린 시간을 출력.
        for (int i = 1; i <= N; i++) {
            sb.append(buildings[i].time + "\n");
        }
        System.out.println(sb);
    }
 
 
}