class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        int len=my_string.length();
        
        for(int i = 0; i < len; i++) {
            
            if(Character.isUpperCase(my_string.charAt(i))) {
                answer += Character.toLowerCase(my_string.charAt(i));
            } else {
                answer += Character.toUpperCase(my_string.charAt(i));
            }
            
        }
        return answer;
    }
}