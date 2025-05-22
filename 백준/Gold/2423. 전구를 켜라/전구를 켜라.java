
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {-1,-1,1,1};
	public static int[] dj=new int[] {-1,1,1,-1};
	public static int[] ci=new int[] {-1,-1,0,0};
	public static int[] cj=new int[] {-1,0,0,-1};
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String str;
        char[][] map=new char[N][M];
        int[][] min=new int[N+1][M+1];
        
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++) {
            	map[i][j]=str.charAt(j);
            }
        }
        for(int i=0;i<=N;i++) {
        	for(int j=0;j<=M;j++) {
            	min[i][j]=(N+1)*(M+1);
            }
        }
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[2], o2[2]);
        	}
        	
        });
        
        
        
        int[] p;
        min[0][0]=0;
        int ni,nj;
        int ai,aj;
        int cnt;
        pq.add(new int[] {0,0,min[0][0]});

        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(p[2] > min[p[0]][p[1]]) continue;

        	//System.out.println(p[0]+" "+p[1]+"방문");
        	for(int a=0;a<4;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		ai=p[0]+ci[a];
        		aj=p[1]+cj[a];
        		
        		if(ni>=0&&ni<=N&&nj>=0&&nj<=M){
        			//System.out.print("어디까지");
        			if(ai>=0&&ai<N&&aj>=0&&aj<M){//격자 내부
        				//System.out.println(" 들어는 온거니");
            			// 0 2 뱡향을 가려면 \ 모양. 1 3 방향을 가려면 / 모양
        				if(a%2==0) {// 0 2 뱡향을 가려면 \ 모양.
        					if(map[ai][aj]=='\\') {// 모양을 바꿀 필요가 없다.
        						cnt=p[2];
        					}else {
        						cnt=p[2]+1;
        					}
        					if(min[ni][nj]>cnt) {
        						pq.add(new int[] {ni,nj,cnt});
        						min[ni][nj]=cnt;
        					}
        				}else {// 1 3 방향을 가려면 / 모양
        					if(map[ai][aj]=='/') {// 모양을 바꿀 필요가 없다.
        						cnt=p[2];
        					}else {
        						cnt=p[2]+1;
        					}
        					if(min[ni][nj]>cnt) {
        						pq.add(new int[] {ni,nj,cnt});
        						min[ni][nj]=cnt;
        					}
        				}
            		}
        		}
        	//	System.out.println();
        		
        		
        	}
        	
        }
//        for(int[] m: min) {
//        	System.out.println(Arrays.toString(m));
//        }
        if(min[N][M]==(N+1)*(M+1)) {
        	System.out.println("NO SOLUTION");
        }else {
        	System.out.println(min[N][M]);        	
        }
        
        
        
    }
}
