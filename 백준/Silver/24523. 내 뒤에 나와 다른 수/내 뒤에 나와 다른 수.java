
import java.util.*;
import java.io.*;

public class Main {

	public static StringBuilder sb=new StringBuilder();
	public static int N;
	public static int[] arr;
	public static int[] answer;
	public static final int max=1000000001;
//	public static PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
//		@Override
//		public int compare(int[] o1, int[] o2) {
//			if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
//			return Integer.compare(o1[0],o2[0]);
//		}
//	});
//	public static TreeSet<Integer> set=new TreeSet<>();
//	public static HashMap<Integer,Integer> map=new HashMap<>();

	//문제를 잘못 이해함. 최솟값의 인덱스가 아니라 가장 가까운 인덱스를 찾는 거였음.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N+1];
        answer=new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Solution1();
        //풀이 1. 뒤에서 탐색. 시간복잡도 O(N)

        
        System.out.println(sb);
    }
    
    public static void Solution1() {
        
        int[] stack = new int[N + 1];
        int top = 0;//포인터 역할
        
        for (int i = N; i >= 1; i--) {
            
            // 같은 값은 제거
            while (top > 0 && arr[stack[top]] == arr[i]) {
                top--;
            }
            
            // 남아 있다면 가장 가까운 다른 수
            if (top == 0) answer[i] = -1;
            else answer[i] = stack[top];
            
            // 현재 인덱스를 오른쪽 후보로 push
            stack[++top] = i;
        }
    	
        for(int i=1;i<=N;i++){
        	sb.append(answer[i]+" ");
        }

    }
    
    public static void Solution2() {
        
    }
}


