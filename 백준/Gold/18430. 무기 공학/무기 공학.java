
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static boolean[][] v;
	public static int[] di=new int[] {0,1,   0,-1, 0,-1, 1,0};//
	public static int[] dj=new int[] {-1,0, -1,0,  1,0,  0,1};
	
	public static int N,M;
	public static int answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        v=new boolean[N][M];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(answer);
        
        
    }
    
    /**
     * 
     * @param pi 좌표의 압축
     */
    public static void dfs(int p, int sum) {
    	if(p>=N*M) {
    		//System.out.println("후보: "+sum);
    		answer=Math.max(answer, sum);
    		return;
    	}
    	if(v[p/M][p%M]) {
    		dfs(p+1,sum);
    		return;
    	} 
    	int ni1,nj1,ni2,nj2;
    	int pi=p/M;
    	int pj=p%M;
    	
    	//01  23  45  67
    	//해당 위치를 중심점으로 사용함.
    	//System.out.println("중심좌표: "+p);
    	for(int a=0;a<8;a=a+2) {
    		
    		ni1=pi+di[a];
    		nj1=pj+dj[a];
    		ni2=pi+di[a+1];
    		nj2=pj+dj[a+1];
    		//System.out.println("확장좌표: "+ni1+" "+nj1+" "+ni2+" "+nj2);
    		//System.out.println(pi+" "+pj+" "+check(ni1,nj1)+" "+check(ni2,nj2)+" "+ni1+" "+nj1+" "+ni2+" "+nj2);
    		if(check(ni1,nj1)&&check(ni2,nj2)){

    			v[pi][pj]=true;
    			v[ni1][nj1]=true;
    			v[ni2][nj2]=true;  	
    			//System.out.println(pi+" "+pj+"가 중앙. "+a+"모양. 점수: "+(map[pi][pj]*2+map[ni1][nj1]+map[ni2][nj2]));
    			//System.out.println(map[pi][pj]*2+" "+map[ni1][nj1]+" "+map[ni2][nj2]);
    			dfs(p+1,sum+map[pi][pj]*2+map[ni1][nj1]+map[ni2][nj2]);
    			v[pi][pj]=false;
    			v[ni1][nj1]=false;
    			v[ni2][nj2]=false;
    		}
    	}
    	//해당 위치를 중심점으로 사용하지 아니함
    	dfs(p+1,sum);
    	
    }
    
    
    public static boolean check(int ni, int nj) {
    	if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]) {
    		return true;
    	}
    	return false;
    	
    }
}
