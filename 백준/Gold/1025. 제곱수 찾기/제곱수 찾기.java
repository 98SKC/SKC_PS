import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int result = -1; // 최종 결과를 저장할 변수 (가장 큰 완전 제곱수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); // 행의 개수
        m = Integer.parseInt(s[1]); // 열의 개수

        arr = new int[n][m]; // 입력 배열 초기화

        // 입력 배열 채우기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }

        // 모든 위치에 대해 완전 제곱수 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 가능한 모든 방향에 대해 진행
                for (int di = -n; di <= n; di++) {
                    for (int dj = -m; dj <= m; dj++) {
                        if (di == 0 && dj == 0) continue; // 정지하는 경우 제외
                        int num = 0; // 현재 숫자 초기화
                        int x = i, y = j; // 현재 위치 초기화

                        // 등차수열을 따라 숫자 생성
                        while (x >= 0 && x < n && y >= 0 && y < m) {
                            num = num * 10 + arr[x][y]; // 숫자 이어붙이기
                            if (isPerfectSquare(num)) { // 완전 제곱수인지 확인
                                result = Math.max(result, num); // 결과 업데이트
                            }
                            x += di; // 다음 행 위치
                            y += dj; // 다음 열 위치
                        }
                    }
                }
            }
        }
        System.out.println(result); // 결과 출력
    }

    // 완전 제곱수 확인 함수
    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num); // 제곱근 계산
        return sqrt * sqrt == num; // 제곱근의 제곱이 원래 숫자와 동일한지 확인
    }
}
