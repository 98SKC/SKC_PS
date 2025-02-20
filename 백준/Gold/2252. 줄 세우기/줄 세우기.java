import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        //int[] edge=new int[N+1];// i가 뻗은 도착점
        ArrayList<Integer>[] edge=new ArrayList[N+1];// i가 뻗은 도착점
        int[] inDegree=new int[N+1];//i의 진입 차수
        int a=0;
        int b=0;
        for(int i=1;i<=N;i++) {
        	edge[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	edge[a].add(b);
        	inDegree[b]++;
        }
        StringBuilder sb=new StringBuilder();
        ArrayDeque<Integer> q=new ArrayDeque<>();
        // 위상정렬의 시작
        // 1. 진입 차수가 0인 모든 정점을 큐에 집어 넣는다.
        for(int i=1;i<=N;i++) {
        	if(inDegree[i]==0) {
        		q.add(i);
        	}
        }
        int sub;
        // 1-1. 위상정렬의 조건 중 하나는 사이클이 없다는 것. 즉 진입차수가 0인 정점이 하나는 무조건 존재한다.
        while(!q.isEmpty()) {
        	sub=q.poll();
        	sb.append(sub+" ");
        	// 2. 꺼낸 정점과 연결된 간선을 제거한다. 이때 진입 차수가 0인 정점이 생기면 새로 큐에 넣는다.
        	for(int next:edge[sub]) {
        		inDegree[next]--;
        		if(inDegree[next]==0) {
        			q.add(next);
        		}
        	}
        }
 
        //3. 위상정렬의 특징 중 하나는 답이 여러개일 수 있다.
        System.out.println(sb);
    }
}