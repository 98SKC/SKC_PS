public class Solution {
    
    public int solution(int n) {
        
        int ans = 0; 

        
        while (n != 0) {
           
            // n이 홀수이면
            if (n % 2 == 1) {
                ans++; // 건전지 개수 증가
            }

            // 순간이동 하기 전 위치로
            n /= 2;
        }

        return ans;
    }
}
