import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();	

        for(int i=1;i<=N;i++)
            dq.addLast(i);
        int count = 1;

        while(!dq.isEmpty()){
            if(count % 2 == 1)	
                bw.write(dq.pollFirst() + " ");		
            else{	
                int temp = dq.pollFirst();
                dq.addLast(temp);
            }
            count++;
        }
        bw.flush();		
        bw.close();
        br.close();
    }
}