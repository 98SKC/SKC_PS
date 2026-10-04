class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        
        // 두 번째 원소(index 1)부터 시작해 이전 원소와의 차이를 비교합니다.
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            
            switch (diff) {
                case 1:
                    answer.append("w");
                    break;
                case -1:
                    answer.append("s");
                    break;
                case 10:
                    answer.append("d");
                    break;
                case -10:
                    answer.append("a");
                    break;
            }
        }
        
        return answer.toString();
    }
}
