class Solution {
    public String solution(String s) {
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
   
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1) {
                sb.append((char) (i + 'a'));
            }
        }
        
        return sb.toString();
    }
}
