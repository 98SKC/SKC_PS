
import java.util.*;
import java.io.*;

public class Main{

	public static ArrayList<int[]>[] list;
	public static int N,Q;
	public static int[][] usado;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        usado=new int[N+1][N+1];
        int a,b,c;
        for(int i=0;i<N-1;i++) {
        	//System.out.println(i+" ");
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	
        	list[a].add(new int[] {b,c});
        	list[b].add(new int[] {a,c});

        }
        
        int k,v,count;
        //k,v가 주어지는데, k일 경우 v를 보고있는(v가 시작 정점) 사람들에게 몇개의 영상이 추천되는가(거리가 k이내의 동영상이 몇개인가)
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<Q;i++) {
        	st=new StringTokenizer(br.readLine());
        	k=Integer.parseInt(st.nextToken());
        	v=Integer.parseInt(st.nextToken());
        	count=-1;
        	int[] sub;
        	ArrayDeque<int[]> q=new ArrayDeque<>();
        	boolean[] visit=new boolean[N+1];
        	q.add(new int[] {v,Integer.MAX_VALUE});
        	while(!q.isEmpty()){
        		sub=q.poll();
        		
        		if(sub[1]>=k){
        			count++;
        		}
        		visit[sub[0]]=true;
        		for(int[] next:list[sub[0]]) {
        			if(!visit[next[0]]) {
        				q.add(new int[] {next[0],Math.min(sub[1], next[1])});
        			}
        		}
        		
        	}
        	
        	sb.append(count+"\n");
        	
        } 
        System.out.println(sb);

    }
    

}
