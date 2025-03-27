
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String str;

        
        char[][] map=new char[N][M];
        int[] di=new int[] {-1,1,0,0};//U,D,L,R
        int[] dj=new int[] {0,0,-1,1};
        char[] dir=new char[] {'D','U','R','L'};
        boolean[][] v=new boolean[N][M];
        
        
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j]=str.charAt(j);
        	}
        }
        ArrayDeque<int[]> q=new ArrayDeque<>();
        ArrayDeque<int[]> reverse=new ArrayDeque<>();//이 경로로 들어올 수 있는 곳
        boolean cycle;
        int[] pos;
        int pi,pj;
        int ni,nj;
        int bi,bj;
        int answer=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(!v[i][j]) {
        			q.add(new int[] {i,j});
            		while(!q.isEmpty()) {
            			cycle=true;
            			pos=q.poll();
            			pi=pos[0];
            			pj=pos[1];
            			v[pi][pj]=true;
            			if(map[pi][pj]=='U'){
            				ni=pi-1;
            				nj=pj;
            			}else if(map[pi][pj]=='D') {
            				ni=pi+1;
            				nj=pj;
            			}else if(map[pi][pj]=='L') {
            				ni=pi;
            				nj=pj-1;
            			}else{
            				ni=pi;
            				nj=pj+1;
            			}
            			for(int a=0;a<4;a++) {
            				bi=pi+di[a];
            				bj=pj+dj[a];
            				if(bi>=0&&bi<N&&bj>=0&&bj<M) {
                				if(map[bi][bj]==dir[a]&&!v[bi][bj]){//이곳으로 올 수 있는 칸
                					reverse.add(new int[] {bi,bj});
                					v[bi][bj]=true;
                				} 
            				}
            			}
            			
            			if(v[ni][nj]) {
            				answer++;
            				break;
            			}else {
            				q.add(new int[] {ni,nj});
            			}
            		}
            		while(!reverse.isEmpty()) {
            			pos=reverse.poll();
            			pi=pos[0];
            			pj=pos[1];
            			for(int a=0;a<4;a++) {
            				bi=pi+di[a];
            				bj=pj+dj[a];
            				if(bi>=0&&bi<N&&bj>=0&&bj<M) {
                				if(map[bi][bj]==dir[a]&&!v[bi][bj]){//이곳으로 올 수 있는 칸
                					reverse.add(new int[] {bi,bj});
                					v[bi][bj]=true;
                				} 
            				}
            			}
            		}
//            		System.out.println(i+" "+j+" 반복");
//            		for(boolean[] vv:v) {
//            			System.out.println(Arrays.toString(vv));
//            		}
//            		System.out.println("---------------------------------");
        		}

        	}
        }
        System.out.println(answer);
   
    }
}
