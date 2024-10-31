import java.util.Scanner;
import java.util.LinkedList;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;
		
		int N = in.nextInt();	// 큐의 크기(1 ~ N)
		int M = in.nextInt();	// 뽑으려는 숫자의 개수
		
		// 1부터 N까지 덱에 담아둔다.
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열
		
		for(int i = 0; i < M; i++) {
			seq[i] = in.nextInt();
		}
		
		
		for(int i = 0; i < M; i++) {			
			

			int target_idx = deque.indexOf(seq[i]);
			int half_idx;

			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			

			if(target_idx <= half_idx) {

				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우 

				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			
			}
			deque.pollFirst();	
		}
		
		System.out.println(count);
		
		
	}
}