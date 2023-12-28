import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {// 기본 배열 생성
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 각 회전 버전의 배열
            int[][] matrix90 = turn(matrix, N);
            int[][] matrix180 = turn(matrix90, N);
            int[][] matrix270 = turn(matrix180, N);

            // 출력부
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix270[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static int[][] turn(int[][] arr, int N) {
        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[j][N - 1 - i] = arr[i][j];
            }
        }
        return answer;
    }
}
