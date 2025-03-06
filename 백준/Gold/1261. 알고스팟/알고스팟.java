
import java.util.*;
import java.io.*;

public class Main{

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int[][] map=new int[N+1][M+1];
        String str;
        
        int[][] dijk=new int[N+1][M+1];

        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
        		map[i][j]=str.charAt(j-1)-'0';
        		dijk[i][j]=Integer.MAX_VALUE;
        	}
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
        
        	@Override
        	public int compare(int[] o1,int[] o2) {
        		return Integer.compare(o1[2], o2[2]);
        	}
        	
        });

        
        pq.add(new int[] {1,1,0});
        int[] sub;
        int ni,nj;
        int answer=0;
        
        while(!pq.isEmpty()) {

        	sub=pq.poll();
        	if(sub[2]>dijk[sub[0]][sub[1]]) continue;

        	if(sub[0]==N&&sub[1]==M) {
        		answer=sub[2];
        		break;
        	}
        	
        	for(int a=0;a<4;a++) {
        		ni=sub[0]+di[a];
        		nj=sub[1]+dj[a];
        		if(ni>0&&ni<=N&&nj>0&&nj<=M){
        			if(dijk[ni][nj]>(sub[2]+1)){
        				if(map[ni][nj]==0) {
            				dijk[ni][nj]=(sub[2]);
            				pq.add(new int[] {ni,nj,sub[2]});
        				}else {
            				dijk[ni][nj]=(sub[2]+1);
            				pq.add(new int[] {ni,nj,sub[2]+1});
        				}

        			}
        		}
        	}
        }
        
        
        System.out.println(answer);
        
     
    }
}
