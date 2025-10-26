
import java.util.*;
import java.io.*;

public class Main {

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수가 하나씩 늘 때마다 지금까지 부른 수들 중 중간값을 출력
        // 전체 수가 짝수개라면 중간수 둘 중 작은 쪽
        
        //넣을 때 마다 정렬하면 시간 복잡도가 0.1초에는 부합하지 않을 것
        //자료구조도 배열이면 계속 밀려야해.
        //일단 배열은아니야.
        //그럼 리스트? 리스트로 내부적으로 밀리는 것으로 아는데.
        //큐를 쓰는건가
        //그림으로 그리면 어떤거지
        //1. 추가되는 수가 중간값 이전이냐 이후에 따라.
        //1-1    1 3 4 5 6 7 8   //홀수에서 2가 추가되면 5에서 4로
        //1-2    1 2 3 4 6 7 8   //홀수에서 5가 추가되면 4 그대로
        //1-3    1 3 4 5 6 7     //짝수에서 2가 추가되면 4 그대로
        //1-4    1 2 3 4 6 7     //짝수에서 5가 추가되면 3에서 4로.
        
        //우선순위 큐를 활용해 최대힙과 최소힙으로 구현해보는 아이디어
		
        //큰 숫자가 먼저
        Queue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2-o1); // 내림차순  
		
        //작은 숫자가 먼저
        Queue<Integer> minHeap = new PriorityQueue<>((o1,o2) -> o1-o2); // 오름차순 
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			
			int num = Integer.parseInt(br.readLine());
			//두 힙의 크기가 같으면 최대힙에 넣고
			if(maxHeap.size() == minHeap.size()) maxHeap.add(num);
			else minHeap.add(num);// 아니면 우선 최소힙에 넣는다.
            
			// maxHeap이 더 클 경우 두 힙의 맨 앞의 수를 바꿔준다.
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					int tmp = maxHeap.poll();
					maxHeap.offer(minHeap.poll());
					minHeap.offer(tmp);
				}
			}
			sb.append(maxHeap.peek()+"\n");
			
		}
		
		System.out.println(sb.toString());
        
    }
}
