
import java.util.*;
import java.io.*;

public class Main{

	public static int N,M;
	public static int[] di=new int[] {1,0,-1,0};
	public static int[] dj=new int[] {0,-1,0,1};
    public static char[][] map;
    public static boolean[][] v;
    
    public static int min;
    public static int total;// 지나야 하는 총 칸의 수
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
		String input="";
		StringTokenizer st;
		int turn=1;
		while((input=br.readLine())!=null){
			if (input.isEmpty()) break;
			st=new StringTokenizer(input);
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			min=Integer.MAX_VALUE;
			total=0;
			map=new char[N][M];
			v=new boolean[N][M];
        	for(int i=0;i<N;i++) {
        		//input=br.readLine();
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
        		for(int j=0;j<M;j++) {
        			map[i][j]=tmp.charAt(j);
        			if(map[i][j]=='.') {
        				total++;
        			}
        		}
        	}
        	if(total==1) {
        		sb.append("Case "+turn+": "+0+"\n");
        		turn++;
        		continue;
        	} 
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			if(map[i][j]=='.') {
        				for(int a=0;a<4;a++) {
        					back(i,j,a,1,1);
        				}
        			}
        		}
        	}
			
			if(min==Integer.MAX_VALUE) {
				min=-1;
			}
			sb.append("Case "+turn+": "+min+"\n");
			turn++;
        }
		
		System.out.println(sb);
        
        
    }
    
    public static void back(int pi, int pj,int dir, int turn,int count) {
    	
    	if(turn>=min)return;
    	if(count==total) {
    		min=Math.min(min, turn);
    		return;
    	}
    	//System.out.println("왜 무한: "+pi+" "+pj);
    	
    	v[pi][pj]=true;
    	int ni=pi+di[dir];
    	int nj=pj+dj[dir];
    	if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!='*'&&!v[ni][nj]) {//방향 그대로 갈 수 있다면
    		back(ni,nj,dir,turn,count+1);
    	}else{//그대로 갈 수 없다면
    		for(int a=0;a<4;a++) {
				ni=pi+di[a];
				nj=pj+dj[a];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!='*'&&!v[ni][nj]) {
					back(ni,nj,a,turn+1,count+1);
				}
			}
    	}
    	v[pi][pj]=false;
    }
    
    
    
}
