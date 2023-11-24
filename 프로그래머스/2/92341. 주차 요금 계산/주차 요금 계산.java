import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> timeMap = new HashMap<>(); // 각 차량의 누적 주차 시간을 저장
        HashMap<String, Integer> inMap = new HashMap<>(); // 각 차량의 최근 입차 시간을 저장

        for(String record : records) {
            String[] splitRecord = record.split(" ");
            int time = Integer.parseInt(splitRecord[0].substring(0, 2)) * 60 + Integer.parseInt(splitRecord[0].substring(3));
            String carNum = splitRecord[1];

            if(splitRecord[2].equals("IN")) {
                inMap.put(carNum, time);
            } else { // OUT
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + time - inMap.get(carNum));
                inMap.remove(carNum);// 차량 나갔으니 제외.
            }
        }

        for(String carNum : inMap.keySet()) { // 아직 출차하지 않은 차량에 대해 처리-> 안나간 차량은 23시59분에 나간것으로 처리.
            timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + 1439 - inMap.get(carNum));
        }

        List<String> carList = new ArrayList<>(timeMap.keySet());
        Collections.sort(carList); // 차량 번호 순으로 정렬

        int[] answer = new int[carList.size()];
        for(int i = 0; i < carList.size(); i++) { // 각 차량에 대해 요금 계산
            int time = timeMap.get(carList.get(i));
            answer[i] = fees[1];
            if(time > fees[0]) {
                answer[i] += (int)Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];
            }
        }

        return answer;
    }
}
