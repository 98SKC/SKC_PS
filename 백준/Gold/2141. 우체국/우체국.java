import java.util.*;
import java.io.*;

public class Main{

	public static class Village{
		
		int X;
		int A;
		
		public Village(int X, int A) {
		
			this.X=X;
			this.A=A;
		
		}
		
	} 
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        int X;
        int A;
        
        long total=0;
        
        PriorityQueue<Village> pq=new PriorityQueue<>(new Comparator<Village>() {
        	@Override
        	public int compare(Village v1, Village v2) {
        		return v1.X-v2.X;
        	}
        });
        
        for(int i=1;i<=N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	 X=Integer.parseInt(st.nextToken());
        	 A=Integer.parseInt(st.nextToken());
        	 total+=A;
        	 
        	 pq.add(new Village(X, A));
        }
        
        Village village;
        
        long people=0;
        long half = (total + 1) / 2;
        int answer=0;
        while(!pq.isEmpty()) {
        	village=pq.poll();
        	
        	people+=village.A;
        	if(people>=half) {
        		answer=village.X;
        		break;
        	}
        	
        	
        }
        System.out.println(answer);
       
        
        //수직선상의 마을이 존재.
        //i번째 마을은 X[i]에 위치, A[i]명의 사람이 거주
        
        //각 '사람' 까지의 거리가 최소가 되도록 우체국을 건설
        // A에 우체국을 지으면, B의 사람까지 거리는 (A와 B사이의 거리)*(B의 사람 수)  
        
        //|X[i]| ≤ 1,000,000,000
        //1 ≤ A[i] ≤ 1,000,000,000
        
        
    }
}