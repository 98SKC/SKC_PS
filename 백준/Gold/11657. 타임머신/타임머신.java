
import java.util.*;
import java.io.*;

public class Main{

	

	public static long[] min;
	public static int N,M;
	public static ArrayList<int[]>[] edges;
	public static final long INF = Long.MAX_VALUE / 4;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        min=new long[N+1];
        edges=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	edges[i]=new ArrayList<>();
        	min[i]=INF;
        }
        
        for(int i=1;i<=M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int A=Integer.parseInt(st.nextToken());
        	int B=Integer.parseInt(st.nextToken());
        	int C=Integer.parseInt(st.nextToken());
        	
        	edges[A].add(new int[] {B,C});
        	
        }
        
        min[1]=0;
        
        for(int k=0;k<N;k++) {//N번 반복
        	
            for(int i=1;i<=N;i++) { //간선반복 
            	for(int[] next:edges[i]) {
            		if(min[i]!=INF && min[next[0]]>min[i]+next[1]) {
            			min[next[0]]=min[i]+next[1];
            		}
            	}
            }
        }
        
        for(int i=1;i<=N;i++) { //간선반복 
        	for(int[] next:edges[i]) {
        		if(min[i]!=INF && min[next[0]]>min[i]+next[1]) {
        			System.out.println(-1);
        			return;
        		}
        	}
        }
        
        StringBuilder sb=new StringBuilder();

 
		for(int i=2;i<=N;i++) {
			if(min[i]==INF) sb.append(-1+"\n");
			else sb.append(min[i]+"\n");
		}
		System.out.println(sb);
        // N개의 도시
        // 버스 M대
        // 각 버스는 A,B,C 로 나타남. 각각 시작도시, 도착도시, 걸리는 시간이다.
        // 시간은 양수가 아닐 수 있다. 
        
        
        //1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하라.
    }
    
    
        
}


