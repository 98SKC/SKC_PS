class Solution {
    public long[] solution(int x, int n) {
        long[] result = new long[n];
        
        long value = x;
        
        for (int i = 0; i < n; i++) {
            result[i] = value;
            value += x;
        }
        
        return result;
    }
}