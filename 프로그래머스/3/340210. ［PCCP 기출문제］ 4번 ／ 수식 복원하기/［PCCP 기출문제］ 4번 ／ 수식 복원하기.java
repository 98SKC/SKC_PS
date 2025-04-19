import java.util.*;

public class Solution {
    public String[] solution(String[] expressions) {
        int n = expressions.length;

        // 전역 가능한 진법 초기화 (2~9)
        List<Integer> possibleBases = new ArrayList<>();
        for (int b = 2; b <= 9; b++) {
            possibleBases.add(b);
        }

        // 숫자로 완전히 주어진 식들로 진법 후보 걸러내기
        List<Integer> xIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = expressions[i].split(" ");
            String a = parts[0], op = parts[1], b = parts[2], c = parts[4];

            // 이 식에 등장하는 숫자로 최소 진법 결정
            int maxDigit = Math.max(maxDigitIn(a), maxDigitIn(b));
            if (!c.equals("X")) {
                maxDigit = Math.max(maxDigit, maxDigitIn(c));
            }
            int minBase = Math.max(2, maxDigit + 1);

            // minBase 미만인 진법 제거
            Iterator<Integer> baseIt = possibleBases.iterator();
            while (baseIt.hasNext()) {
                if (baseIt.next() < minBase) {
                    baseIt.remove();
                }
            }

            // X인 식은 나중에 처리
            if (c.equals("X")) {
                xIndices.add(i);
                continue;
            }

            // 남은 진법 후보 중에서 실제 수식이 틀리는 것 제거
            Iterator<Integer> it = possibleBases.iterator();
            while (it.hasNext()) {
                int base = it.next();

                // 숫자 문자열을 해당 진법 값으로 파싱
                int aVal = parseInBase(a, base);
                int bVal = parseInBase(b, base);
                int cVal = parseInBase(c, base);

                // 연산 결과 비교
                int calc = op.equals("+") ? (aVal + bVal) : (aVal - bVal);
                if (calc != cVal) {
                    it.remove();
                }
            }
        }

        // X 인 식들만 남은 진법으로 계산
        List<String> outputs = new ArrayList<>();
        for (int idx : xIndices) {
            String[] parts = expressions[idx].split(" ");
            String a = parts[0], op = parts[1], b = parts[2];

            // 각 진법에서 나오는 결과 문자열을 저장
            Set<String> reprs = new HashSet<>();
            for (int base : possibleBases) {
                int aVal = parseInBase(a, base);
                int bVal = parseInBase(b, base);
                int calc = op.equals("+") ? (aVal + bVal) : (aVal - bVal);

                // 정수 결과를 진법 문자열로 변환하여 집합에 추가
                reprs.add(toBaseString(calc, base));
            }

            // 결과가 유일하면 그 표현, 아니면 "?"
            String fill = (reprs.size() == 1)
                        ? reprs.iterator().next()
                        : "?";
            outputs.add(a + " " + op + " " + b + " = " + fill);
        }

        // 오직 = X 인 식들의 결과만 배열로 반환
        return outputs.toArray(new String[0]);
    }


    // 문자열 s 안의 최대 숫자(digit)를 반환
    private int maxDigitIn(String s) {
        int max = 0;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d > max) max = d;
        }
        return max;
    }

    // 주어진 진법에서 문자열 s를 10진수 정수로 파싱
    private int parseInBase(String s, int base) {
        int value = 0;
        for (char ch : s.toCharArray()) {
            value = value * base + (ch - '0');
        }
        return value;
    }

    // 10진수 정수 n을 주어진 진법의 문자열 표현으로 변환
    private String toBaseString(int n, int base) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int v = n;
        while (v > 0) {
            // 나머지를 문자로 변환 ('0' + remainder)
            sb.append((char)('0' + (v % base)));
            v /= base;
        }
        // 뒤집어서 완성
        return sb.reverse().toString();
    }
}
