import java.util.*;
import java.io.*;
public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int NUMBER_OF_TESTCASE = Integer.parseInt(br.readLine());
        for(int i=0;i<NUMBER_OF_TESTCASE;i++) {
            int trans0Count = 0,
                trans1Count = 0;
            
            st = new StringTokenizer(br.readLine());
            String num1 = st.nextToken(),
                   num2 = st.nextToken();
            
            for(int k=0;k<num1.length();k++) {
                if(num1.charAt(k) != num2.charAt(k)) {
                    if(num1.charAt(k) == '1') trans0Count++;
                    else trans1Count++;
                }
            }
            
            if(trans0Count >= trans1Count) sb.append(trans0Count); 
            else sb.append(trans1Count);
            
            sb.append("\n"); 
            
        }
        
        
        bw.write(sb.toString());
        
        bw.flush();
        br.close();
        bw.close();
        
    }

    
}