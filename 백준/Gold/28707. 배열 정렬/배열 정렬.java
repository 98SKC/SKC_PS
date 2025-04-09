
import java.util.*;
import java.io.*;

public class Main{

	public static class Node{
		int[] arr;
		int cost;
		
		public Node(int[] arr,int cost) {
			this.arr=arr;
			this.cost=cost;
		}
//		public Node(int[] arr,int cost) {
//			this.arr=key(arr);
//			this.cost=cost;
//		}
		
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N+1];
        int[][] cost=new int[N+1][N+1];
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        int M=Integer.parseInt(br.readLine());
        int a,b,c;

        for(int i=1;i<=M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	list.add(new int[] {a,b,c});
        }
        
        int answer=-1;
        HashMap<String,Integer> map=new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(arr, 0));
        int save;
        Node node;
        while (!pq.isEmpty()) {
            node = pq.poll();
            String currKey = key(node.arr);

            // 이미 더 적은 비용으로 도달한 적 있다면 스킵
            if (map.containsKey(currKey) && map.get(currKey) <= node.cost) continue;
            map.put(currKey, node.cost);

            // 정렬 상태 확인
            boolean isSorted = true;
            for (int i = 1; i < node.arr.length - 1; i++) {
                if (node.arr[i] > node.arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
            //정렬 되었으면 나가리
            if (isSorted) {
                answer = node.cost;
                break;
            }

            // 가능한 교환 수행
            for (int[] next : list) {
                int[] newArr = node.arr.clone();// 배열 10개짜리니 복사해서 넣어으면서 객체 만들어도 메모리 안터지려나

                int temp = newArr[next[0]];
                newArr[next[0]] = newArr[next[1]];
                newArr[next[1]] = temp;

                int newCost = node.cost + next[2];
                String nextKey = key(newArr);

                if (!map.containsKey(nextKey) || map.get(nextKey) > newCost) {
                    pq.add(new Node(newArr, newCost));
                }
            }
        }

        
        System.out.println(answer);
        
    }
    
    public static String key(int[] arr) {
    	String str="";
    	for(int i=1;i<arr.length;i++) {
    		str+=arr[i];
    	}
    	return str;
    }
    
}
