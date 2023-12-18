import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class Main {
	public static boolean[] prime;
	

	
	public static void main(String[] args) throws IOException{
	
	
		int count=1;
		String answer="Nice";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
		
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		//Stack<Integer> stack1=new Stack<>();
		Queue<Integer> queue=new LinkedList<>();
		Stack<Integer> stack2=new Stack<>();
				
		
		for(int i=0;i<N;i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}// 대기열 생성
		
		while(true) {
			if(queue.isEmpty()) {// 큐가 비었다면
				if(stack2.empty()) {
					break;
				}else if(count==stack2.peek()) {//스택에서 꺼내올 수 있는지
					stack2.pop();
					count++;
				}else {// 큐가 비었고, 스텍에서 순서맞게 가져오지 못한다면 실패.
					answer="Sad";
					break;
				}				
			}else {// 큐가 비지 않았다면
				if(count==queue.peek()) {// 대기열 앞사람이 맞는 차례
					queue.poll();//제거 후 번호표 증가
					count++;
				}else if(!stack2.empty()&&count==stack2.peek()) {// 대기열에 없다면 stack 줄에서 탐색. 스택이 비었는지 확인 
					stack2.pop();
					count++;
				}else {// 둘다 해당하는 사람이 없으면 stack으로 보냄
					stack2.push(queue.poll());
				}
					
			}

			
		}
	System.out.println(answer);
	}

}