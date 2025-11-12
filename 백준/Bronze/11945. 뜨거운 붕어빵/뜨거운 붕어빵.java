
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        //주어진 붕어빵을 반전시키는 문제
        //붕어빵이 N*M 크기의 행렬로 주어진다.
        //반전시켜 출력하라
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] map=new int[N][M];
        String str;
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j]=str.charAt(j)-'0';
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        
        for(int i=0;i<N;i++) {
        	for(int j=M-1;j>=0;j--) {
        		sb.append(map[i][j]);
            }
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
        
}


