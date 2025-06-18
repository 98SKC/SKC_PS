
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());//팔찌 개수
        int M=Integer.parseInt(st.nextToken());//무게
        
        int[] weight=new int[N];
        int[] price=new int[N];
        int[] dp=new int[12881];
        
        int w,d;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	w=Integer.parseInt(st.nextToken());
        	d=Integer.parseInt(st.nextToken());
        	weight[i]=w;
        	price[i]=d;
        }
        

        //1차원 dp를 사용하는 경우, 무게는 최대 무게부터 고려해야 중첩이 없어진다.
        for(int i=0;i<N;i++) {//i 팔찌까지 고려하는 경우
            for (int j = M; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
            }
        }
        
        System.out.println(dp[M]);
        
        
        //N개의 팔찌에서 좋은 팔찌만을 선택함.
        //가중치와 선호도가 각각 w와 d로 주어짐.
        //한번만 사용 가능함.
        //무게가 M이하(12880) 이하의 팔찌만 착욕.
        
        
        
    }
}
