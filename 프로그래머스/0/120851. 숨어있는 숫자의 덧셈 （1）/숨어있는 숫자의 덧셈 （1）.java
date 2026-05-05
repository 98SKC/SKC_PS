class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            // 숫자인 경우
            if (Character.isDigit(ch)) {
                answer += ch - '0'; // 문자 → 숫자 변환
            }
        }
        
        return answer;
    }
}