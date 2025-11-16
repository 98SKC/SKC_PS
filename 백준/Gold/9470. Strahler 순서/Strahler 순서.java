
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        //유향그래프
        //강은 간선이며, 물이 흐르는 방향이 방향이 된다. 
        //노드는 호수나 샘처럼 강이 시작하는 곳, 강이 합쳐지거나 나누어지는 곳, 바다와 만나는 곳 이다.
        
        //강의 근원인 노드는 1이다.
        //나머지 노드는 그 노드로 들어오는 강의 순서 중 가장 큰 값을 i라 할 때, 
        //들어오는 모든 강 중에서 i가 1개면 i, 2개 이상이면 i+1이다
        //바다와 만나는 노드는 항상 한개이다
        //바다와 만나는 노드의 순서를 구하라
        
        int K,M,P;
        int answer;
        int in,out;
        int T=Integer.parseInt(br.readLine());        

        int[] indegree;
        int[] strahler;//최대값만 저장하는 자료구조
        
        HashMap<Integer,Integer>[] save;// 개수까지 저장하는 자료구조
        ArrayList<Integer>[] edges;
        
        for(int test_case=1;test_case<=T;test_case++) {
        	st=new StringTokenizer(br.readLine());

        	K=Integer.parseInt(st.nextToken());
        	M=Integer.parseInt(st.nextToken());
        	P=Integer.parseInt(st.nextToken());
        	
        	
        	//sb.append(test_case+" ");
        	sb.append(K+" ");
        	
        	indegree=new int[M+1];
        	strahler=new int[M+1];
        	edges=new ArrayList[M+1];
        	save=new HashMap[M+1];
        	
        	for(int i=1;i<=M;i++) {
        		edges[i]=new ArrayList<>();
        		save[i]=new HashMap<>();
        	}
        	
        	for(int i=0;i<P;i++) {
        		st=new StringTokenizer(br.readLine());
        		out=Integer.parseInt(st.nextToken());
        		in=Integer.parseInt(st.nextToken());
        		indegree[in]++;
        		edges[out].add(in);
        	}
        	
        	ArrayDeque<int[]> q=new ArrayDeque<>();
        	
        	for(int i=1;i<=M;i++) {
        		if(indegree[i]==0){
        			strahler[i]=1;//근원의 순서는 1
        			for(int next: edges[i]) {
        				q.add(new int[] {next,1});//next로 순서가 1인 강물이 들어간다.
        			}
        		}
        	}
        	answer=0;
        	int[] node;
        	int p,s;
        	while(!q.isEmpty()) {
        		node=q.poll();
        		p=node[0];
        		s=node[1];
        		
        		save[p].put(s, save[p].getOrDefault(s, 0)+1);
        		indegree[p]--;
        		if(strahler[p]<s) {
        			strahler[p]=s;
        		}
        		

        		
        		if(indegree[p]==0){
        			//strahler[i];//지금은 최대가 저장되어 있다.
        			//System.out.println(p+"에 들어온 강물 수"+save[p].get(strahler[p]));
        			
        			if(save[p].get(strahler[p])>1) {
        				strahler[p]+=1;
        			}
        			
            		answer=Math.max(answer, strahler[p]);
        			for(int next: edges[p]) {
        				q.add(new int[] {next,strahler[p]});//next로 순서가 1인 강물이 들어간다.
        			}
        		}
        		
        	}
        	
        	//위상정렬 같은데
        	//System.out.println(Arrays.toString(strahler));
      	
        	sb.append(answer+"\n");
        }
        
        System.out.println(sb);
        
    }
        
}


