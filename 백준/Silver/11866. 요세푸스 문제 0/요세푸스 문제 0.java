import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class Main {

	public static void main(String[] args) throws IOException{
	
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] answer=new int[N];
		int count=0;

		Queue<Integer> queue=new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			queue.add(i);
			
		}
		while(!queue.isEmpty()) {
			for(int i=1;i<K;i++) {
				queue.add(queue.poll());
			}

			answer[count]=queue.poll();
			count++;
		}
		sb.append("<").append(answer[0]);
		for(int i=1;i<N;i++) {
			sb.append(",").append(" ").append(answer[i]);
		}
		sb.append(">");
		System.out.println(sb);
	}
	
}