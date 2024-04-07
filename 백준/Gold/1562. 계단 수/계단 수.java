import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[n+1][11][1<<10]; // dp[i][j][k]: 길이가 i이고, 마지막 숫자가 j이며, 
                                                 // 지금까지 나온 숫자들의 집합이 k일 때의 계단 수의 개수.

        //비트 마스킹:
        /* int S = 0; // 집합 초기화
         * S |= (1 << 1); // 1 추가 -> A |= B는 A = A | B와 동일한 의미
         * S |= (1 << 3); // 3 추가  -> S가 1010이 되어 3과 1을 포함 했다는 것을 의미
         * S &= ~(1 << 1); // 1 제거 -> 1을 1 시프트 한 위치를 not
         * S ^= (1 << 3); // 3 토글 (여기선 제거) 0과 1을 바꿈
         * (S & (1 << 2)) != 0; 원소 확인
         * */
        
        // 기본 경우 초기화: 길이가 1인 계단 수.
        for(int i=1; i<10; i++) {
            dp[1][i][1<<i] = 1; // i 숫자만으로 이루어진 1자리 계단 수는 1개이며,
                                // 이 때 i는 0이 될 수 없다 (계단 수는 0으로 시작할 수 없음).
        }

        // 길이가 2 이상인 계단 수를 찾는 과정
        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {// j는 마지막 숫자
                for(int k=0; k<1024; k++) { // 1024는 2^10, 즉 0부터 9까지의 숫자를 모두 포함할 수 있는
                                            // 최대 크기의 비트마스크. 10000000000  -> 0부분이 1이면 그 숫자가 포함되어있음
                							// 즉 k란 0~9까지의 숫자가 포함되어있는 
                    int bit = k | (1 << j); // 현재 숫자 j 를 k 집합에 추가한다.
                                            // 예: 현재 집합이 {2} (0100)이고, j가 3이면,
                                            // 결과 집합은 {2, 3} (1100)이 된다.

                    if(j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % 1000000000; // j가 0인 경우, 다음 숫자는 1만 가능.
                    }
                    else if(j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % 1000000000; // j가 9인 경우, 이전 숫자는 8만 가능.
                    }
                    else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % 1000000000; // 그 외의 경우, 이전 숫자는 j-1 또는 j+1.
                        // i길이의 j가 마지막인 수는, i-1 길이의 j보다 1작거나 같은 수 의 경로를 합하여 온 값.
                        //
                    }
                }
            }
        }

        long sum = 0;
        // 모든 숫자가 등장하는 계단 수의 총 개수를 합산
        for(int i=0; i<10; i++) {
            sum = (sum + dp[n][i][1023]) % 1000000000; // 1023 (1111111111)은 0부터 9까지 모든 숫자가 
                                                // 등장했다는 것을 나타내는 비트마스크.
        }

        System.out.println(sum); // 최종 결과 출력
    }

}