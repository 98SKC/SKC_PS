
import java.util.*;
import java.io.*;

public class Main{

	public static char[][] map;
	public static int[] di=new int[] {1,0,-1,0};//하 우 상 좌
	public static int[] dj=new int[] {0,1,0,-1};
	public static int N,M;
	public static boolean[][] v;
	public static int[] cnt=new int[] {0,0,0,0};
	public static boolean find=false;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        map=new char[N][M];
        v=new boolean[N][M];
        
        String str;
        
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j]=str.charAt(j);
            }
        }
        int ni,nj;
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(v[i][j]) continue;
        		v[i][j]=true;
        		dfs(map[i][j],i,j,i,j);
        		//System.out.println();
        		if(find) break;
            }
        	
        	if(find) break;
        }
        
        if(find) System.out.println("Yes");
        else System.out.println("No");
    }
    
    
    public static void dfs(char color, int bi, int bj, int pi, int pj) {

 	
//    	System.out.println("dir: "+pi+" "+pj);
//		for(boolean[] v:v) {
//			System.out.println(Arrays.toString(v));
//		}
//		System.out.println(bi+" "+bj+" "+pi+" "+pj);

    	if(find) return;
    	
    	int ni, nj;
    	for(int a=0;a<4;a++) {
    		ni=pi+di[a];
    		nj=pj+dj[a];
    		if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]==color){

    			//              이전 좌표랑 완전히 같은게 아니면
    			if(v[ni][nj]&&!(ni==bi&&nj==bj)){// 이전곳이 아닌데, 방문할 때
    				//System.out.println("하 "+bi+" "+bj+" "+ni+" "+nj+" "+pi+" "+pj+" "+a);
    				find=true;
    				return;
    			}else if(!v[ni][nj]){ //새로운 곳을 탐색
        	    	v[ni][nj]=true;
        	    	//System.out.println(bi+" "+bj+" "+ni+" "+nj+" "+pi+" "+pj+" "+a);
        			dfs(color, pi, pj, ni, nj);
    			}
    			
    		}
        	if(find) return;
    	}
    	
    }
        
}


