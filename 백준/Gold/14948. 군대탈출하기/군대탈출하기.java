import java.io.*;
import java.util.*;

public class Main {
	//public static boolean[][] v;
	public static int[][] map;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static int N,M;
	public static int level;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        map=new int[N][M];
        //v=new boolean[N][M];
        int right=0;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		right=Math.max(map[i][j], right);
        	}
        }
        
        int left=map[0][0];//(0,0)에서 출발하기 위한 최소거리.
        int mid;

        /*
         * 1. < mid+1, mid-1 조건: 정확한 값을 찾는다.
         * 2. 
         * 3. 
         * */
        boolean f;
        while(left<=right){
        	mid=left+(right-left)/2;
        	level=mid;
            //v=new boolean[N][M];
        	//v[0][0]=true;
        	f=bruteForce();
        	//System.out.println(f);
        	if(f) {
        		//answer=Math.min(answer, level);
        		//레벨을 더 낮춘다.
        		right=mid-1;
        	}else {
        		left=mid+1;
        	}
        	//이 mid 레벨에서 도달이 가능한가?
        	
        }
       
        System.out.println(left);

 
        
        //(0,0)에서 출발, 상하좌우로만 이동. n-1,m-1에 도착해야한다.
        //각 블록에는 레벨이 있다. 그 레벨 이상만 통과 가능하다.
        //한 블록만 무시할 수 있을 때,탈출을 위한 최소 레벨을 구하라.
        
        
        
    }
    
    
    //틀렸던 이유.
    //처음 문제를 이해한 방향은 한칸만 레벨을 무시하고 갈 수 있다였음
    //그런 문제였으면 PQ를 사용하며 2차원 배열 방문으로도 구현이 가능했으나,
    //문제에서 요구한건 블록을 무시해서, 그 방향으로 다음 블록으로 넘어가는 거였음.
    //해당 조건에 맞게 bfs 방식을 바꿨으나, 이 경우 블록에서 점프할 때 '방향'이 중요하기에 방문배열이 3차원이어야만함.
    //
    public static boolean bruteForce(){
    	
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	
    	boolean[][][] v=new boolean[N][M][2];
    	q.add(new int[] {0,0,0});
    	v[0][0][0]=true;
    	int ni,nj;
    	int[] p;
    	while(!q.isEmpty()) {
    		p=q.poll();
    		
    		if(p[0]==(N-1)&&p[1]==(M-1)) {
    			break;
    		}
    		
        	for(int a=0;a<4;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj][p[2]]) {
        			if(map[ni][nj]<=level) {
        				v[ni][nj][p[2]]=true;
        				q.add(new int[] {ni,nj,p[2]});
        			}else if(map[ni][nj]>level&&p[2]==0){
                		ni+=di[a];
                		nj+=dj[a];
                		if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj][1]&&map[ni][nj]<=level) {
            				v[ni][nj][1]=true;
            				q.add(new int[] {ni,nj,1});
                		}
        			}
        		}
        	}    		
    		
    	}
    	
//    	System.out.println(level+"레벨에서"+v[N-1][M-1]);
//    	for(boolean[] vv:v) {
//    		System.out.println(Arrays.toString(vv));
//    	}
//    	System.out.println();

    	
    	return v[N-1][M-1][0]||v[N-1][M-1][1];
    }

}
