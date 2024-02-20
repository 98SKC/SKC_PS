import java.io.*;
import java.util.*;




public class Main {
   

	static int N,M;
	static Queue<int[]> q=new ArrayDeque<>();
	static int[] di= {0,1,0,-1};// 우 하 좌 상
	static int[] dj= {1,0,-1,0};
	static int[][] map;
	static boolean[][] v;
	static boolean escape;
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	map=new int[N][M];
    	v=new boolean[N][M];
    	int[] sub;
    	int count=0;
    	int hourBefore=0;
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
    	}
    	
    	while(true) {
    		v=new boolean[N][M];
    		searchEdge(0,0);
    		if(q.size()==0) {//삭제할 좌표가 없다면
    			break;
    		}else {
    			hourBefore=q.size();
    			while(!q.isEmpty()) {
    				sub=q.poll();
    				map[sub[0]][sub[1]]=0;
    			}
    		}
    		count++;
//    		for(int[] a:map) {
//    			System.out.println(Arrays.toString(a));
//    		}
    	}
    	System.out.println(count);
    	System.out.println(hourBefore);
    }
    static void searchEdge(int i, int j) {
    	
    	int ni;
    	int nj;
    	
    	for(int a=0;a<4;a++) {
    		ni=i+di[a];
    		nj=j+dj[a];
    		if(ni>=0&&ni<N&&nj>=0&&nj<M) {//이동 지역이 map 안쪽일 때
    			if(map[ni][nj]!=1&&!v[ni][nj]) {// 치즈 벽이 아니고, 방문한 적이 없으면
    				v[ni][nj]=true;
    				searchEdge(ni,nj);
    			}
    			if(map[ni][nj]==1&&!v[ni][nj]) {//치즈벽을 만나면 녹을 예정. 이미 처리한 치즈 벽이라는 의미로 true
    				v[ni][nj]=true;
    				q.offer(new int[] {ni,nj});// 삭제할 치즈의 벽 좌표 저장.
    			}
    			
    		}
    	}
    	
    	
    }

}