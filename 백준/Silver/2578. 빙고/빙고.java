
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=5;

        int[] col=new int[N]; //i열이 몇개 불렸는지
        int[] row=new int[N]; //i행이 몇개 불렸는지
        int ud=0;//상 하 대각선
        int du=0;//하 상 대각선
        int oper;
        HashMap<Integer, int[]> b=new HashMap<>();
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {

        		oper=Integer.parseInt(st.nextToken());
        		b.put(oper,new int[] {i,j});
            	
            }
        }
        
        int[] sub;
        
        int cnt=0;
        int line=0;
        int bingo=0;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		cnt++;
            	oper=Integer.parseInt(st.nextToken());
            	sub=b.get(oper);
            	col[sub[1]]++;
            	row[sub[0]]++;
                if (sub[1] == sub[0]) ud++;                
                if (sub[1] + sub[0] == N - 1) du++;      
                int newLines = 0;
                
                if (row[sub[0]] == 5) newLines++;
                if (col[sub[1]] == 5) newLines++;
                if (sub[0] == sub[1] && ud == 5) newLines++;
                if (sub[0] + sub[1] == 4 && du == 5) newLines++;

                bingo += newLines;
            	
                if (bingo >= 3) {
                    System.out.println(cnt); // 몇 번째 호출에서 3줄 완성됐는지
                    return;
                }
            	
        	}
        }
    }
        
}


