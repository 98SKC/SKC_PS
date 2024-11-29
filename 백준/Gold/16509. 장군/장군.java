import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {-3,-3, -2,2 ,3, 3, 2,-2};
	public static int[] dj=new int[] {-2, 2,  3,3 ,2,-2, -3,-3};
	
	public static int[] ci=new int[] {-1,-1, -1,1,  1,1,  1,-1};
	public static int[] cj=new int[] {-1, 1,  1,1, -1,1, -1,-1};// 상 우 하 좌
	
	
	public static int blueI=0;
	public static int blueJ=0;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int redI=Integer.parseInt(st.nextToken());
        int redJ=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        blueI=Integer.parseInt(st.nextToken());
        blueJ=Integer.parseInt(st.nextToken());
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int[][] map =new int[10][9];
        
        q.add(new int[] {redI,redJ,0});
        int[] sub;
        int pi,pj;
        int ni,nj;
        int count;
        map[redI][redJ]=-1;// 시작점
        while(!q.isEmpty()) {
        	sub=q.poll();
        	pi=sub[0];
        	pj=sub[1];
        	
        	count=sub[2]+1;
        	
        	for(int a=0;a<8;a++) {
        		ni=pi+di[a];
        		
        		nj=pj+dj[a];
        		
        		//System.out.println("a: "+a);
        		
        		if(ni>=0&&ni<10&&nj>=0&&nj<9&&map[ni][nj]==0&&check(pi,pj,a)) {
        			//if(check(pi,pj,a)) System.out.println("못감 "+a+"방향 "+ni+" "+nj+"   "+count);
        			map[ni][nj]=count;
        			q.add(new int[] {ni,nj,count});
        		}
        	}
        	
        	if(map[blueI][blueJ]!=0) break;
        }
//        for(int i=0;i<10;i++) {
//        	for(int j=0;j<9;j++) {
//        		System.out.print(map[i][j]+" ");
//        	}
//        	System.out.println();
//        }
        if(map[blueI][blueJ]==0) map[blueI][blueJ]=-1;
        
        System.out.println(map[blueI][blueJ]);
    }
    
    public static boolean check(int pi, int pj, int dir) {
        int ni = 0;
        int nj = 0;

        if (dir < 2) { // 상 방향 (위쪽)
            ni = pi - 1;
            nj = pj;
        } else if (dir < 4) { // 우 방향 (오른쪽)
            ni = pi;
            nj = pj + 1;
        } else if (dir < 6) { // 하 방향 (아래쪽)
            ni = pi + 1;
            nj = pj;
        } else { // 좌 방향 (왼쪽)
            ni = pi;
            nj = pj - 1;
        }
        for (int t = 0; t < 2; t++) {
            if (ni == blueI && nj == blueJ) { // 경로에 왕이 있는 경우
                return false;
            }
            ni += ci[dir];
            nj += cj[dir];
        }
        return true;
    }

    
}