import java.util.*;
import java.io.*;

public class Main {

	public static class Robot{
		int dir;
		int x;
		int y;
		
		public Robot(int y, int x,int dir) {
			this.dir=dir;
			this.x=x;
			this.y=y;
		}
	}
	public static int[] di=new int[] {-1,0,1,0};
	public static int[] dj=new int[] {0,1,0,-1};
	
	public static int[][] map;
	public static boolean[][] v;
	public static int N,M;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	map=new int[N][M];
    	v=new boolean[N][M];
    	
    	
    	st=new StringTokenizer(br.readLine());
    	Robot robot=new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
    	
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int answer=0;
    	while(true) {
    		//System.out.println("");
    		if(!v[robot.y][robot.x]) {
    			v[robot.y][robot.x]=true;// 현 위치 청소
    			answer++;
    		}
    		
    		
    		//주변 4칸 청소되지 않은 빈칸 있는지 확인
    		int[] next=turn(robot);
    	//	System.out.println("이동 전: "+robot.y+" "+robot.x+" "+robot.dir);
    		if(next[0]==2) {
    		//	System.out.println("탈출");
    			// 후진 불가	
    			break;
    		}else if(next[0]==1){// 전진 가능
    			robot.y=robot.y+di[(next[1])];
        		robot.x=robot.x+dj[(next[1])];
        		robot.dir=next[1];
        	//	System.out.println("전진");
        		
    		}else {// 후진
        		robot.y=robot.y+di[(next[1]+2)%4];
        		robot.x=robot.x+dj[(next[1]+2)%4];
        	//	System.out.println(next[1]+"의 후진");
    		}
    		
//    		System.out.println("이동 후: "+robot.y+" "+robot.x+" "+robot.dir);
//        	for(int i=0;i<N;i++) {
//        		for(int j=0;j<M;j++) {
//        			if(robot.y==i&&robot.x==j) {
//        				System.out.print("R ");
//        			}else {
//        				System.out.print(v[i][j]+" ");
//        			}
//        			
//        		}
//        		System.out.println();
//        	}
//        	System.out.println();
        	
    	}
    	
    	System.out.println(answer);
    }
    
    public static int[] turn(Robot robot) {
    	int pi=robot.y;
    	int pj=robot.x;
    	int dir=robot.dir;
    	
    	int[] answer=new int[2];// 0은 전진,후진을 표시. 1은 dir을 삽입
    	
    	int ni,nj;
    	int ndir=dir;
    	int adir=0;
    	int astraight=0;// 후진
    	// 반시계부터, -1부터 확인
    	for(int a=1;a<=4;a++) {
    		ndir = (dir-a+4)%4;
    		ni=pi+di[ndir];
    		nj=pj+dj[ndir];
    		if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!=1&&!v[ni][nj]){
    			// 갈 수 있고, 먼지가 있으면
    			adir=ndir;
    			astraight=1;
    			break;
    		}
    		
    	}
    	
    	if(ndir==dir&&astraight==0){// 방향이 같은데 전진이 아니면 후진.
    		//System.out.println("후진 시 조건문 확인?");
    		ni=pi+di[(dir+2)%4];
    		nj=pj+dj[(dir+2)%4];
    		adir=dir;
    		if(ni<0||ni>=N||nj<0||nj>=M||map[ni][nj]==1) {// 근데 갈 수도 없는 곳이면
    			astraight=2;// 정지
    		}
    		
    	}
    	
    	answer[0]=astraight;
    	answer[1]=adir;
    	
    	return answer;
    }
    
    
}