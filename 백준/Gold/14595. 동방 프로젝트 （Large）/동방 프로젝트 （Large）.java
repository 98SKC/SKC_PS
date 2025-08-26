
import java.util.*;
import java.io.*;

public class Main{
	public static int[] wall;
	public static int[] next;
	public static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        //N개의 방이 일렬로 1번부터 N까지.
        // x<y를 만족하는 두 방에 대해 그 사이의 모든 벽을 허물어 하나의 방으로 합친다.
        //1번방 왼쪽과 N번반 오른쪽은 허물지 않는다.
        
        //x,y가 M개의 줄에 걸쳐 주어질 때, 남아있는 방의 개수를 구하라.
        
        //벽을 0 1 2 3 4 5 6이라고 하면 방은 6개. 
        wall=new int[N+1];
        //방의 개수는, 남아있는 벽의 개수 -1
        
        next=new int[N+1];
        for(int i=0;i<=N;i++) {
        	next[i]=i;
        }
        
        int x,y,nj;
        
        //0 1 2 3 4 5   벽 
        // 1 2 3 4 5    방
        //    3 5 방을 합친다.   3,4를 허문다.  2번벽 다음은 5번이다.
        
        int removed = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int j = find(x);
            while (j < y) {
                // j번 벽을 '허문다'= 이 포인트로 오면 오른쪽의 벽으로 간다 = j를 j+1로 연결
                nj = find(j + 1);
                if (next[j] == j) removed++;//음 허무는 경우에만 카운트
                next[j] = nj;//skip 
                j = next[j];
            }
        }

        // 남은 방 = N - 허문 벽 수
        System.out.println(N - removed);
        
    }
    
    
    public static int find(int a) {
        if (next[a] == a) return a;
        return next[a] = find(next[a]); // 경로 압축
    }
}
