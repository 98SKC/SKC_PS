import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        // 1. 배열을 오름차순으로 정렬합니다.
        Arrays.sort(numbers);
        
        int n = numbers.length;
        
        // 2. 음수끼리의 곱과 양수끼리의 곱 중 더 큰 값을 선택합니다.
        int maxFromNegatives = numbers[0] * numbers[1];
        int maxFromPositives = numbers[n - 1] * numbers[n - 2];
        
        return Math.max(maxFromNegatives, maxFromPositives);
    }
}