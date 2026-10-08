class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        // 1. 세 숫자가 모두 같은 경우
        if (a == b && b == c) {
            answer = (a + b + c) * 
                     (a*a + b*b + c*c) * 
                     (a*a*a + b*b*b + c*c*c);
        } 
        // 2. 세 숫자가 모두 다른 경우 (어느 두 수도 같지 않음)
        else if (a != b && b != c && c != a) {
            answer = a + b + c;
        } 
        // 3. 두 숫자만 같은 경우 (위의 두 조건에 해당하지 않는 모든 경우)
        else {
            answer = (a + b + c) * (a*a + b*b + c*c);
        }
        
        return answer;
    }
}
