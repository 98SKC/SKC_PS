
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static boolean[][] v;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static int[] select;
	public static int N,M,total;
	public static ArrayList<int[]> virus=new ArrayList<>();
	public static ArrayDeque<int[]> q;
	public static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //연구소 크기
        M=Integer.parseInt(st.nextToken()); //바이러스 개수
        select=new int[M];//M개의 바이러스를 선택할 것.
        map=new int[N][N];
        v=new boolean[N][N];
        total=0;// 감염시켜야 하는 빈공간의 수
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		if(map[i][j]==0) total++;
        		else if(map[i][j]==2) virus.add(new int[] {i,j,0});
        	}
        }
        
        

        
        //닿은 면적도 아님.
        
        //모든 경우의 수 완탐 말고는 없을 것 같은데

        //벽으로 둘러쌓인 곳 안의 바이러스를 활성화 시켜야만 한다면? 이건 어떻게 판별할건데
        
        //1. m개를 활성화 시켜서 전부 감염이 가능한가?
        int m=0;
        boolean find;
        int[] pos;
        int ni,nj;
        q=new ArrayDeque<>();

        
        comb(0,0);
        if(min==Integer.MAX_VALUE) {
        	System.out.println(-1);
        }else {
        	System.out.println(min);        	
        }
        
    }
    
    public static void comb(int p,int m) {// 현 바이러스 인덱스, 고른 개수, 
    	if(m==M){
    		//System.out.println("조합확인: "+Arrays.toString(select));
    		bfs();
    		return;
    	}
    	
    	if(p>=virus.size()){//
    		return;
    	}
    	
    	select[m]=p;//m번째 바이러스로 p를 선택했을 때
    	comb(p+1,m+1);
    	comb(p+1,m);// 선택 안했을 때

    }
    
    public static void bfs() {
    	int max=0;
		v=new boolean[N][N];
		q=new ArrayDeque<>();
		int[] sub;
		for(int s:select) {
			sub=virus.get(s);
			q.add(sub);
			v[sub[0]][sub[1]]=true;
		}	
		int[] p;
		int ni,nj;
		int cnt=0;
		int[][] reverse=new int[N][N];
		while(!q.isEmpty()) {
			p=q.poll();
			
			
			//System.out.println("시발 뭔데 대체 개새끼야 "+pos[0]+" "+pos[1]);
			for(int a=0;a<4;a++) {
				ni=p[0]+di[a];
				nj=p[1]+dj[a];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]){//격자 내부이고 방문하지 않았으며
					if(map[ni][nj]!=1){//벽이 아니면 이동
						if(map[ni][nj]==0) {
							cnt++;// 빈공간 채웠으면
							reverse[ni][nj]=p[2]+1;
							max=Math.max(max, p[2]+1);
						} 
						v[ni][nj]=true;
						q.add(new int[] {ni,nj,p[2]+1});
					}
				}
			}
		}
		
		if(total==cnt) {
//			System.out.println("max: "+max);
//			for(int[] bb:reverse) {
//				System.out.println(Arrays.toString(bb));
//			}
			min=Math.min(max, min);			
		}else{
//			for(boolean[] vv:v) {
//				System.out.println(Arrays.toString(vv));
//			}
//			for(int[] bb:reverse) {
//				System.out.println(Arrays.toString(bb));
//			}
//			System.out.println("??: "+cnt+" "+total);
		}

    }
    
}
