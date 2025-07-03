
import java.util.*;
import java.io.*;

public class Main {

    public static int[] beads = new int[5];// 구슬 종류는 최대 5개
    public static HashMap<String, Long> dp = new HashMap<>();//상태 문자열 
    public static int N;
    public static int total=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(br.readLine().trim());
            total+=beads[i];
        }

        // prevSecond, prev 에 -1. -1은 탐색하지 않는 인덱스
        long answer = backtracking(-1, -1, Arrays.toString(beads));
        System.out.println(answer);
    }

    //prevSecond: 두 번 전 구슬 색, prev: 한 번 전 구슬 색, necklace: 현재 beads 상태 문자열
    public static long backtracking(int prevSecond, int prev, String necklace) {
    	
    	if (total == 0) return 1;
    	
    	// 1) 키 생성
        String key = prevSecond + "," + prev + "," + necklace;

        // 2) 이미 계산된 상태면 바로 반환
        if (dp.containsKey(key)) return dp.get(key);
        

        // 3) 재귀 탐색
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (beads[i] == 0) continue;
            if (i == prev || i == prevSecond) continue;
            beads[i]--;
            total--;
            cnt += backtracking(prev, i, Arrays.toString(beads));
            total++;
            beads[i]++;
        }

        dp.put(key, cnt);
        return cnt;
    }
}
