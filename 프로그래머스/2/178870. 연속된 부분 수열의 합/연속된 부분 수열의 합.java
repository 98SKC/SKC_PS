class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int SL = sequence.length;
        int right = SL;
        int left = 0;
        int sum = 0;
        
        for(int L = 0, R = 0; L < SL; L++) {
            while(R < SL && sum < k) {
                sum += sequence[R++];
            }
            
            if(sum == k) {
                int len = R - L -1;
                if((right - left) > len) {
                    left = L;
                    right = R - 1;
                }
            }
            
            sum -= sequence[L];
        }
        
        int[] answer = {left, right};
        
        return answer;
    }
}