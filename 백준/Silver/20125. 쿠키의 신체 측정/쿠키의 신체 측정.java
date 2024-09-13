import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map;
    static int bx;
    static int by;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.valueOf(br.readLine());
        map=new boolean[n+2][n+2];
        //심장위치저장
        int x=0;
        int y=0;
        for(int i=1; i<=n; i++){
            String a=br.readLine();
            for(int j=1; j<=n; j++){
                char b=a.charAt(j-1);
                if(b=='*'){
                    map[i][j]=true;
                    if(x==0 && y==0){
                        x=j;
                        y=i;
                    }
                }
            }
        }
        y+=1;

        int leftA=l(-1,0,x,y);
        int rightA=l(1,0,x,y);
        int body=l(0,1,x,y);
        //body끝에서 저장된 좌표값을 저장하기.
        int tx=bx;
        int ty=by;
        int leftL=l(0,1,tx-1,ty)+1;
        int rightL=l(0,1,tx+1,ty)+1;
        bw.write(y+" "+x+"\n");
        bw.write(leftA+" "+rightA+" "+body+" "+leftL+" "+rightL);
        bw.flush();

    }
    public static int l(int x, int y, int tx, int ty){
        int temp=-1;
        while(true){
            if(!map[ty][tx]){
                break;
            }
            temp++;
            tx+=x;
            ty+=y;
        }
        bx=tx;
        by=ty;
        return temp;
    }


}