
import java.util.*;
import java.io.*;

public class Main {

	public static class Schedule{
		int d;
		int t;
		public Schedule(int d, int t) {
			this.d=d;
			this.t=t;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int d,t;
        
        
        //문제는 구간이 너무 긴데, 한번에 이미 일하고 있는 기간을 어떻게  할 수 있네
        PriorityQueue<Schedule> pq=new PriorityQueue<>(new Comparator<Schedule>() {
        	@Override
        	public int compare(Schedule s1, Schedule s2) {
        		if(s1.t==s2.t){
        			return Integer.compare(s2.d, s1.d); //오래 걸리는게 우선
        		}
        		return Integer.compare(s2.t, s1.t);// 늦게 끝나도 되는게 우선
        	}
        });
        
        int max=0;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	d=Integer.parseInt(st.nextToken());//d일이 걸리는 일인데
        	t=Integer.parseInt(st.nextToken());//t일 전에 끝나야 한다.
        	
        	max=Math.max(max,t);//가장 뒤에 있는 스케쥴
        	
        	//그리디 같긴 한데, 모든 경우가 일을 최대한 늦게 해야함. 1일 부터 길게 쉬는거니까
        	pq.add(new Schedule(d, t));
        	
        	
        	
        	
        }
        
        Schedule schedule;
        
        while(!pq.isEmpty()) {
        	schedule=pq.poll();
        	d=schedule.d;
        	t=schedule.t;
        	if(max>t) {//max(지금 가장 뒤에있는 근무일정)보다 마감일이 가까우면
        		max=t-d;
        	}else {
        		max-=d;
        	}
        	
        }
        
        System.out.println(max);
        
        
    }
        
}


