
import java.util.*;
import java.io.*;

public class Main {

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //양면에 양의 정수가 적힘 카드 N장. -> 필요 없는 조건
        //처음에는 모두 앞면. 왼쪽에서부터 숫자가 주어짐.
        //규칙에 따라 카드 뭉치를 나누어 여러 뭉치로 만든다.
        /*
         * 1. 뭉치를 나눌 땐 연속된 구간 단위로 분할한다.
         * 2. 카드 뭉치 내 카드의 순서는 바꿀 수 없다.
         * 3. 카드 뭉치에 속한 카드의 개수는 카드 뭉치의 가장 왼쪽에 있는 수보다 작거나 같아야 한다.
         * 모든 카드는 정확히 하나의 카드 뭉치에 속해야 한다.
         * */
        //위의 규칙을 모두 만족하면서 카드 뭉치의 개수가 최소가 되도록 나눳을 때 개수를 구하라.
        
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] card=new int[N+1];
        
        for(int i=1;i<=N;i++){
        	card[i]=Integer.parseInt(st.nextToken());
        }
        
        int[] dp=new int[N+1];//i번째 카드까지 생길 수 있는 카드뭉치 수
    	
        for(int i=1;i<=N;i++){
        	dp[i]=N;
        }
        
        
        for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if (i - j + 1 <= card[j]) {
    				dp[i] = Math.min(dp[i], dp[j - 1] + 1);
    			}
    		}
    	}
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
        
    }
        
}


