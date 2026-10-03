import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for (String str : intStrs) {
            // s번 인덱스부터 시작해서 길이 l만큼 잘라냅니다 (종료 인덱스는 s + l)
            String subStr = str.substring(s, s + l);
            
            // 잘라낸 문자열을 정수로 변환합니다
            int value = Integer.parseInt(subStr);
            
            // 변환한 정수값이 k보다 크면 리스트에 추가합니다
            if (value > k) {
                list.add(value);
            }
        }
        
        // List를 int[] 배열로 변환하여 반환합니다
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
