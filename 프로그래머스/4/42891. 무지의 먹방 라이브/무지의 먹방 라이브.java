import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long totalTime = 0;
        for (int t : food_times) {
            totalTime += t;
        }
        // 모든 음식을 먹을 수 있으면 -1 반환
        if (totalTime <= k) return -1;
        
        int n = food_times.length;
        int remainingFoods = n;
        long previous = 0;
        
        // 각 음식 소요시간에 대한 빈도수를 구함 (키: 음식 소요시간, 값: 해당 소요시간을 가진 음식 개수)
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int t : food_times) {
            long time = (long) t;
            freq.put(time, freq.getOrDefault(time, 0) + 1);
        }
        
        // 소요시간의 고유 값들을 오름차순으로 정렬
        List<Long> times = new ArrayList<>(freq.keySet());
        Collections.sort(times);
        
        // 남은 k와 남은 음식 개수를 고려하여 한 배치씩 소모
        for (long time : times) {
            long diff = time - previous;            // 이번 배치에서 줄일 음식 소요시간 차이
            long spend = diff * remainingFoods;      // 이번 배치에서 소모되는 전체 시간
            if (spend <= k) {
                k -= spend;
                remainingFoods -= freq.get(time);
                previous = time;
            } else {
                // k초 내에 배치 전체를 소모할 수 없으면 break
                break;
            }
        }
        
        // 남은 음식 중 아직 다 먹지 않은 음식의 번호(인덱스+1)를 리스트에 저장
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (food_times[i] > previous) {
                candidates.add(i + 1);
            }
        }
        // 원래 음식 번호 순으로 정렬 (i번째 음식 번호는 i+1이므로 이미 정렬된 상태임)
        Collections.sort(candidates);
        
        // 남은 k초에 해당하는 인덱스의 음식 번호 반환
        int index = (int)(k % remainingFoods);
        return candidates.get(index);
    }
}
