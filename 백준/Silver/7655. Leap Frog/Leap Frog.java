
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        while(true) {
            int N=Integer.parseInt(br.readLine());
            if(N==0) break;
            
            int answer=Integer.MAX_VALUE;
            int[] arr=new int[N];
            int[] v=new int[N];
            
            ArrayDeque<int[]> q=new ArrayDeque<>();
            HashSet<Long> visit=new HashSet<>();
            
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
                v[i]=Integer.MAX_VALUE;
            }
            
            q.add(new int[] {0,1,0});
            visit.add(((long)0<<32)|1);
            
            int[] p;
            while(!q.isEmpty()) {
                p=q.poll();
                
                int f=p[0];
                int b=p[1];
                int c=p[2];
                
                if(b==N-1) {
                    answer=c;
                    break;
                }
                
                for(int i=b+1;i<N;i++) {
                    if(arr[i]<=arr[f]+10){
                        long key=((long)b<<32)|i;
                        if(!visit.contains(key)){
                            visit.add(key);
                            q.add(new int[] {b, i, c+1});
                        }
                    }
                    else break;
                }
            }
            
            if(answer==Integer.MAX_VALUE) answer=-1;
            sb.append(answer+"\n");
        }
        
        System.out.println(sb);
    }
}