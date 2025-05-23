
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[][] map=new int[N][M];
        int[][] presum=new int[N][M];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        presum[0][0]=map[0][0];
        int max=map[0][0];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                presum[i][j] = map[i][j];
                if (i > 0) presum[i][j] += presum[i - 1][j];
                if (j > 0) presum[i][j] += presum[i][j - 1];
                if (i > 0 && j > 0) presum[i][j] -= presum[i - 1][j - 1];
                max = Math.max(max, presum[i][j]);
            }
        }
        
        int len=N*M;
        int leftI,leftJ;
        int rightI,rightJ;
        
        
        int subSum;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                for (int i = a; i < N; i++) {
                    for (int j = b; j < M; j++) {
                        leftI = a;
                        leftJ = b;
                        rightI = i;
                        rightJ = j;
                        subSum = presum[rightI][rightJ];
                        if (leftI > 0) subSum -= presum[leftI - 1][rightJ];
                        if (leftJ > 0) subSum -= presum[rightI][leftJ - 1];
                        if (leftI > 0 && leftJ > 0) subSum += presum[leftI - 1][leftJ - 1];
                        max = Math.max(max, subSum);
                    }
                }
            }
        }

        
//        for(int[] p:presum) {
//        	System.out.println(Arrays.toString(p));
//        }
        System.out.println(max);
        
        
        //400 399 /2  
        
    }
}
