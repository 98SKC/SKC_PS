
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken()); //세로
        int M=Integer.parseInt(st.nextToken()); //가로
        int X=Integer.parseInt(st.nextToken()); //주사위 좌표
        int Y=Integer.parseInt(st.nextToken()); //주사위 좌표
        int K=Integer.parseInt(st.nextToken()); //명령어 수
        
        int[] dice=new int[7];//1이 바닥이고, 3이 우측, 7-바닥이 위쪽 면. 
        //주사위에 적힌 정수.
        
        int[][] map=new int[N][M];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        if(map[X][Y]!=0) dice[6]=map[X][Y];

        int[] pos=new int[] {0,1,2,3,4,5,6};//인덱스 1 5 6 2이 남 북으로 움직임. 인덱스 1 3 6 4가가 동 서로 움직임 
        //주사위를 굴렸을 때, 지도에 숫자가 0이면, 주사위 바닥면 수가 칸에 복사.
        //0이 아니면 주사위 바닥에 지도 숫자가 복사 후 지도는 0
        //남쪽으로 구른다. [1 5 6 2] 1 5 6 2
        //동쪽으로 구른다. [1 3 6 4] 1 3 6 4
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int[] order=new int[K];
        for(int i=0;i<K;i++) {
        	order[i]=Integer.parseInt(st.nextToken());
        }
        int[] di=new int[] {0,0,0,-1,1};//동 서 북 남 
        int[] dj=new int[] {0,1,-1,0,0};
        int ni,nj;
        int tmp;
        //pi,pj 는 X Y로 대체.
        for(int k:order) {
        	
        	//지도 좌표
        	ni=X+di[k];
        	nj=Y+dj[k];
        	
        	//지도에서 이동이 가능한 구역이 맞는지 먼저 확인
        	 if(ni>=0&&ni<N&&nj>=0&&nj<M) {
        		 tmp=pos[1];
        		 if(k==1){// 동
        			 pos[1]=pos[3];
        			 pos[3]=pos[6];
        			 pos[6]=pos[4];
        			 pos[4]=tmp;
        		 }else if(k==2) { //서
        			 pos[1]=pos[4];
        			 pos[4]=pos[6];
        			 pos[6]=pos[3];
        			 pos[3]=tmp;
        		 }else if(k==3) {//북
        			 pos[1]=pos[2];
        			 pos[2]=pos[6];
        			 pos[6]=pos[5];
        			 pos[5]=tmp;
        		 }else {//남
        			 pos[1]=pos[5];
        			 pos[5]=pos[6];
        			 pos[6]=pos[2];
        			 pos[2]=tmp;
        		 }
        		 //pos[1]이 바닥위치.
        		 if(map[ni][nj]!=0) {
        			 dice[pos[1]]=map[ni][nj];
        			 map[ni][nj]=0;
        		 }else {// 지도 칸이 0이면 주사위 바닥이 복사
        			 map[ni][nj]=dice[pos[1]];
        		 }
        		 X=ni;
        		 Y=nj;
        		 sb.append(dice[7-pos[1]]+"\n");
        	 }else {
        		 continue;
        	 }
        	
        }
        
        System.out.println(sb);
    }
}
