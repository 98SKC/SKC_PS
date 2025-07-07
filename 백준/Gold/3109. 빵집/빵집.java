
import java.util.*;
import java.io.*;

public class Main {
	
	
	public static int[] di=new int[] {-1,0,1};
	public static boolean[][] v;
	public static int R,C;
	public static char[][] map;
	public static int answer=0;
	
	

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        String str;
        map=new char[R][C];
        for(int r=0;r<R;r++) {
        	str=br.readLine();
        	for(int c=0;c<C;c++) {
        		map[r][c]=str.charAt(c);
        	}
        }
        

        int ni,nj;
        v=new boolean[R][C];
        for(int r=0;r<R;r++) {
        	if(dfs(r,0))answer++;
        }
        
        
        System.out.println(answer);
        
    }
    
    public static boolean dfs(int r, int c) {

        v[r][c] = true;
       
        if (c == C - 1) {
            return true;
        }
        
        for (int a = 0; a < 3; a++) {
            int ni = r + di[a];
            int nj = c + 1;
            if (ni >= 0 && ni < R && nj < C //맵 안쪽인가
                && map[ni][nj] != 'x' //벽이 아닌가
                && !v[ni][nj]) { //방문한적있냐
                if (dfs(ni, nj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
