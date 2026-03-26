
import java.io.*;
import java.util.*;

public class Main{

    public static int N,M;
//    public static int[] di=new int[]{0,1,-1};
//    public static int[] dj=new int[]{1,1,1};
    public static int[] di=new int[]{0,1,-1};
    public static int[] dj=new int[]{-1,-1,-1};
    public static char[][] map;
    public static int[][] max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //N, M의 격자. 당근이 곳곳에.
        //토끼 이동은 우측으로만. 우,우상,우하
        //최대한 많은 당근을 줍는다.
        //어떤 쪽문에 도착했을 때 반드시 탈출 안하고 더 이동해도 된다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        max=new int[N][M];


        //ArrayDeque<int[]> q=new ArrayDeque<>();
        
        int[] start=new int[2];
        ArrayList<int[]> list=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=line.charAt(j);
                if(map[i][j]=='R'){
                    //q.add(new int[]{i,j,0});
                	start[0]=i;
                	start[1]=j;
                }else if(map[i][j]=='O'){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        boolean[][] v=new boolean[N][M];
        
        v[start[0]][start[1]]=true;
        
        for(int j=start[1];j<M;j++){
            for(int i=0;i<N;i++){
            	
            	if(map[i][j]=='#') continue;
            	
                for(int a=0;a<3;a++) {
                	int ni=i+di[a];
                	int nj=j+dj[a];
                	
                	if(ni>=0&&ni<N&&nj>=0&&nj<M&&v[ni][nj]){
                		
                		v[i][j]=true;
                		max[i][j]=Math.max(max[i][j], max[ni][nj]+(map[i][j]=='C'?1:0));
                	}
                }
            }
        }
        
        int answer=0;
        int[] p;

//        while(!q.isEmpty()){
//            p=q.poll();
//
////            if(map[p[0]][p[1]]=='O'){
////                answer=Math.max(answer,max[p[0]][p[1]]);
////            }
//            
//            if(map[p[0]][p[1]]=='C'){
//                p[2]++;
//            }
//            
//            max[p[0]][p[1]]=Math.max(max[p[0]][p[1]],p[2]);
//            
//            for(int a=0;a<3;a++){
//                int ni=p[0]+di[a];
//                int nj=p[1]+dj[a];
//                if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]!='#'&&max[ni][nj]<=p[2]){
//                    q.add(new int[]{ni,nj,p[2]});
//                }
//            }
//
//        }

        
        boolean exit=false;
        for(int[] a:list){
        	if(v[a[0]][a[1]]) exit=true;
            answer=Math.max(answer,max[a[0]][a[1]]);
        }
        
        if(!exit) answer=-1;
        System.out.println(answer);
    }



}
