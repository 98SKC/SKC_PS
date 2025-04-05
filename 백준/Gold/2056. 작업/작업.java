
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); //작업의 개수
        
        StringTokenizer st;
        int[] time=new int[N+1];
       // int[] inDegree=new int[N+1];

        HashSet<Integer>[] set=new HashSet[N+1];
        
        int t,n;
        for(int i=1;i<=N;i++){
        	set[i]=new HashSet<>();
        }
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	t=Integer.parseInt(st.nextToken());
        	n=Integer.parseInt(st.nextToken());
        	time[i]=t;
        	//inDegree[i]=n;
        	
        	for(int j=0;j<n;j++) {
        		set[i].add(Integer.parseInt(st.nextToken()));
        		//list[Integer.parseInt(st.nextToken())].add(j); 
        	}
        	
        }
        
        //시간이 짤은 것 먼저가 맞나?
        //의미가 없는 것 같기도. 어차피 선행 관례가 없으면 동시에 시작하네
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];
        	}
        });
//        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        for(int i=1;i<=N;i++) {
        	if(set[i].isEmpty()) pq.add(new int[] {i, time[i]});
        }
        //문제가 선행 관례가 없는 작업이 '동시'에 가능한 것
        //선행관례의 작업들끼리만 모았을 때 가장 긴 작업시간?
        
        int[] sub;
        int answer=0;
        while(!pq.isEmpty()){//선행 관례가 남지 않은 작업들이 추가
        	sub=pq.poll();
        	answer=Math.max(answer, sub[1]);
        	//System.out.println("누적 값 확인: "+sub[1]);
        	for(int i=1;i<=N;i++) {
        		if(set[i].contains(sub[0])) {
        			set[i].remove(sub[0]);
        			if(set[i].isEmpty()) {
        				pq.add(new int[] {i,sub[1]+time[i]});
        			}
        		}
        	}
        	
        }
        System.out.println(answer);
        
    }
}
