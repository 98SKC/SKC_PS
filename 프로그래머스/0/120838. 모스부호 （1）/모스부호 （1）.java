class Solution {
    public String solution(String letter) {
        // a부터 z까지 대응하는 모스부호 배열 정의
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", 
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        
        StringBuilder answer = new StringBuilder();
        

        String[] words = letter.split(" ");
        
        for (String word : words) {
            for (int i = 0; i < morse.length; i++) {
                if (word.equals(morse[i])) {
                    answer.append((char)('a' + i));
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}