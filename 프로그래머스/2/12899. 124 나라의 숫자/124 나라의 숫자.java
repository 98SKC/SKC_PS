class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % 3;

            if (r == 1) {
                sb.append("1");
                n /= 3;
            } else if (r == 2) {
                sb.append("2");
                n /= 3;
            } else {
                sb.append("4");
                n = n / 3 - 1;
            }
        }

        return sb.reverse().toString();
    }
}