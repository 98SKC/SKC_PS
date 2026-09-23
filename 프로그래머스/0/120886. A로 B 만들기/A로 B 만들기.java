import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {

        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();

        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);

        String sortedBefore = new String(beforeChars);
        String sortedAfter = new String(afterChars);

        return sortedBefore.equals(sortedAfter) ? 1 : 0;
    }
}
