import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] cnt = new int[1000];
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            sum %= m;
            answer += cnt[sum];
            cnt[sum]++;
            if (sum==0) answer++;
        }
        System.out.println(answer);
    }
}