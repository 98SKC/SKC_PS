import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] v;
    static int[] di=new int[]{0,1,0,-1};
    static int[] dj=new int[]{1,0,-1,0};
    static Queue<int[]> melt=new ArrayDeque<>();
    static Stack<Integer> start=new Stack<>();
    static int N,M;


    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0&&start.isEmpty()){
                    start.add(i*M+j);
                }
            }
        }
       // System.out.println("시작:"+start.peek());
        int turn=0;
        int pos,count;
        int s,check=0;
        while(check<2&&!start.isEmpty()){
            turn++;
            v=new boolean[N][M];
            check=0;
            s=start.pop();
            for(int i=s/M;i<N;i++){
                for(int j=s%M;j<M;j++){
                    if(map[i][j]==0||v[i][j]) continue;

                    bfs(i,j);
                }
            }
            for(int i=s/M+1;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0||v[i][j]) continue;

                    bfs(i,j);
                }
            }

            int[] sub;
            while(!melt.isEmpty()){
                sub=melt.poll();
                pos=sub[0];
                count=sub[1];
                map[pos/M][pos%M]=Math.max(0,map[pos/M][pos%M]-count);
            }
//            for(int[] a:map){
//                System.out.println(Arrays.toString(a));
//            }
//
//            System.out.println(!start.isEmpty());
//            System.out.println(check);
//            System.out.println("-------------------------------------");
            if(start.isEmpty()){
                turn=0;
                break;
            }
            s=start.peek();
            v=new boolean[N][M];
            for(int i=s/M;i<N;i++){
                for(int j=s%M;j<M;j++){
                    if(map[i][j]==0||v[i][j]) continue;
                    check++;
                    bfs2(i,j);
                }
            }
            for(int i=s/M+1;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0||v[i][j]) continue;
                    check++;
                    bfs2(i,j);
                }
            }

        }
        System.out.println(turn);


    }
    static void bfs(int i,int j){
        int pos,pi,pj,ni,nj,count;

        Queue<Integer> q=new ArrayDeque<>();
        q.add(i*M+j);
        v[i][j]=true;
        while(!q.isEmpty()){
            pos=q.poll();
            pi=pos/M;
            pj=pos%M;
            count=0;

            for(int a=0;a<4;a++){
                ni=pi+di[a];
                nj=pj+dj[a];
                if(ni>=0&&ni<N&&nj>=0&&nj<M){
                    if(map[ni][nj]==0) count++;
                    else if(map[ni][nj]!=0&&!v[ni][nj]){
                        v[ni][nj]=true;
                        if(start.isEmpty()||start.peek()>pos){
                            start.clear();
                            start.push(pos);
                        }

                        q.add(ni*M+nj);
                    }
                }
            }
            if(count!=0) {
                melt.offer(new int[]{pos, count});
            }

        }

    }
    static void bfs2(int i,int j){
        int pos,pi,pj,ni,nj;

        Queue<Integer> q=new ArrayDeque<>();
        q.add(i*M+j);
        v[i][j]=true;
        while(!q.isEmpty()){
            pos=q.poll();
            pi=pos/M;
            pj=pos%M;
            for(int a=0;a<4;a++){
                ni=pi+di[a];
                nj=pj+dj[a];
                if(ni>=0&&ni<N&&nj>=0&&nj<M){
                    if(map[ni][nj]!=0&&!v[ni][nj]){
                        v[ni][nj]=true;
                        q.add(ni*M+nj);
                    }
                }
            }
        }
    }

}
