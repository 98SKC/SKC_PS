
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        
        int[][] map=new int[R][C];
        int[][] dijk=new int[R][C];
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
            	dijk[i][j]=R*C;
            }
        }
        
        st=new StringTokenizer(br.readLine());
        //i==0
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[2], o2[2]);
        	}
        });
        
        for(int j=0;j<C;j++) {
        	//1만 시작이 가능하다.
        	map[0][j]=Integer.parseInt(st.nextToken());
        	if(map[0][j]==1){
        		dijk[0][j]=0;//시작이 가능
            	pq.add(new int[] {0,j,0});
        	}
        }
        
        for(int i=1;i<R;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<C;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
        		//1만 밟는다.
            }
        }
        
        int N=Integer.parseInt(br.readLine());//이동 가능한 규칙의 개수
        int[] di=new int[N];
        int[] dj=new int[N];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	di[i]=Integer.parseInt(st.nextToken());
        	dj[i]=Integer.parseInt(st.nextToken());
        }
        
        int ni,nj;
        int[] p;
        int answer=-1;

        while(!pq.isEmpty()){
        	
        	p=pq.poll();
        	if(p[0]==R-1){
        		answer=p[2];
        		break;
        	}
        	
        	for(int a=0;a<N;a++) {
        		ni=p[0]+di[a];
        		nj=p[1]+dj[a];
        		if(ni>=0&&ni<R&&nj>=0&&nj<C&&map[ni][nj]==1){
                			
        			if(dijk[ni][nj]>p[2]+1){
        				dijk[ni][nj]=p[2]+1;
        				pq.add(new int[] {ni,nj,dijk[ni][nj]});
        			}
        		}
        				
        	}
        	
        }
        
//        for(int[] m:dijk){
//        	System.out.println(Arrays.toString(m));
//        }
//        System.out.println();
        System.out.println(answer);
        //강남역에서 회사까지 보도블럭에 대해 규칙을 지켜가며 이동한다.
        //1. 세로 블록만 밟는다. (시작은 첫번째 row 중 세로 어디든 가능하다.)
        //2. 특정 규칙으로 이동한다.
        //3. 첫번째 row에서 마지막 row로 도착하면 출근에 성공
        //4. 최소한의 걸음으로 출근한다.
        
        
        
    }
        
}


