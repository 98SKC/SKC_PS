class Solution {
    public int solution(int order) {
        int answer = 0;
        
        while (order > 0) {
            int digit = order % 10; // 마지막 자릿수 구하기
            
            // 자릿수가 3, 6, 9 중 하나인지 확인 (0은 제외해야 하므로 digit % 3 == 0 && digit != 0 도 가능)
            if (digit == 3 || digit == 6 || digit == 9) {
                answer++;
            }
            
            order /= 10; // 다음 자릿수로 이동
        }
        
        return answer;
    }
}