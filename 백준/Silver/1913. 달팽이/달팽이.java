import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static int[] di=new int[] {1,0,-1,0};
	public static int[] dj=new int[] {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int goal=Integer.parseInt(br.readLine());
        
        int[][] map=new int[N][N];
        boolean[][] v=new boolean[N][N];
        
        int answer=0;
        int count=N*N;
        int pi=0;
        int pj=0;
        int dir=0;
        
        while(count>0) {
        	if(pi>=0&&pi<N&&pj>=0&&pj<N&&!v[pi][pj]) {
        		map[pi][pj]=count;
        		v[pi][pj]=true;
        		if(count==goal) answer=pi*N+pj;
        		count--;
        	}else{
        		pi-=di[dir];
        		pj-=dj[dir];
        		dir=(dir+1)%4;
        	}
    		pi+=di[dir];
    		pj+=dj[dir];
        	//System.out.println(pi+" "+pj);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		sb.append(map[i][j]+" ");
        		//System.out.print(map[i][j]+" ");
        	}
        	//System.out.println();
        	sb.append("\n");
        }
        sb.append((answer/N+1)+" "+(answer%N+1));
        
        System.out.println(sb);
    }
    
}