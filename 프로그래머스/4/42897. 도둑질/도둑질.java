class Solution {
    public int solution(int[] money) {
        int N = money.length;

        // case 1: 0번 집을 털고, 마지막 집 제외
        int[] dp1 = new int[N]; // 0번 집 턴 경우
        dp1[0] = money[0];
        dp1[1] = money[0];// 0번을 털었으니, 
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);//i-1을 선택. 이번에 털지 않는다./ i-2를 선택. 이번에 턴다.
        }
        

        // case 2: 0번 집을 안 털고, 마지막 집 포함 가능
        int[] dp2 = new int[N]; // 0번 집 안 턴 경우
        dp2[0] = 0;
        dp2[1] = money[1];//1번까지 고려했을 때 
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[N - 2], dp2[N - 1]);
    }
}
