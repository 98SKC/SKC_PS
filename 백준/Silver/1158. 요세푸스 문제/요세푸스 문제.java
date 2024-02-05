import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		ArrayDeque<Integer> q=new ArrayDeque<>();
		LinkedList<Integer> list=new LinkedList<>();
		
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
			list.add(i);
		}
		
		while(!(q.size()==1)) {
			for(int i=1;i<K;i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");


		
		System.out.println(sb);
		
	}

}