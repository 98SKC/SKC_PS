import java.util.*;
import java.io.*;
public class Solution 
//(0,0)~(i,j)의 누적합
{
    public static void main(String args[]) throws Exception
    {
		//System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T=Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            int max=Integer.MIN_VALUE;
            int[][] prefixSum=new int[N+1][N+1];

            //누적합 배열 만들기.
            for(int i=1;i<=N;i++){
            	st=new StringTokenizer(br.readLine());
                for(int j=1;j<=N;j++){
                    prefixSum[i][j] = Integer.parseInt(st.nextToken()) + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i -1][j - 1];
                }
            }
            
            for(int i=1;i<=N-M+1;i++){
                for(int j=1;j<=N-M+1;j++){
                    int sum = prefixSum[i + M - 1][j + M - 1] - prefixSum[i + M - 1][j - 1] - prefixSum[i - 1][j + M - 1] + prefixSum[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }
     
            System.out.println("#"+test_case+" "+max);
        }
    }
}