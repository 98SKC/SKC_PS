
import java.util.*;
import java.io.*;

public class Main{

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M=Integer.parseInt(st.nextToken());// 높이
        int N=Integer.parseInt(st.nextToken());// 너비
        int K=Integer.parseInt(st.nextToken());// 직사각형 개수
        
        boolean[][] map=new boolean[M][N];
        int x1,y1,x2,y2;
        for(int k=0;k<K;k++){
        	st=new StringTokenizer(br.readLine());
        	x1=Integer.parseInt(st.nextToken());
        	y1=Integer.parseInt(st.nextToken());
        	x2=Integer.parseInt(st.nextToken());
        	y2=Integer.parseInt(st.nextToken());
        	
        	for(int i=y1;i<y2;i++) {
        		for(int j=x1;j<x2;j++) {
        			map[i][j]=true;
        		}
        	}
        }
        int answer=0;
        int[] pos;
        int ni,nj;
        int[] di=new int[] {0,1,0,-1};
        int[] dj=new int[] {1,0,-1,0};
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        int count=0;
        ArrayList<Integer> list=new ArrayList<>(); 
        for(int i=0;i<M;i++) {
        	for(int j=0;j<N;j++) {
        		if(map[i][j]) continue;
        		q.add(new int[]{i,j});
        		map[i][j]=true;
        		count=0;
        		while(!q.isEmpty()) {
        			pos=q.poll();
        			count++;
        			for(int a=0;a<4;a++) {
            			ni=pos[0]+di[a];
            			nj=pos[1]+dj[a];
            			if(ni>=0&&ni<M&&nj>=0&&nj<N&&!map[ni][nj]) {
            				q.add(new int[] {ni,nj});
            				map[ni][nj]=true;
            			}
        			}
        			
        		}
        		list.add(count);
        		answer++;
        	}
        }
        Collections.sort(list);
        sb.append(answer+"\n");
        for(Integer n:list) {
        	sb.append(n+" ");
        }

        System.out.println(sb);
        
    }
}
