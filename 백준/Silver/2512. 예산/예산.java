import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int CL = 0, CR = arr[N - 1], answer = 0;

        while (CL <= CR) {
            int Cmiddle = (CL + CR) / 2;
            long total = 0;

            
            
            for (int i = 0; i < N; i++) {
                if (arr[i] > Cmiddle) {
                    total += Cmiddle;
                } else {
                    total += arr[i];
                }
            }
            
            

            if (total <= M) { // 예산 범위 내
                answer = Cmiddle;
                CL = Cmiddle + 1;
            } else { // 예산을 초과하는 경우
                CR = Cmiddle - 1;
            }
        }

        System.out.println(answer);
    }
}