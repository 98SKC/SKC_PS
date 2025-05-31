
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static int[] dice=new int[] {0,1,2,3,4,5,6}; //인덱스 6이 아래쪽
	public static int[] di=new int[] {0,1,0,-1};// 동 남 서 북 순서
	public static int[] dj=new int[] {1,0,-1,0};
	public static int N,M,K;
	public static int answer=0;
	public static int dir=0; //현 반향
	
	// 주사위가 동으로 움직임. 1->3 , 3->6 , 6->4, 4->1
	// 주사위가 서로 움직임. 1->4, 4->6, 6->3, 3->1
    // 주사위가 북으로 움직임. 1->2, 2->6, 6->5, 5->1
	// 주사위가 남으로 움직임. 1->5, 5->6, 6->2, 2->1
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //맵 크기. 시작 좌표는 1,1
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        //이동 횟수
        K=Integer.parseInt(st.nextToken());
        map=new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        int ni,nj;
        int pi=1,pj=1;
        //시작은 1,1에서 동쪽. k번 이동
        int A,B,C;// A- 주사위 아래쪽 면(6), B- 주사위가 있는 칸 (x,y)의 숫자. C- x,y의 숫자 B에서 연속해서 이동 가능한 칸
        //C- 점수는 b*c
        
        for(int k=1;k<=K;k++) {
        	ni=pi+di[dir];
        	nj=pj+dj[dir];
        	if(!(ni>0&&ni<=N&&nj>0&&nj<=M)) {//격자 내부면 그대로. 
        		ni=pi-di[dir];
            	nj=pj-dj[dir];
            	//System.out.print("반전: "+dir);
            	dir=(dir+2)%4;
            	//System.out.println("-> "+dir);
        	}
        	//위치 변경
        	pi=ni;
        	pj=nj;
        	//주사위 상태 변경
        	if(dir==0) {
        		east();
        	}else if(dir==1) {
        		south();
        	}else if(dir==2) {
        		west();
        	}else if(dir==3) {
        		north();
        	}
        	
        	A=dice[6];
        	B=map[pi][pj];
        	C=getC(pi,pj);
        	answer+=B*C;
        	if(A>B) {// 시계 90도
        		dir=(dir+1)%4;
        	}else if(A<B) {// 반시계 90도
        		dir-=1;
        		if(dir==-1) dir=3;
        	}
        	//System.out.println(k+ "턴 이동 후 다이스");
        	//System.out.println(Arrays.toString(dice));
        	
        	//System.out.println("A: "+A+" B: "+B+" C: "+C+" 이번 점수: "+B*C+" 위치: "+pi+" "+pj+" 방향: "+dir);
        	// 동 남 서 북 순서
        	
        }
        System.out.println(answer);
        
        
        
    }
	// 주사위가 동으로 움직임. 1->3 , 3->6 , 6->4, 4->1
	// 주사위가 서로 움직임. 1->4, 4->6, 6->3, 3->1
    // 주사위가 북으로 움직임. 1->2, 2->6, 6->5, 5->1
	// 주사위가 남으로 움직임. 1->5, 5->6, 6->2, 2->1
	public static void east() {
		int sub=dice[1];
		dice[1]=dice[4];
		dice[4]=dice[6];
		dice[6]=dice[3];
		dice[3]=sub;
		
	}
	
	public static void west() {
		int sub=dice[1];
		dice[1]=dice[3];
		dice[3]=dice[6];
		dice[6]=dice[4];
		dice[4]=sub;
	}
	
	public static void north() {
		//System.out.println();
		//System.out.println("변형 전: "+ Arrays.toString(dice));
		int sub=dice[1];
		dice[1]=dice[5];
		dice[5]=dice[6];
		dice[6]=dice[2];
		dice[2]=sub;
		//System.out.println("변형 후: "+ Arrays.toString(dice));
		//System.out.println();
	}

	public static void south() {
		//System.out.println();
		//System.out.println("변형 전: "+ Arrays.toString(dice));
		int sub=dice[1];
		dice[1]=dice[2];
		dice[2]=dice[6];
		dice[6]=dice[5];
		dice[5]=sub;
		//System.out.println("변형 후: "+ Arrays.toString(dice));
		//System.out.println();
	}
    
    public static int getC(int pi, int pj) {
    	int answer=0;
    	int ni,nj;
    	int target=map[pi][pj];
    	boolean[][] v=new boolean[N+1][M+1];
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {pi,pj});
    	v[pi][pj]=true;
    	int[] p;
    	while(!q.isEmpty()) {
    		answer++;
    		p=q.poll();
    		for(int a=0;a<4;a++) {
    			ni=p[0]+di[a];
    			nj=p[1]+dj[a];
    			if(ni>0&&ni<=N&&nj>0&&nj<=M&&!v[ni][nj]&&map[ni][nj]==target) {
    				v[ni][nj]=true;
    				q.add(new int[] {ni,nj});
    			}
    		}
    	}
    	
    	return answer;
    }
    
}
