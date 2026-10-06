class Solution {
    public int solution(int a, int b) {
        // 1. 최대공약수를 구해 분모를 기약분수 상태의 분모로 만들기
        b = b / gcd(a, b);
        
        // 2. 2와 5로 나누기
        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }
        
        // 3. 분모가 1이 남으면 유한소수(1), 아니면 무한소수(2)
        return (b == 1) ? 1 : 2;
    }
    
    // 최대공약수(GCD) 구하는 유클리드 호제법 메서드
    private int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
