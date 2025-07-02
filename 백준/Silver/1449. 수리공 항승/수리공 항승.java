import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 누수점 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프 길이
        
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int count = 1; // 첫 누수점부터 테이프 하나 붙인 상태
        int coverageEnd = arr[0] + L - 1;
        
        for (int i = 1; i < N; i++) {
            if (arr[i] > coverageEnd) {
                count++;
                coverageEnd = arr[i] + L - 1;
            }
        }
        
        System.out.println(count);
        bf.close();
    }
}
