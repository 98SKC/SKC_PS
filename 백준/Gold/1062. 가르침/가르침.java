import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static String[] str;
    public static boolean[] v = new boolean[26];
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        str = new String[N];
        
        if (K == 26) { // 모든 알파벳을 배울 수 있다면 모든 단어 읽기 가능
            System.out.println(N);
            return;
        }
        
        if (K < 5) { // 최소한의 필수 문자도 배우지 못하면 0 출력
            System.out.println(0);
            return;
        }

        K -= 5; // 기본적으로 "a, n, t, i, c"를 배우므로 제외하고 계산
        
        // 필수 알파벳 미리 선택
        v['a' - 'a'] = true;
        v['n' - 'a'] = true;
        v['t' - 'a'] = true;
        v['i' - 'a'] = true;
        v['c' - 'a'] = true;

        // 단어에서 "anta"와 "tica" 제거하고 중간 부분만 저장
        for (int i = 0; i < N; i++) {
            String sub = br.readLine();
            str[i] = sub.substring(4, sub.length() - 4);
        }

        back(0, 0);

        System.out.println(answer);
    }

    public static void back(int pos, int count) {
        if (count == K) { // K개의 알파벳을 선택했을 때 읽을 수 있는 단어 개수 계산
            int pass = 0;
            for (String word : str) {
                boolean canRead = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!v[word.charAt(j) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) pass++;
            }
            answer = Math.max(answer, pass);
            return;
        }

        for (int i = pos; i < 26; i++) {
            if (!v[i]) {
                v[i] = true;
                back(i + 1, count + 1);
                v[i] = false;
            }
        }
    }

}