import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String args[]) throws Exception
    {
         
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++){
            double sum=0;
            int answer=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            double size=st.countTokens();
     
            for(int i=0;i<size;i++) {
                sum+=Integer.parseInt(st.nextToken());
            }
            answer=(int)Math.round(sum/size);
             
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
 
        }
        System.out.println(sb);
    }
 
}