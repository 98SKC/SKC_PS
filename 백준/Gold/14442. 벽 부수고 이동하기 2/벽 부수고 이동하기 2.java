import java.util.*;
import java.io.*;

public class Main {

	
	static int[] di=new int[] {0,1,0,-1};
	static int[] dj=new int[] {1,0,-1,0};
	static int N,M,K;
	static int[][] map;
	static boolean[][][] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        map=new int[N+1][M+1];
        v=new boolean[N+1][M+1][K+1];// 하나더? //0,1은 각각 K를 소모해서 온적이 있는지.근데 K가 10이나 되요 최대
        String str;
        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
            	map[i][j]=str.charAt(j-1)-'0';
            }
        }
        
        Queue<int[]> q=new ArrayDeque<>();
        int ni,nj,pi,pj;
        int answer=-1;
        int[] pos;// 0-좌표 1뚫은 횟수 2 총 이동거리
        q.add(new int[] {(M+1)+1,0,1});
        v[1][1][0]=true;
        while(!q.isEmpty()) {
        	pos=q.poll();
        	
        	pi=pos[0]/(M+1);
        	pj=pos[0]%(M+1);
        	if(pi==N&&pj==M) {
        		answer=pos[2];
        		break;
        	}
        	
        	for(int a=0;a<4;a++) {
        		ni=pi+di[a];
        		nj=pj+dj[a];
        		if(ni>0&ni<=N&&nj>0&nj<=M) {//일단 지도 범위
        			if(map[ni][nj]==1&&pos[1]<K&&!v[ni][nj][pos[1]+1]) {
        				v[ni][nj][pos[1]+1]=true;
        				q.add(new int[] {ni*(M+1)+nj,pos[1]+1,pos[2]+1});
        			}else if(map[ni][nj]==0&&!v[ni][nj][pos[1]]) {
        				v[ni][nj][pos[1]]=true;
        				q.add(new int[] {ni*(M+1)+nj,pos[1],pos[2]+1});
        				
        			}
        		}
        	}
        }
        System.out.println(answer);
    }
    
    //아래 함수를 안쓰고, 그냥 같은 뚫기에서만 비교...하나?
    static boolean check(int pi,int pj,int a) {

    	for(int i=a;i>=0;i--) {
    		if(v[pi][pj][i]) return false;
    	}
    	
    	return true;
    }
    
    
}