
import java.util.*;
import java.io.*;

public class Main {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        int N=Integer.parseInt(st.nextToken()); // 별똥별이 떨어지는 구역의 가로
        int M=Integer.parseInt(st.nextToken()); // 별똥별이 떨어지는 구역의 세로
        int L=Integer.parseInt(st.nextToken()); // 트램펄린의 한 변의 길이
        int K=Integer.parseInt(st.nextToken()); // 별똥별의 개수
        
        int[][] stars=new int[K][2];

        
        int x,y;
        int answer=0;
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine());
        	x=Integer.parseInt(st.nextToken());
        	y=Integer.parseInt(st.nextToken());
        	
        	stars[i][0]=x;
        	stars[i][1]=y;
        	
        }
        int cnt;
        for(int i=0;i<K;i++) {
        	x=stars[i][0];
        	for(int j=0;j<K;j++) {
        		y=stars[j][1];
        		cnt=0;
        		for(int[] s: stars) {
        			if(s[0]>=x&&s[0]<=x+L&&s[1]>=y&&s[1]<=y+L) cnt++;
        		}
        		answer=Math.max(answer, cnt);
        	}
        }
        
        
        System.out.println(K-answer);
        
    }
    

}
