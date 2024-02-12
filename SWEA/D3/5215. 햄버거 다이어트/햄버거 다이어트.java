import java.util.*;
import java.io.*;
 
 
public class Solution
{
    public static int[] value;
    public static int[] cal;
    public static int answer;
    public static int N;
    public static int max;
     
    public static void main(String args[]) throws Exception
    {
         
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            answer=0;
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            max=Integer.parseInt(st.nextToken());
            value = new int[N];
            cal = new int[N];
             
            for(int i=0;i<N;i++){
            	 st=new StringTokenizer(br.readLine());
                 value[i]=Integer.parseInt(st.nextToken());
                 cal[i]=Integer.parseInt(st.nextToken());
            }
            helper(0,0,0);
             
            sb.append("#").append(tc).append(" ").append(answer).append("\n"); 
            
        }
        System.out.println(sb);
 
    }
            public static void helper(int i, int calState, int valueState ){//포함했을때와 안했을 때           
                if(i==N){// 탐색 범위끝까지 가면
                    answer=Math.max(valueState,answer);
                    return;
                }
                 
                helper(i+1,calState,valueState);// 추가하지 않은 경우
                if(calState+cal[i]>max){
                    answer=Math.max(valueState,answer);
                    return;
                }else{
                    helper(i+1, calState+cal[i], valueState+value[i]);
                }
                 
        }
}