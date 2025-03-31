
import java.util.*;
import java.io.*;

public class Main{

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String str;
        boolean[][] map=new boolean[N][M];
        
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++){
        		if((str.charAt(j)-'0')==0) {
        			map[i][j]=true;// 0이다. 벽이 아니다.
        		}
        	}
        }
        
        HashMap<Integer,Integer> hash=new HashMap<>();
        boolean[][] v=new boolean[N][M];
        int[][] number=new int[N][M];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int[] sub;
        int num=1;
        int count;
        int ni,nj;
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++){
        		if(map[i][j]&&!v[i][j]){//0이면(벽이 아닌 곳이면), 방문하지 않았으면
        			q.add(new int[] {i,j});
        			v[i][j]=true;
        			count=0;
        			while(!q.isEmpty()){
        				sub=q.poll();
        				number[sub[0]][sub[1]]=num;
        				count++;
        				for(int a=0;a<4;a++) {
        					ni=sub[0]+di[a];
        					nj=sub[1]+dj[a];
        					if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]&&!v[ni][nj]) {
        						v[ni][nj]=true;
        						q.add(new int[] {ni,nj});
        					}
        				}
        			}
        			hash.put(num, count);
        			num++;
        		}
        	}
        }
        HashSet<Integer> set=new HashSet<>();
        int[][] answer=new int[N][M];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++){
        		if(!map[i][j]){
        			set.clear();
        			
        			for(int a=0;a<4;a++) {
    					ni=i+di[a];
    					nj=j+dj[a];
    					if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]) {
    						set.add(number[ni][nj]);
    					}
    				}
        			for(int key:set) {
        				answer[i][j]+=hash.get(key);
        			}
        			answer[i][j]+=1;
        		}
        	}
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++){
        		sb.append(answer[i][j]%10);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);

    }
}
