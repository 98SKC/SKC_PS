import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                // flag[i]가 true면 arr[i]를 arr[i] * 2번 추가
                for (int j = 0; j < arr[i] * 2; j++) {
                    list.add(arr[i]);
                }
            } else {
                // flag[i]가 false면 마지막 arr[i]개의 원소를 제거
                for (int j = 0; j < arr[i]; j++) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        
        // ArrayList를 int[] 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
