
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};

	public static int[] hi=new int[] {-1,-2,-2,-1, 1,2, 2, 1};
	public static int[] hj=new int[] {-2,-1, 1,2, 2,1,-1,-2};
		
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int W=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());
        
        int[][] map=new int[H][W];
        int[][] v=new int[H][W];

        
        for(int i=0;i<H;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<W;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		v[i][j]=Integer.MAX_VALUE;
        	}
        }
        
        //ArrayDeque<int[]> pq=new ArrayDeque<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
        	
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[3]-o2[3];
        	}
        	
        });
        

        int[] p;
        int ni,nj;
        int answer=-1;
        
        pq.add(new int[] {0,0,0,0});// 0,0 에서 시작. 점프횟수 0, 이동 횟수 0
        
        v[0][0]=0;// 0,0 좌표는 한번도 점프 안해서 올 수 있다.
        while(!pq.isEmpty()){
        	p=pq.poll();
        	if(p[0]==H-1&&p[1]==W-1) {
        		answer=p[3];
        		break;
        	}
        	//System.out.println(p[0]+" "+p[1]);
        	for(int a=0;a<4;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		if(ni>=0&&ni<H&&nj>=0&&nj<W&&map[ni][nj]!=1&&v[ni][nj]>p[2]) {
        			v[ni][nj]=p[2];// 인접 이동이니 점프는 안함.
        			pq.add(new int[] {ni,nj,p[2],p[3]+1});//다음 좌표 및 이동 위치
        		}
        	}
        	
        	
        	if(p[2]<K) {
            	for(int a=0;a<8;a++) {
            		ni=p[0]+hi[a];
            		nj=p[1]+hj[a];
//            		if(p[0]==1&&p[1]==1&&a==3) {
//            			System.out.println((ni>=0)+" "+(ni<H)+" "+(nj>=0)+" "+(nj<W)+" "+" "+ni+" "+nj);
//            		}
            		if(ni>=0&&ni<H&&nj>=0&&nj<W&&map[ni][nj]!=1&&v[ni][nj]>p[2]+1) {
            			v[ni][nj]=p[2]+1;
            			pq.add(new int[] {ni,nj,p[2]+1,p[3]+1});
            		}
            	}
        	}
        	
        }
//        for(int[] vv:v) {
//        	System.out.println(Arrays.toString(vv));
//        }
        
        System.out.println(answer);
        
    }
}
