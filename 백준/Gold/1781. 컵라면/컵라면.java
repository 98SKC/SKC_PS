import java.util.*;
import java.io.*;

public class Main {

    static class Ramen implements Comparable<Ramen> {
        int deadLine;
        int num;

        Ramen(int deadLine, int num){
            this.deadLine = deadLine;
            this.num = num;
        }

        @Override
        public int compareTo(Ramen o) {
            if (this.deadLine != o.deadLine) {
                return Integer.compare(this.deadLine, o.deadLine);
            } else {
                return Integer.compare(o.num, this.num);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        long answer=0;
        Ramen[] ramen=new Ramen[N];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());      	
        	ramen[i]=new Ramen(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        	
        	
        }
        
        Arrays.sort(ramen);
        
        // 1. 1-1 2-1 3-1 4-1 5-100, 5-101, 5-102 5-103. 데드라인 우선이면 이 경우 최대를 못가져감 
        // 2. 1-1 2-70 3-1 4-1 6-100, 6-101, 6-102 6-103 점수만 우선이면 중간에 2-70을 먹고 나머지 6을 다 먹을 수 있는데도 6을 먼저 다 먹ㅇ서 최대가 안됨
        for(int i=0;i<N;i++) {
        	Ramen rm=ramen[i];
        	if(pq.size()<rm.deadLine) {//pq의 사이즈가 지금까지 푼 문제 수
        		pq.offer(rm.num);
        	}else if(pq.size()==rm.deadLine&&pq.peek()<rm.num) {// 데드라인은 같지만, 지금 제일 적게주는 것 보다 더 많이주면, 제일 적게주는거랑 바꿈
        		pq.poll();
        		pq.offer(rm.num);
        	}

        }
        while(!pq.isEmpty()) {
        	answer+=pq.poll();
        }
        System.out.println(answer);
    }
}