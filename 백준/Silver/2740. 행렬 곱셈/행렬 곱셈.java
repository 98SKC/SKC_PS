
import java.util.*;
import java.io.*;

public class Main{

	
	//행렬의 곱셈과 분할정복의 복습
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[][] A=new int[N][M];
        
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		A[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] B=new int[M][K];

        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<K;j++) {
        		B[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        // 행렬의 곱셈을 구현.
        // N*M 행렬과 M*K 행렬을 곱하면 그 크기는 N*k
        // M크기가 같아야 곱셈이 가능.
        int[][] answer=new int[N][K];
        
        

        int sum;
        for(int i=0;i<N;i++){
            for(int j=0;j<K;j++){
                sum=0;
                
                for(int p=0;p<M;p++){
                    sum+=A[i][p]*B[p][j];
                }
               
                answer[i][j]=sum;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
        	for(int j=0;j<K;j++) {
            	sb.append(answer[i][j]+" ");
            }
        	sb.append("\n");
        }
        
        
        System.out.println(sb);
        
    }
}
