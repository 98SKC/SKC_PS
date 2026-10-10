class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        // 문자열의 처음부터 끝까지 한 칸씩 이동하며 확인
        for (int i = 0; i < myString.length(); i++) {
            // i번째 인덱스부터 pat 문자열로 시작하는지 확인
            if (myString.startsWith(pat, i)) {
                answer++;
            }
        }
        
        return answer;
    }
}
