import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String road = br.readLine();

        int[][] presum = new int[N + 1][4];
        Map<String, Integer> countObject = new HashMap<>();
        countObject.put("0,0,0,0", 1); // 초기 상태를 맵에 저장 (빈 구간도 유효)

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            char c = road.charAt(i - 1);
            int sub = 0;
            
    		if(c=='T') {
    			sub=0;
    		}else if(c=='G'){
    			sub=1;
    		}else if(c=='F') {
    			sub=2;
    		}else {
    			sub=3;
    		}

            // 누적합 갱신
            presum[i][0] = presum[i - 1][0];
            presum[i][1] = presum[i - 1][1];
            presum[i][2] = presum[i - 1][2];
            presum[i][3] = presum[i - 1][3];
            presum[i][sub]++;

            // 각 원소별 3으로 나눈 나머지를 계산
            int mod0 = presum[i][0] % 3;
            int mod1 = presum[i][1] % 3;
            int mod2 = presum[i][2] % 3;
            int mod3 = presum[i][3] % 3;

            // 해시맵에서 동일한 (mod0, mod1, mod2, mod3) 상태를 찾는다. 
            String key = mod0 + "," + mod1 + "," + mod2 + "," + mod3;
            answer += countObject.getOrDefault(key, 0);

            // 현재 상태를 해시맵에 저장
            countObject.put(key, countObject.getOrDefault(key, 0) + 1);
        }

        System.out.println(answer);
    }
}