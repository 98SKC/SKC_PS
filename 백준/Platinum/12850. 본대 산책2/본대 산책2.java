
import java.util.*;
import java.io.*;

public class Main {

	final public static int[][] map=new int[8][8];
	public static int MOD;
	public static long D;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        D=Long.parseLong(br.readLine());
        MOD=1000000007;
        //정해져있는 맵. 
        map[0][1]=map[0][7]=
        map[1][0]=map[1][7]=map[1][2]=
        map[2][1]=map[2][7]=map[2][6]=map[2][3]=
        map[3][2]=map[3][6]=map[3][4]=
        map[4][3]=map[4][5]=
        map[5][4]=map[5][6]=
        map[6][2]=map[6][3]=map[6][5]=map[6][7]=
        map[7][0]=map[7][1]=map[7][2]=map[7][6]=1;
        
        long[][] answer=new long[8][8];
        for(int i=0;i<8;i++) {
        	for(int j=0;j<8;j++) {
        		answer[i][j]=map[i][j];
        	}
        }
        
        // 건물에서 인접한 건물로 이동하는데 1분 소요.
        // 총 D분만 산책. D분 때 정보 과학관에 도착해야한다.
        // 가능한 경로의 수를 구하라.
        // 가능한 경로의 수를 1000000007으로 나눈 나머지를 출력한다.
        
        // 입력값은 D 단 하나. 
        
        //행렬의 거듭제곱, 분할 정복을 이용한 수학개념이 사용된다.
        //행렬의 제곱 == 같은 행렬의 곱
        //행렬의 곱셈 법칙
        //Z[i][j]=(시그마 t=0~n-1)X[i][t]*Y[t][j]
        
        //이 문제에 대입하면 X[i][t]*X[t][j] 형식인데, 이는 i에서 t까지 가는 경로 수 * t에서 j까지 가는 경로 수.
        //즉 i에서 i까지 가는 모든 경로의 합.
        //X^K[i][i]는 i에서i까지 k번 걸읆으로 가는 경로의 수가된다.
        
        int[][] result = power(map, D);
        System.out.println(result[0][0]);
        
    }
    //분할정복. 매번 A, A*A, A*A*A, A*A*A*A를 실행하려면 오래걸림.
    //또 A*A*A*A*A 를 구할 때, 이미 구해져있는 A*A*A*A에 A를 곱하지 못함. A*A*A*A 행렬을 저장해 두는게 아니기 떄문.
    //때문에 분할정복을 적용.
    public static int[][] power(int[][] A, long k) {

        if (k == 1) return A;

        int[][] half = power(A, k / 2);
        int[][] result = multiply(half, half);

        if (k % 2 == 1) {
            result = multiply(result, A);
        }

        return result;

    }


    public static int[][] multiply(int[][] X, int[][] Y) {

    	int N=8;
        int[][] Z = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int t = 0; t < N; t++) {
                    sum += 1L * X[i][t] * Y[t][j];
                }
                Z[i][j] = (int)(sum % MOD);
            }
        }

        return Z;
    }
}
