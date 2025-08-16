
import java.util.*;
import java.io.*;



//세그먼트트리를 응용하는 문제
//세그먼트트리는 본래 구간에 따른 합을 저장하는 트리
//여기서는 구간에 따른 최대 최소를 저장하는 트리로 이용
//기본적으로 두종류의 메서드가 필요.
//트리를 초기화하는 메서드
//특정 범위의 값을 찾는 메서드
//필요시 리프노드의 값을 업데이트하는 메서드도 필요할 때가 있다.
//트리의 크기는 원본배열 크기의 4배로.
//본래트리의 노드개수는 리프가 n개일 때, 내부노드 개수는 n-1.
//
public class Main{
	
	public static int[] segmentMin;
	public static int[] segmentMax;
	public static int[] arr;
	public static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        arr=new int[N+1];
        
        
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
        // 세그먼트 트리 메모리 확보
        segmentMin=new int[4*N];
        segmentMax=new int[4*N];
        
        
        initMin(1,N,1);
        initMax(1,N,1);
        
        
        StringBuilder sb= new StringBuilder();
        int left,right;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	left=Integer.parseInt(st.nextToken());
        	right=Integer.parseInt(st.nextToken());
        	
        	sb.append(findMin(1,N,1,left,right)+" "+findMax(1,N,1,left,right)+"\n");
        	
        }
        System.out.println(sb);
        //1~10만 범위의 정수 N개.
        //a부터 b번째 정수까지 중 제일 작은 정수 또는 큰 정수를 찾는다.
        //이 a,b 쌍이 1~10만개의 쌍이 있다. 
        //첫줄에 N,M이 주어진다.
        //N개의 줄에 N개의 정수,
        //M개의 줄에는 a,b쌍
        
        //dp로 1번 탐색해놓고, 각 호출에 한번에 찾아야 시간내 돌아갈 것으로 보인다.
        //이분탐색은 사용이 될까?
        //dp[a][b]를 모두 구해놓는다면? -> 100000! 이 되는데? 아니지
        
    }
    
    //start부터 end까지의 최소값을 저장하는 초기화 및 최소값 반환.
    public static int initMin(int start, int end,int node) {
    	//start는 해당 노드가 포함하는 범위의 시작점, 
    	//end는 해당 노드가 포함하는 범위의 끝점
    	//node는 트리에서의 노드 인덱스

    	//범위가 단 한곳. 나 자신. 그렇기에 최소는 자기 자신.
    	if (start==end) {
    		return segmentMin[node] = arr[start];
    	}
    	
    	int mid=(start+end)/2;
    	int left=initMin(start,mid,node*2); //왼쪽에서의 최소
    	int right=initMin(mid+1,end,node*2+1); //오른쪽에서의 최소
    	return segmentMin[node] = Math.min(left, right); // 해당 노드의 최소는 좌 우 값중 작은 값
    	
    }
    
    public static int initMax(int start, int end,int node) {
    	//start는 노드가 의미하는 범위의 시작점
    	//end는 노드가 의미하는 범위의 끝점
    	//node는 트리에서의 노드 인덱스
    	
    	if(start==end){
    		return segmentMax[node] = arr[start];
    	}
    	
    	int mid=(start+end)/2;
    	int left=initMax(start,mid,node*2); //왼쪽에서의 최대
    	int right=initMax(mid+1,end,node*2+1); //오른쪽에서의 최대
    	return segmentMax[node] = Math.max(left, right); // 해당 노드의 최소는 좌 우 에서 큰값
    	
    }
    
    
    public static int findMin(int start, int end, int node, int left, int right ) {
    	//start는 node가 의미하는 범위의 시작점
    	//end는 node가 의미하는 범위의 끝점
    	//node는 트리의 현 위치.
    	//left는 찾고자 하는 범위 좌측
    	//right는 찾고자 하는 범위 우측
    	
    	// 겹침 없음
    	if(right<start||end<left) return Integer.MAX_VALUE;
    	
    	// 완전 포함
    	if(left<=start&&end<=right) return segmentMin[node];
    	
    	// 부분 겹침
    	int mid=(start + end)/2;
    	int a=findMin(start, mid, node*2, left, right);
    	int b=findMin(mid+1, end, node*2+1, left, right);
    	return Math.min(a, b);
    	
    	
    	
    	
    }
    
    public static int findMax(int start, int end, int node, int left, int right ) {
    	//start는 node가 의미하는 범위의 시작점
    	//end는 node가 의미한 범위의 끝점
    	//node는 트리의 현 위치
    	//left는 찾고자 하는 범위 좌측
    	//right는 찾고자 하는 범위 우측
    	
    	// 겹침 없음
    	if (right<start||end<left) return 0;
    	
    	// 완전 포함
    	if (left<=start&&end<=right) return segmentMax[node];
    	
    	// 부분 겹침
    	int mid=(start+end)/2;
    	int a=findMax(start, mid, node*2, left, right);
    	int b=findMax(mid+1, end, node*2+1, left, right);
    	return Math.max(a, b);
    	
    }
    
    
}
