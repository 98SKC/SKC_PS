import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class Main {

	public static void main(String[] args) throws IOException{
	
		LinkedList<Integer> dequeue=new LinkedList<Integer>();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int oper=0;
		int sub=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
		
			oper=Integer.parseInt(st.nextToken());
			switch (oper) {
			case 1:// 정수를 덱 앞에
				sub=Integer.parseInt(st.nextToken());
				dequeue.addLast(sub);
				break;
			case 2://정수를 덱 뒤에
				sub=Integer.parseInt(st.nextToken());
				dequeue.addFirst(sub);
				break;
			case 3://정수가 있으면 맨 앞의 정수를 빼고 출력,없으면 -1
				if(dequeue.size()!=0) {
					sb.append(dequeue.pollLast()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case 4://정수가 있으면 맨 뒤의 정수를 빼고 출력, 없으면 -1
				if(dequeue.size()!=0) {
					sb.append(dequeue.pollFirst()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case 5://정수의 개수
				sb.append(dequeue.size()).append("\n");
				break;
			case 6://비었으면1, 아니면 0
				if(dequeue.size()!=0) {
					sb.append(0).append("\n");
				}else {
					sb.append(1).append("\n");
				}
				break;
			case 7:// 정수가 있다면 맨 앞의 정수를 출력, 없으면 -1
				if(dequeue.size()!=0) {
					sb.append(dequeue.peekLast()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case 8://정수가 있다면 맨 뒤의 정수를 출력. 없으면-1
				if(dequeue.size()!=0) {
					sb.append(dequeue.peekFirst()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			}
			
			
		}
		System.out.println(sb);
		
	}
	
}