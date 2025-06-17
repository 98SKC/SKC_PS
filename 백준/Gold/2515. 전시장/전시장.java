
import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        
        int h,c;
        int[] dp=new int[20000001];
        int[] p=new int[20000001];
        int max=0;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	h=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	
        	p[h]=Math.max(p[h], c);//h높이의 그림의 값
        	max=Math.max(max, h);
        }
        
        
        for(int i=1;i<=max;i++) {
        	if(i-S>=0){
        		dp[i]=Math.max(dp[i-S]+p[i],dp[i-1]);
        	}
        }
        System.out.println(dp[max]);
        
        
        
        
        //직사각형의 그림들. 높이는 다를 수 있지만 폭은 모두 같다
        //각 그림에는 가격이 매겨짐
        //보이는 부분의 세로 길이가 특정 정수 S이상인 그림만 구매한다.
        //그림의 높이와 가격이 주어질 때 판매 가능 그림들의 가격의 합이 최대 합을 구하라
        
        
        //눈에 보이는 그림이 많다 -> 최장 증가 부분 수열
        //근데 앞 그림과의 차이가 S 이상 이어야 한다.
        //+ 보이는 그림의 가격이 다 다른것도 문제
        
        // 완탐은 되는가? -> 그림 개수가 30만, 조합을 완탐하는 것은 불가. dp와 백트래킹?
        //정렬 후 dp[i]까지 고려할 경우 최대 값을 dp에 저장.

           
    }
}
