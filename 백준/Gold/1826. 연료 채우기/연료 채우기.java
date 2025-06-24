
import java.util.*;
import java.io.*;

public class Main {

	
	public static class Oil{
		int distance;
		int amount;
		
		public Oil(int distance, int amount) {
			this.distance=distance;
			this.amount=amount;
		}
		
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); //주요소 개수
        
        
        StringTokenizer st;
        
        
        int a,b;
        //거리순의 우선순위 큐
        PriorityQueue<Oil> dq=new PriorityQueue<>(new Comparator<Oil>() {
        	@Override
        	public int compare(Oil o1, Oil o2) {
        		return o1.distance-o2.distance;
        	}
        });
        
        //연료순의 우선순위 큐
        PriorityQueue<Oil> aq=new PriorityQueue<>(new Comparator<Oil>() {
        	@Override
        	public int compare(Oil o1, Oil o2) {
        		return o2.amount-o1.amount;
        	}
        });
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());//시작 위치에서 주요소 까지의 거리
            b=Integer.parseInt(st.nextToken());//주요소에 채울 수 있는 연료의 양
            
            dq.add(new Oil(a,b));
            
        }
        
        int L,P;
        st=new StringTokenizer(br.readLine());
        L=Integer.parseInt(st.nextToken());//마을까지의 거리
        P=Integer.parseInt(st.nextToken());//처음 연료 량. 
        
        int pos=P;//
        int ans=0;
        Oil oil;
        while(pos<L){
        	
            //1)지금 연료로 닿을 수 있는 모든 주유소를 aq에 옮긴다.
            while (!dq.isEmpty() && dq.peek().distance <= pos) {
                aq.add(dq.poll());
            }
        	
            //2)가져올 수 있는 주유소가 없다면 불가능
            if (aq.isEmpty()) {
            	//System.out.println(pos+" "+L); 
                System.out.println(-1);
                return;
            }
            
            //3)제일 연료 많은 주유소에서 채우고, 횟수 증가
            pos += aq.poll().amount;// aq에는 채우지 않은 주요소도 존재
            ans++;
        	
        	
        }
        
        
        System.out.println(ans);
        
   
        
        
        //연료탱크에서 1KM 당 1L의 연료가 샌다.
        //고치러 마을에 가는 중 연료가 다 빠질 수 있다.
        //가는 길 중간중간 주요소 N개가 있다.
        //최소로 멈춰서 주요소에 들릴려고 한다. 
        //연료통은 무한히 넣을 수 있고, 주요소 위치와 주요서에서 얻을 수 있는 연료량이 주어진다.
        //주요소에서 멈추는 횟수를 구하시오
        
        
        
    }
}
