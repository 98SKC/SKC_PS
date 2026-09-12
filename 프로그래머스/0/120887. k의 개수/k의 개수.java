class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int num = i; num <= j; num++) {
            int temp = num;
            while (temp > 0) {
                // 1의 자릿수가 k와 같으면 카운트 증가
                if (temp % 10 == k) {
                    answer++;
                }
                // 다음 자릿수로 이동
                temp /= 10;
            }
        }

        return answer;
    }
}