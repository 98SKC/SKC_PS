import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] di=new int[]{0,1,0,-1};
    static int[] dj=new int[]{1,0,-1,0};

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int answer=-1;
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] map=new int[N][M];
        boolean[][] pv=new boolean[N][M];
        boolean[][] mv=new boolean[N][M];
        String sub;
        for(int i=0;i<N;i++){
            sub=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=sub.charAt(j)-'0';
            }
        }
        ArrayDeque<int[]> q=new ArrayDeque<>();


        q.add(new int[]{0,1});
        pv[0][0]=true;
        int pi,pj,p,ni,nj;
        int[] arr;
        while(!q.isEmpty()){
            arr=q.poll();
            p=arr[0];
            if(p>=0){// 아직 벽을 뚫을 수 있음
                pi=p/M;
                pj=p%M;
                if(pi==(N-1)&&pj==(M-1)){
                    answer=arr[1];
                    break;
                }
                for(int a=0;a<4;a++){
                    ni=pi+di[a];
                    nj=pj+dj[a];
                    if(ni>=0&&ni<N&&nj>=0&&nj<M){
                        if(map[ni][nj]==0&&!pv[ni][nj]){
                            q.add(new int[]{ni*M+nj,arr[1]+1});
                            pv[ni][nj]=true;
                        }else if(map[ni][nj]==1&&!mv[ni][nj]){
                            int next=ni*M+nj;
                            q.add(new int[]{-next,arr[1]+1});
                            mv[ni][nj]=true;
                        }
                    }
                }
            }else{// 이미 벽을 뚫고 옴
                p*=-1;
                pi=p/M;
                pj=p%M;
                if(pi==(N-1)&&pj==(M-1)){
                    answer=arr[1];
                    break;
                }
                for(int a=0;a<4;a++){
                    ni=pi+di[a];
                    nj=pj+dj[a];
                    if(ni>=0&&ni<N&&nj>=0&&nj<M&&!pv[ni][nj]&&!mv[ni][nj]){
                        if(map[ni][nj]==0){
                            q.add(new int[]{-(ni*M+nj),arr[1]+1});
                            mv[ni][nj]=true;
                        }
                    }
                }
            }

        }
        System.out.println(answer);

    }

}
