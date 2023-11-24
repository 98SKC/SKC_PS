class Solution {
    long[] arr;
    public int solution(int n) {
        arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        return (int)(fibo(n) % 1234567);
    }
    
    public long fibo(int n) {
        if(arr[n] == 0 && n != 0) {
            arr[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
        }
        return arr[n];
    }
}
