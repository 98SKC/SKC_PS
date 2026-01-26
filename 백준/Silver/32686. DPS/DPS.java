import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long S, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        E = Long.parseLong(st.nextToken());

        double ans = 0.0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long R = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());
            ans += calcOneSkill(R, A, D);
        }

        double duration = (double)(E - S);   // 측정 시간
        double dps = ans / duration;         // DPS 정의대로

        System.out.printf("%.10f%n", dps);
    }

    // 한 스킬이 [S,E) 구간에 준 총 데미지
    static double calcOneSkill(long R, long A, long D) {
        long P = R + A;
        if (S >= E) return 0.0;
        if (A == 0) return 0.0;

        double dps = (double) D / (double) A;

        // attackTime = [S,E)에서 공격중인 총 시간
        long attackTime = 0;

        // 1) S가 속한 주기의 "주기 시작"으로 맞추기
        long base = floorDiv(S, P) * P; // 해당 주기 시작 시간
        long t = S;

        // 2) 첫 부분 처리: t ~ min(E, base+P)
        long endOfThisPeriod = base + P;
        long segEnd = Math.min(E, endOfThisPeriod);
        attackTime += overlapLen(t, segEnd, base + R, base + R + A);

        t = segEnd;
        base = endOfThisPeriod;

        if (t >= E) return attackTime * dps;

        // 3) 중간 개수 처리
        // base는 현재 주기 시작(=t의 주기 시작)이지만, 지금은 t==base 상태임
        long remaining = E - base;
        long full = remaining / P;          // 완전 주기 개수
        if (full > 0) {
            attackTime += full * A;         // 완전 주기마다 공격시간은 A
            base += full * P;
            t = base;
        }

        if (t >= E) return attackTime * dps;

        // 4) 마지막 부분 처리: base ~ E
        attackTime += overlapLen(t, E, base + R, base + R + A);

        return attackTime * dps;
    }

    // [l1,r1) 와 [l2,r2) 교집합 길이
    static long overlapLen(long l1, long r1, long l2, long r2) {
        long L = Math.max(l1, l2);
        long R = Math.min(r1, r2);
        return Math.max(0, R - L);
    }

    // 음수에서도 안전한 floorDiv
    static long floorDiv(long a, long b) {
        long q = a / b;
        long r = a % b;
        if (r != 0 && ((r > 0) != (b > 0))) q--;
        return q;
    }
}



