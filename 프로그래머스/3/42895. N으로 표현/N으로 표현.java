import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 예외 처리: N 하나만으로 number를 만들 수 있는 경우
        if (N == number) return 1;

        // dp[i]: N을 정확히 i개 사용해서 만들 수 있는 모든 수의 집합
        // 예: dp[2]에는 5+5, 55, 5-5, 5*5, 5/5 등 모든 가능한 수가 포함됨
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>()); // N은 최대 8개까지 사용 가능하므로 크기 9
        }

        // N을 1개 사용해서 만들 수 있는 숫자는 자기 자신뿐
        dp.get(1).add(N);

        // N을 2개부터 8개까지 사용하여 만들 수 있는 숫자들을 채움
        for (int i = 2; i <= 8; i++) {
            // 예: N=5, i=3일 때, 555 같은 숫자도 직접 만들 수 있음
            String repeated = String.valueOf(N).repeat(i); // ex: "555"
            dp.get(i).add(Integer.parseInt(repeated));     // ex: 555

            // i를 두 부분으로 나누어 조합: j개 + (i-j)개
            for (int j = 1; j < i; j++) {
                HashSet<Integer> set1 = dp.get(j);       // N을 j개 사용한 숫자들
                HashSet<Integer> set2 = dp.get(i - j);   // N을 (i-j)개 사용한 숫자들

                // j개로 만들 수 있는 수자와 (i-j)개로 만들 수 있는 숫자를 조합하는 경우
                // set1의 숫자와 set2의 숫자를 사칙연산으로 조합
                for (int a : set1) {
                    for (int b : set2) {
                        dp.get(i).add(a + b);     // 덧셈
                        dp.get(i).add(a - b);     // 뺄셈
                        dp.get(i).add(a * b);     // 곱셈
                        if (b != 0) {
                            dp.get(i).add(a / b); // 나눗셈 (0 나누기 방지)
                        }
                    }
                }
            }

            // number가 현재 단계(i)에서 만들어졌다면 그게 최소 횟수이므로 바로 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8개까지 사용해서도 만들 수 없으면 -1 반환
        return -1;
    }
}
