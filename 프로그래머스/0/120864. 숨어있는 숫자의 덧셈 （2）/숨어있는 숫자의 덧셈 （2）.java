class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String[] split = my_string.split("[a-zA-Z]+");

        for (String s : split) {
            if (!s.isEmpty()) {
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}
