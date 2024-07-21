import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        Queue<Integer> q=new ArrayDeque<Integer>();
        int cnt=0;
        int[] v=new int[100001];
        int sub;
        int next;
        q.add(N);
        v[N]=0;
        int[] cal=new int[] {1,-1,2};
        while(!q.isEmpty()) {
            sub=q.poll();
            
            if (N==K) {
                cnt++;
                break; // 수빈이와 동생의 위치가 같다면 cnt 1, 종료
            }
            
            
            for(int i=0;i<3;i++) {
                if(i<2) next=sub+cal[i];
                else next=sub*cal[2];
                
                if(next<0||next>100000||(v[next]!=0&&v[next]<v[sub]+1)) continue;
                v[next]=v[sub]+1;
                q.add(next);
                if (next == K) cnt ++; 
            }
            
        }
        
        System.out.println(v[K]);
        System.out.println(cnt);
        
        
    }
}