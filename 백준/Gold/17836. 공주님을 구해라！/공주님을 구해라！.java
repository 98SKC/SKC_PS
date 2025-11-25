
import java.util.*;
import java.io.*;

public class Main{

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        
        boolean[][] v=new boolean[N+1][M+1];
        int[][] map=new int[N+1][M+1];
        int[] di=new int[] {0,1,0,-1};
        int[] dj=new int[] {1,0,-1,0};
        int ni,nj;
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        int answer=Integer.MAX_VALUE;
        
        //N,M 크기의 성 입구 1,1 로 시작.
        //맵 곳곳에는 마법의 벽이 있다.
        //지금 무기로는 마법의 벽을 통과할 수 없다
        //T시간 내에 용사를 만나야 한다.
        //한칸 이동에 한시간이 걸린다. 
        //이동은 상하좌우
        //맵에는 전설의무기가 있다. 이를 습득하면 벽을 통과할 수 있다.
        //검은 어딘가에 반드시 한개 존재하고, 도락하면 바로 사용할 수 있다.
        //공주를 구출할 수 있는지, 있다면 얼마나 빨리 구할 수 있는지 알아보자.
        
        //무기를 습득하면 제곱거리, 습득할 수 없으면 BFS
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        q.add(new int[] {1,1,0});
        v[1][1]=true;
        
        int[] p;
        int dist;
        
        while(!q.isEmpty()) {
        	
        	p=q.poll();
        	
        	if(p[2]>T) break;
        	if(map[p[0]][p[1]]==2){
        		dist=calDist(p[0],p[1],N,M)+p[2];
        		if(dist<=T) {
        			
        			answer=Math.min(answer,dist);
        			
        		}
        		
        		continue;
        		
        	}else if(p[0]==N&&p[1]==M){
        		answer=Math.min(answer,p[2]);
        		break;
        	}
        	
        	
        	for(int a=0;a<4;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		if(ni>0&&ni<=N&&nj>0&&nj<=M&&map[ni][nj]!=1&&!v[ni][nj]){
        			v[ni][nj]=true;
        			q.add(new int[] {ni,nj,p[2]+1});
        		}
        	}
        	
        }
        if(answer!=Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println("Fail");
        
    }
    
    public static int calDist(int si, int sj, int gi, int gj) {
    	
    	return Math.abs(si-gi)+Math.abs(sj-gj);
    	
    }
    
    
        
}


