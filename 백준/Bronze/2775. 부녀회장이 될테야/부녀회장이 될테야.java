import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[15][15];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 14; i++) {
            arr[0][i] = i;  //0층 i호에는 무조건 i명이 산다
        }

        
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n]).append("\n");  //k층 n호에 있는 사람 수 출력
        } 
        
        System.out.print(sb);
    }
}