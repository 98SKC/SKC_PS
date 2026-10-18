class Solution {
    public String solution(int age) {
        String answer = "";
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String ageStr = String.valueOf(age);
        
        for(int i = 0; i < ageStr.length(); i++) {
            int digit = Character.getNumericValue(ageStr.charAt(i));
            answer += alphabets[digit];
        }
        return answer;
    }
}