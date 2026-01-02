
import java.util.*;
import java.io.*;

public class Main{

	public static class Point{
		int start;
		int end;
		
		Point(int start, int end) {
			this.start=start;
			this.end=end;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        int start, end;
        int s,e;
        
        Point[] point=new Point[N];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	
        	//순서가 다르게 들어올 수 있다.
        	s=Math.min(start, end);
        	e=Math.max(start, end);
        	
        	point[i]=new Point(s,e);
        	
        }

        int d = Integer.parseInt(br.readLine());

        // end 기준 정렬
        Arrays.sort(point, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.end, p2.end);
            }
        });

        // start를 관리하는 최소 힙
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int answer=0;

        for (int i = 0; i < N; i++) {
            Point cur=point[i];

            // 철로 길이 d로 아예 포함 불가능한 선분은 스킵
            if (cur.end-cur.start > d) continue;

            pq.offer(cur.start);

            // 철로 범위 밖인 start 제거
            while (!pq.isEmpty() && pq.peek() < cur.end-d) {
                pq.poll();
            }

            answer=Math.max(answer,pq.size());
        }

        System.out.println(answer);
        
        
        // N명의 사람들이 있다.
        // 사람의 집과 사무실은 수평선 상에 다른점에 위치
        // 임의의 두 점을 잇는 철로를 건설한다. 철로의 길이는 d로 정해져있다.
        
        // 그러니까 쉽게 말해 L선분이 여러개 중첩가능하게 있는데, d선분이 최대한 많은 L선분을 포괄할 때 포괄된 L선분 개수를 구하라.
        // 일단 선분의 전부를 포괄해야해서 d의 시작점이 한 선분의 시작에 걸치거나
        // d의 끝점이 선분의 끝점하고는 겹칠것
        
        // 일단 완탐은 힘든게, 10만에 대해 모든 시작점에서 d가 시작디고, 끝점에서 d가 끝날 때 완탐을 하면
        // 10만에 10만을 두번 100억.
        // 우선순위 큐에 시작점을 기준으로 선분을 넣어놓고, 하나씩 최소힙에 넣는다
        // 최근 들어온 선분이 d의 끝이라고 생각할 때, 범위에 못미치는 큐의 선두를 잘라낸다. 
        // 이와같은 방법으로 슬위를 쓰면 힙의 크기가 포함되는 L의 개수
        
        
        
    }
        
}


