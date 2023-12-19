import java.io.*;
import java.util.*;


public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<int[]> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 ");
		int sub = arr[0];
		
		for(int i=1; i<n; i++){
			deque.add(new int[] {(i+1), arr[i]}); 
		}
		
		while(!deque.isEmpty()) {			
			if(sub >0) {//양수
			
				for(int i=1; i<sub; i++) {
					deque.add(deque.poll());
				}
				
				int[] nxt = deque.poll();
				sub = nxt[1];
				sb.append(nxt[0]+" ");
			}else {//음수
				for(int i=1; i<-sub; i++	) {
					deque.addFirst(deque.pollLast());
				}
				
				int[] nxt = deque.pollLast();
				sub = nxt[1];
				sb.append(nxt[0]+" ");
			}
		}
				
		System.out.println(sb.toString());
		
	}
}

