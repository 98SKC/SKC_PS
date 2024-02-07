import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {

		PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> {
			if (Math.abs(t1) == Math.abs(t2)) {
				return t1 - t2;
			}
			return Math.abs(t1) - Math.abs(t2);
		});

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int sub;
		for(int i=0;i<N;i++) {
			sub=Integer.parseInt(br.readLine());
			switch(sub) {
			case 0:
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");	
				}
				break;
				
			default:
				pq.offer(sub);
			}
			
		}
		
		System.out.println(sb);
	}

}