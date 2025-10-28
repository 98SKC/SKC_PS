import java.io.*;
import java.util.*;

public class Main {

    static int ALPH = 26;


    static List<int[]> dictCounts = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s;
        while (true) {
            s = br.readLine();
            
            if (s.equals("-")) break;

            int[] cnt = new int[ALPH];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'A']++;
            }
            
            dictCounts.add(cnt);
        }


        while (true) {
            String q = br.readLine();
            if (q.equals("#")) break;

            int[] qCnt = new int[ALPH];
            for (int i = 0; i < q.length(); i++) {
                qCnt[q.charAt(i) - 'A']++;
            }

            int[] coverCount = new int[ALPH]; // 각 알파벳이 포함된 사전 단어 개수
            for (int[] w : dictCounts) {
                if (!canCover(w, qCnt)) continue;
                for (int a = 0; a < ALPH; a++) {
                    if (w[a] > 0) coverCount[a]++;
                }
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // 쿼리에 등장한 알파벳 대상으로 min/max 계산
            for (int a = 0; a < ALPH; a++) {
                if (qCnt[a] == 0) continue;
                min = Math.min(min, coverCount[a]);
                max = Math.max(max, coverCount[a]);
            }

            // min 알파벳들
            for (int a = 0; a < ALPH; a++) {
                if (qCnt[a] != 0 && coverCount[a] == min) {
                    sb.append((char) ('A' + a));
                }
            }
            sb.append(' ').append(min).append(' ');

            // max 알파벳들
            for (int a = 0; a < ALPH; a++) {
                if (qCnt[a] != 0 && coverCount[a] == max) {
                    sb.append((char) ('A' + a));
                }
            }
            sb.append(' ').append(max).append('\n');
        }

        System.out.print(sb);
    }
    //만들 수 있는지 확인
    static boolean canCover(int[] wordCnt, int[] bagCnt) {
        for (int a = 0; a < ALPH; a++) {
            if (wordCnt[a] > bagCnt[a]) return false;
        }
        return true;
    }
}
