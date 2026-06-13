class Solution {
    
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            lcm = getLcm(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    private int getLcm(int a, int b) {
        return a / getGcd(a, b) * b;
    }
    
    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}