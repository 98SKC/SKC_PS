
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        N=N+1;
        boolean[][] v=new boolean[N][N];
        boolean[][] possible=new boolean[N][N];
        int size=N*N;
        ArrayList<int[]>[] list=new ArrayList[size];
        for(int i=1;i<size;i++){
        	list[i]=new ArrayList<>();
        }
        int x,y,a,b;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	x=Integer.parseInt(st.nextToken());
        	y=Integer.parseInt(st.nextToken());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	//System.out.println("어디서 17이 나오는거에요?: "+size+" x: "+x+" y: "+y);
        	list[x*N+y].add(new int[] {a,b});
        }
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int[] pos;
        int pi,pj,ni,nj;
        int[] di=new int[] {0,1,0,-1};
        int[] dj=new int[] {1,0,-1,0};
        int answer=1;
        v[1][1]=true; 
        possible[1][1]=true;
        q.add(new int[] {1,1});

        while(!q.isEmpty()){
        	pos=q.poll();
        	pi=pos[0];
        	pj=pos[1];
        	//System.out.println("들어오는 순서는 어떻게 되는 거에요?: "+pi+" "+pj);
        	for(int[] button:list[pi*N+pj]) {
        		if(possible[button[0]][button[1]]) continue;
        		possible[button[0]][button[1]]=true;
            	for(int n=0;n<4;n++) {
            		ni=button[0]+di[n];
            		nj=button[1]+dj[n];
            		if(ni>0&&ni<N&&nj>0&&nj<N&&v[ni][nj]) {// 불 켜진 곳 주변에 방문한 곳이 있다면 방문
            			q.add(new int[] {button[0],button[1]});
            			v[button[0]][button[1]]=true;
            			break;
            		}
            	}
            	//System.out.println("어디 불이 안켜지는 거에요?: "+button[0]+" "+button[1]);
        		answer++;
        	}
        	
        	for(int n=0;n<4;n++) {
        		ni=pi+di[n];
        		nj=pj+dj[n];
        		//System.out.println("뭐가 4야: "+ni+" "+nj+" "+N);
        		if(ni>0&&ni<N&&nj>0&&nj<N&&possible[ni][nj]&&!v[ni][nj]) {
        			q.add(new int[] {ni,nj});
        			v[ni][nj]=true;
        		}
        				
        	}
        	
        	
        }
        System.out.println(answer);
    }
}
