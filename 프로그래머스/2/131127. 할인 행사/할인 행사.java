import java.util.*;

class Solution {

    public HashMap<String, Integer> map = new HashMap<>();
    public int[][] presum;
    public int len, s;

    public int solution(String[] want, int[] number, String[] discount) {

        len = discount.length;

        int cnt = 0;

        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(discount[i])) {
                map.put(discount[i], cnt++);
            }
        }

        s = map.size();
        presum = new int[s][len + 1];

        
        for (int i = 0; i < len; i++) {
            presum[map.get(discount[i])][i + 1] = 1;
        }

        // 누적합 계산
        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= len; j++) {
                presum[i][j] += presum[i][j - 1];
            }
        }

        int answer = 0;

        // 시작 가능한 날짜
        for (int i = 0; i <= len - 10; i++) {
            if (check(want, number, i)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(String[] want, int[] number, int pos) {

        for (int i = 0; i < want.length; i++) {

            String food = want[i];
            int goal = number[i];

            if (!map.containsKey(food)) return false;

            
            int index = map.get(food);
            int cnt = presum[index][pos + 10] - presum[index][pos];

            if (cnt != goal) {
                return false;
            }
        }

        return true;
    }
}