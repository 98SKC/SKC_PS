
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
	public static int[][] map;
	public static int[][] s=new int[10][2];
	public static int N,M;
	public static int[] virus;// M개의 바이러스 후보
	public static int number;
	
	public static int goal;// 다 채워야하는 빈칸의 공간
	public static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][N];

        
        number=0;
        answer=N*N;
        virus=new int[M];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            	
            	//시작 가능한 후보 점
            	if(map[i][j]==2) {
            		s[number][0]=i;
            		s[number][1]=j;
            		number++;//바이러스 후보의 수           		
            	}
            	
            	if(map[i][j]!=1) goal++;
            }
        }
        
       // System.out.println(goal+"??");
        comb(0,0);
        if(answer==N*N) System.out.println(-1);
        else System.out.println(answer);
        
    }
    
    public static void comb(int start, int cnt){//cnt번째 바이러스 후보 선택
    	
    	if(cnt==M) {
    		//System.out.println(Arrays.toString(virus));
    		answer=Math.min(answer, bfs());
    		return;
    	}
    	
    	
    	for(int i=start;i<number;i++) {
    		virus[cnt]=i;
    		comb(i+1,cnt+1);
    	}
    }
    
    public static int bfs(){
    	int total=goal;// total이 0이 되어야 끝
    	int turn=0;
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	boolean[][] v=new boolean[N][N];
    	
    	for(int vir:virus){
    		q.add(new int[] {s[vir][0],s[vir][1],0});
    		v[s[vir][0]][s[vir][1]]=true;
    		total--;
    	}
    	
    	int[] p;
    	int ni,nj;
    	
    	while(!q.isEmpty()){
    		p=q.poll();
    		turn=Math.max(turn, p[2]);
    		for(int a=0;a<4;a++) {
    			ni=p[0]+di[a];
    			nj=p[1]+dj[a];
    			if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]!=1&&!v[ni][nj]){
    				v[ni][nj]=true;
    				total--;
    				q.add(new int[] {ni,nj,p[2]+1});
    			}
    		}
    		
    	}
    	
    	//System.out.println(total);
    	if(total!=0) return Integer.MAX_VALUE;
    	return turn;
    }
}
