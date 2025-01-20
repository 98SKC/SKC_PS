import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] train = new int[N + 1]; // 기차 상태를 비트마스크로 표현
        int order, target, seat;

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            if (order < 3) { // 사람 태우기(1), 내리기(2)
                seat = Integer.parseInt(st.nextToken());
                if (order == 1) { // 사람 태우기
                    train[target] |= 1 << (seat - 1);
                } else { // 사람 내리기
                    train[target] &= ~(1 << (seat - 1));
                }
            } else { // 좌우 이동 명령
                if (order == 3) { // 뒤로 한 칸 이동
                    train[target] <<= 1;
                    train[target] &= (1 << 20) - 1; // 20비트 초과 제거
                } else { // 앞으로 한 칸 이동
                    train[target] >>= 1;
                }
            }
        }

        // 은하수를 건널 수 있는 기차 상태의 개수 계산
        HashSet<Integer> v = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            v.add(train[i]);
        }

        System.out.println(v.size());
    }
}