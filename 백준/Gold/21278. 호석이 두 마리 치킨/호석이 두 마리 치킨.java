
import java.util.*;
import java.io.*;

public class Main {


	public static int[][] road;
	public static int[] answer=new int[2];
	public static int N;
	public static int min=Integer.MAX_VALUE;
	public static int[] sub=new int[2];
	

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        road=new int[N+1][N+1];
        
        ArrayList<Integer>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }

        
        int a,b;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	list[a].add(b);
        	list[b].add(a);
        	road[a][b]=1;
        	road[b][a]=1;
        }
        
        int[] pos;
    	PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
			
    		@Override
    		public int compare(int[] o1,int[] o2) {
    			return Integer.compare(o1[1], o2[1]);
    		}
    	
    	});
        for(int i=1;i<=N;i++) {
        	
        	boolean[] v=new boolean[N+1];
        	q.clear();
        	q.add(new int[] {i,0});
        	while(!q.isEmpty()) {
        		pos=q.poll();
        		if(v[pos[0]]) continue;
        		v[pos[0]]=true;     

        		road[i][pos[0]]=pos[1];
        		road[pos[0]][i]=pos[1];
        		for(int next:list[pos[0]]) {
        			if(!v[next]) {
        				q.add(new int[] {next,pos[1]+1});
        			}
        		}
        	}

        }
    	
        comb(1,0);
        System.out.println(answer[0]+" "+answer[1]+" "+min);
//        for(int[] r:road) {
//        	System.out.println(Arrays.toString(r));
//        }
    }
    public static void comb(int pos,int cnt) {

    	if(cnt==2) {
    		int sum=0;
    		for(int i=1;i<=N;i++) {
//    			if(sub[0]==1&&sub[1]==2) {
//    				System.out.println(Math.min(road[sub[0]][i], road[sub[1]][i]));
//    				System.out.println();
//    			}
    			sum+=2*Math.min(road[sub[0]][i], road[sub[1]][i]);
    		}
    		
    		if(sum<min) {
    			answer[0]=sub[0];
    			answer[1]=sub[1];
    			min=sum;
    		}
    		return;
    	}
    	if(pos>=N) return;
    	sub[cnt]=pos;
    	comb(pos+1,cnt+1);
    	comb(pos+1,cnt);
    }
    

    
}
