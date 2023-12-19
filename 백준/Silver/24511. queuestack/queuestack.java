import java.io.*;
import java.util.*;

public class Main{
	public static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		
		int N=Integer.parseInt(br.readLine());
		int sub;
		int e;

		
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringTokenizer st2=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {	// 스택 버리고 큐만 신경
			sub=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st2.nextToken());
			if(sub==0) {
				deque.addLast(e);
			}

		}
				
		int num=Integer.parseInt(br.readLine());
	
		StringTokenizer st3=new StringTokenizer(br.readLine());
		//큐만 신경써서, 큐를 연결해서 거대한 큐라고 생각
		for(int i=0;i<num;i++) {// 넣고 빼는 과정
			sub=Integer.parseInt(st3.nextToken());
			deque.addFirst(sub);

		
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
		
	}

}


/* // 시간초과가 일어난 객체버전. 테스트 케이스는 통과함..
 public class Main{

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int sub;
		int e;
		queuestack[] qt=new queuestack[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {	// 스택이냐 큐냐 고르는 과정
			sub=Integer.parseInt(st.nextToken());
			qt[i]=new queuestack(sub);
		}
		
		StringTokenizer st2=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {// 초기 원소 주입 과정
			e=Integer.parseInt(st2.nextToken());
			autoSelectAdd(qt[i], e);
		}
		
		int num=Integer.parseInt(br.readLine());
		//int[] answer=new int[num];
		StringTokenizer st3=new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {			// 넣고 빼는 과정
			sub=Integer.parseInt(st3.nextToken());
			for(int j=0;j<N;j++) {
				autoSelectAdd(qt[j],sub);//먼저 입력받은걸 더하고
				sub=autoSelectPop(qt[j]);;//pop한다.
				
			}
			//answer[i]=sub;
			sb.append(sub).append(" ");
		}
		System.out.println(sb);
		
	}
	public static void autoSelectAdd(queuestack qt, int e) {
		if(qt.status==0) {
			qt.queue.add(e);
		}else {
			qt.stack.push(e);
		}
	}
	
	public static int autoSelectPop(queuestack qt) {
		if(qt.status==0) {
			return qt.queue.poll();
		}else {
			return qt.stack.pop();
		}
	}

	public static class queuestack{	
				
		int status;
		Queue<Integer> queue;
		Stack<Integer> stack;
		public queuestack(int i) {
			if(i==0) {
				//Queue<Integer> queue=new LinkedList<Integer>();
				queue=new LinkedList<Integer>();
				this.status=0;
			}else {
				//Stack<Integer> stack=new Stack<Integer>();
				stack=new Stack<Integer>();
				this.status=1;
			}
		}
	}
}
 */





