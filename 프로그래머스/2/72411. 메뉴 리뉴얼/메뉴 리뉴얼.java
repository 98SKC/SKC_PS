import java.io.*;
import java.util.*;

class Solution {

    public List<Character> sub = new ArrayList<>(); 
    public List<String> list = new ArrayList<>(); // 최종 답이 들어갈 곳

    // 각 goal 주기마다 조합의 카운트를 임시 저장할 Map
    public Map<String, Integer> tempMap = new HashMap<>(); 

    public String[] order;
    public int end = 0; 
    public int len;
    public HashSet<Character> set = new HashSet<>();
    public char[] arr;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        order = orders;
        len = orders.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                set.add(orders[i].charAt(j));
            }
        }

        for (char c : set) {
            sub.add(c);
        }

        Collections.sort(sub);

        arr = new char[sub.size()];
        end = arr.length;
        int cnt = 0;
        for (char c : sub) {
            arr[cnt++] = c;
        }
        sub.clear();

        // 코스 길이별로 탐색
        for (int goal : course) {
            tempMap.clear(); // 새로운 길이를 탐색할 때마다 임시 맵 초기화
            
            helper(0, 0, goal);

            // 이번 글자 수(goal) 조합 중 가장 많이 주문된 횟수(최댓값) 찾기
            int max = 0;
            for (int count : tempMap.values()) {
                max = Math.max(max, count);
            }

            // 최소 2번 이상 주문되었고, 최댓값과 일치하는 1등 조합만 최종 list에 추가
            if (max >= 2) {
                for (String key : tempMap.keySet()) {
                    if (tempMap.get(key) == max) {
                        list.add(key);
                    }
                }
            }
        }

        int sl = list.size();
        answer = new String[sl];
        for (int i = 0; i < sl; i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    public void helper(int pos, int cnt, int goal) {

        if (cnt == goal) {
            int ccnt = 0; 

            for (int i = 0; i < len; i++) {
                boolean check = true;

                for (char c : sub) { 
                    if (!order[i].contains(String.valueOf(c))) {
                        check = false;
                        break;
                    }
                }
                
                if (check) {
                    ccnt++; 
                }
            }

       
            if (ccnt >= 2) { 
                StringBuilder s = new StringBuilder();
                for (Character c : sub) {
                    s.append(c);
                }
                tempMap.put(s.toString(), ccnt);
            }
            return;
        }

        if (pos == end) {
            return;
        }

        sub.add(arr[pos]);
        helper(pos + 1, cnt + 1, goal);
        sub.remove(Character.valueOf(arr[pos]));
        helper(pos + 1, cnt, goal);
    }
}