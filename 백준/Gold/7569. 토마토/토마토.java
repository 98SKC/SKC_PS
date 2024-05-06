import java.util.*;
import java.io.*;

public class Main {

	static int[] dh=new int[] {0,0,0,0,1,-1};
	static int[] di=new int[] {0,1,0,-1,0,0};
	static int[] dj=new int[] {1,0,-1,0,0,0};

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M,N,H;
        
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        int[][][] map=new int[H][N][M];
        
        int tomato=0;
        Queue<int[]> q=new ArrayDeque<int[]>();
        for(int h=0;h<H;h++) {
        	for(int i=0;i<N;i++){
        		st=new StringTokenizer(br.readLine());
        		for(int j=0;j<M;j++) {
            		map[h][i][j]=Integer.parseInt(st.nextToken());
            		if(map[h][i][j]==0) {
            			tomato++;//다 익어야 하는 토마토 개수
            		}else if(map[h][i][j]==1) {
            			//System.out.println("처음 익어있는 토마토 위치: "+h+" "+i+" "+j+" ");
            			q.add(new int[]{h,i,j});
            		}
            	}
            }
        }
        int check,nh,ni,nj;
        int[] pos;
        int answer=0;
      //  System.out.println("처음 q사이즈 "+q.size());
        
        if(tomato==0) q.clear();
        while(!q.isEmpty()) {
        	check=q.size();
        	answer++;
    		int before=tomato;
        	for(int i=0;i<check;i++) {
            	pos=q.poll();
            	//System.out.println("익은 토마토 위치 h i j "+pos[0]+" "+pos[1]+" "+pos[2]+" ");
            	for(int a=0;a<6;a++) {
            		nh=pos[0]+dh[a];
            		ni=pos[1]+di[a];
            		nj=pos[2]+dj[a];
            		//System.out.println("확인 할 위치 h i j "+nh+" "+ni+" "+nj+" ");
            		
            		
            		if(nh>=0&&nh<H&&ni>=0&&ni<N&&nj>=0&&nj<M&&map[nh][ni][nj]==0) {
            			map[nh][ni][nj]=1;
            			q.add(new int[] {nh,ni,nj});
            			tomato--;
            		}
            		
            	}

        		if(tomato<=0) {
        			q.clear();
        			break;
        		}
            }
        	//System.out.println("새로 익은 토마토 수: "+(before-tomato));
        }
        
        //System.out.println("답 출력전:"+answer);
        
        
        if(tomato>0) {
        	System.out.println(-1);
        	return;
        }
        System.out.println(answer);
        
        
        
    }
}