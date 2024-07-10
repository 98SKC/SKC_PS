import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

         Queue<long[]> q=new ArrayDeque<>();

         q.add(new long[]{A,1});
         long[] sub;
         long answer=-1;
         while(!q.isEmpty()){
            sub=q.poll();
            if(sub[0]==B){
                answer=sub[1];
                break;
            }
             if(sub[0]*2<=B) {
                 q.add(new long[]{sub[0] * 2, sub[1] + 1});
             }

             if(sub[0]*10+1<=B){
                 q.add(new long[]{sub[0]*10+1,sub[1]+1});
             }



         }
        System.out.println(answer);


    }

}
