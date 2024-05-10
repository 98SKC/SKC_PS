import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, answer;
        String str1, str2;
        for (int t = 0; t < T; t++) {
            answer = 1;
            map.clear(); // 각 테스트 케이스마다 맵을 초기화
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                str1 = st.nextToken();
                str2 = st.nextToken();
                map.put(str2, map.getOrDefault(str2, 0) + 1);
            }
            
            for (int count : map.values()) {
                answer *= count + 1;
            }
            answer -= 1;
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}