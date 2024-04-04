import java.io.*;
import java.util.*;

public class Main  {

	
	static int N,K;
	static long answer=0;
	static int[] bag;	//가방 무게 저장 배열
	static jewel[] jewels;	//보석 저장 배열
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		//check=new boolean[K+1];
		
		bag = new int[K];
        jewels = new jewel[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new jewel(V, M);
        }
		
		for(int i=0;i<K;i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);	//가방 오름차순 정렬
        Arrays.sort(jewels);	//보석 정렬

		
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //가방 무게가 낮은 것부터 탐색.
        for(int i=0,j=0;i<K;i++){
            while(j<N){
                if(bag[i] < jewels[j].weight)	//다음 보석부터 가방의 무게보다 클 때
                    break;
                pq.add(jewels[j++].value);	//가방에 보석을 넣을 수 있을 때
            }
            //넣을 수 있는 보석이 있을 때 가장 가치가 높은 것 넣기
            if(!pq.isEmpty()) {
            	answer += pq.poll();

            }
                
        }
		
		System.out.println(answer);
	}
	
	static class jewel implements Comparable<jewel> {
        int value, weight;	//가치 및 무게
        //생성자
        public jewel(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
        //보석 클래스 정렬 관련
        @Override
        public int compareTo(jewel o) {
            if(this.weight == o.weight)		//무게가 같을 때 가치 내림차순
                return o.value - this.value;
            return this.weight - o.weight;	//무게 오름차순
        }
    }

}