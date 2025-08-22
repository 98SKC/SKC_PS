
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int N, M;
        
        StringBuilder sb=new StringBuilder();
        
        int a,b,c;
        int[] indegree;
        for(int test_case=1;test_case<=T;test_case++) {
        	st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken()); //노드의 수
            M=Integer.parseInt(st.nextToken()); //간선의 수
            
            int[] island=new int[N+1];
            indegree=new int[N+1];
            ArrayList<int[]>[] bridge=new ArrayList[N+1];
            
            for(int i=1;i<=N;i++) {
            	bridge[i]=new ArrayList<>();
            }
            
            for(int i=0;i<M;i++) {
            	st=new StringTokenizer(br.readLine());
            	a=Integer.parseInt(st.nextToken());
            	b=Integer.parseInt(st.nextToken());
            	c=Integer.parseInt(st.nextToken());
            	indegree[a]++;
            	indegree[b]++;
            	
            	bridge[a].add(new int[]{b,c});
            	bridge[b].add(new int[]{a,c});
            	
            } 
            
            ArrayDeque<int[]> q=new ArrayDeque<>();
            boolean[] v=new boolean[N+1];
            for(int i=2;i<=N;i++) {
            	if(indegree[i]==1) q.add(new int[] {i,Integer.MAX_VALUE});
            }
            
            int[] dp=new int[N+1];
            int[] p;
            while(!q.isEmpty()) {
            	p=q.poll();
            	
            //	indegree[p[0]]--;
            	
            	
            	//System.out.println(p[0]+"위로");
            	for(int[] next: bridge[p[0]]) {
            		if(indegree[next[0]]==0) continue; //이미 끝난 자식노드
            		//System.out.println(next[0]+" dp 결과 산출: "+p[1]+" vs "+next[1]);
            		dp[next[0]]+=Math.min(p[1],next[1]);
            		indegree[next[0]]--;
            		if(indegree[next[0]]==1&&next[0]!=1) q.add(new int[] {next[0],dp[next[0]]});
            		
            	}
            	//System.out.println();
            	
            }
           // System.out.println(Arrays.toString(dp));
            sb.append(dp[1]+"\n");
        }
        
        System.out.println(sb);
        //N개의 섬. 
        //연결되있는 다리들을 폭파하려한다.
        //다리 폭파에 사용되는 코스트는 다리크기마다 다르다.
        
        /* 1번이 기준 노드
         * 1번을 제외한
         * 다리가 하나뿐인 섬에 루팡이 있고
         * 루팡이 있을있을 가능성이 있는 모든 섬에서 자신의 섬으로의 경로를 차단.
         * 간선이 하나뿐인 노드들이 1번으로 도달하지 못하도록 간선을 제거하는 최소코스트를 구하는 문제
         * */
        
         // 특정 노드에서 1번에 도달 못하도록 하기위한 최소 코스트
         // && 그런 노드가 다수인 부분에서 발생하는 중복다리 이슈.
         //  각자 다리는 2,2코스트를 자르면 최소지만, 두 다리가 모두 지나는 3코스트 다리를 파괴하면 최소인 경우
        

        //M이 주어지지만 무조건 N-1개의 간선이 주어지는 사이클 없는 트리형태의 맵
        
        
    }
}
