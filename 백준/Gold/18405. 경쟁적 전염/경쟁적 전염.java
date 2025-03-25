
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] map=new int[N+1][N+1];
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[3]==o2[3]){//같은 시간대에 퍼진 바이러스라면 번호가 작은 순으로
        			return o1[2]-o2[2];  
        		}
        		return o1[3]-o2[3];
        	}
        });
        
        //ArrayDeque<int[]> q=new ArrayDeque<>();
        int[] di=new int[] {1,0,-1,0};
        int[] dj=new int[] {0,1,0,-1};
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            	if(map[i][j]!=0) pq.add(new int[] {i,j,map[i][j],0});
            }
        }
        
        st=new StringTokenizer(br.readLine());
        int S,X,Y;
        S=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        Y=Integer.parseInt(st.nextToken());
        
        int[] sub;
        //ArrayList<int[]> save=new ArrayList<>();
        int len,ni,nj;
        for(int s=1;s<=S;s++) {
        	len=pq.size();
        	for(int i=0;i<len;i++){
        		sub=pq.poll();// x, y, 번호, 시간
        		if(map[sub[0]][sub[1]]!=sub[2]) continue;
        		for(int a=0;a<4;a++){
        			ni=sub[0]+di[a];
        			nj=sub[1]+dj[a];
        			if(ni>0&&ni<=N&&nj>0&&nj<=N&&(map[ni][nj]==0)) {
        				map[ni][nj]=sub[2];
        				if(ni==X&&nj==Y) {
//        					for(int[] x:map) {
//        						System.out.println(Arrays.toString(x));
//        					}
//        					System.out.println("-----------");
        					System.out.println(sub[2]);
        					return;
        				}
        				pq.add(new int[] {ni,nj,sub[2],sub[3]+1});
        			}
        		}
        	} 	

        }
        
        System.out.println(map[X][Y]);
        
    }
}
