import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        BigInteger cnt = BigInteger.ONE; // 가능한 탐색 개수
        BigInteger sum = BigInteger.ONE; // 가능한 탐색들의 현재 노드 번호 합

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L') {
                sum = sum.multiply(BigInteger.valueOf(2));
            } else if (c == 'R') {
                sum = sum.multiply(BigInteger.valueOf(2)).add(cnt);
            } else if (c == 'P') {
                // 변화 없음
            } else if (c == '*') {
                sum = sum.multiply(BigInteger.valueOf(5)).add(cnt);
                cnt = cnt.multiply(BigInteger.valueOf(3));
            }
        }

        System.out.println(sum);
    }
}