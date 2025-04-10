
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {-2,-2,-1,-1,2,2,1,1};//8칸
	public static int[] dj=new int[] {-1, 1,-2, 2,-1,1,-2,2};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int L;
        int[] p;
        //int[][] map;
        boolean[][] v;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int si,sj,ni,nj,gi,gj;
        int turn=-1;
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<=T;t++) {
        	//체스판크기
        	q.clear();
        	L=Integer.parseInt(br.readLine());
        	//map=new int[L][L];
        	v=new boolean[L][L];
        	//나이트의 위치
        	st=new StringTokenizer(br.readLine());
        	si=Integer.parseInt(st.nextToken());
        	sj=Integer.parseInt(st.nextToken());

        	//이동하려는 위치
        	st=new StringTokenizer(br.readLine());
        	gi=Integer.parseInt(st.nextToken());
        	gj=Integer.parseInt(st.nextToken());
        	
        	if(si==gi&&sj==gj) {
        		sb.append(0+"\n");
        		continue;
        	}
        	
        	v[si][sj]=true;
        	q.add(new int[] {si,sj,0});
        	turn=0;
        	
        	while(!q.isEmpty()) {
        		p=q.poll();
        		for(int a=0;a<8;a++) {
        			ni=p[0]+di[a];
        			nj=p[1]+dj[a];
        			if(ni>=0&&ni<L&&nj>=0&&nj<L&&!v[ni][nj]) {
        				if(ni==gi&&nj==gj) {
        					turn=p[2]+1;
        					break;
        				}
        				v[ni][nj]=true;
        				q.add(new int[] {ni,nj,p[2]+1});
        			}
        		}
        		if(turn!=0) break;
        	}
        	sb.append(turn+"\n");
        }
        System.out.println(sb);
        
        
    }
}
