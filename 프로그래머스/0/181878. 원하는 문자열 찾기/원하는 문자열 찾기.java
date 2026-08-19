class Solution {
    public int solution(String myString, String pat) {
        int len = pat.length();
        myString= myString.toLowerCase();
        pat=pat.toLowerCase();
        for (int i = 0; i <= myString.length() - len; i++) {
            if (pat.equals(myString.substring(i, i + len))) {
                return 1;
            }
        }

        return 0;
    }
}