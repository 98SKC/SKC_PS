import java.io.*;
import java.util.*;

public class Main{
	
    // 각 주의 방송 기록
    static class WeekInfo {
        int count;    // 해당 주의 방송 횟수
        int duration; // 해당 주의 총 방송 시간(분). 60시간이니까 3600 이상.
        
        public WeekInfo() {
            this.count = 0;
            this.duration = 0;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 방송 기록 수
        int M = Integer.parseInt(st.nextToken()); // 마지막 날짜, M는 7의 배수
        
        int totalWeeks = M / 7; // 전체 주의 수. 나머지 조건이 문제에 없음
        //23일 봤으면 21일까지는 매주 방송했는지를 알 수 있음. 근데 남은 2일은 버리나. 최대한 활용하나 조건이 없다.
        
        // 각 유튜버별로 각 주에 대한 WeekInfo를 저장 
        Map<String, WeekInfo[]> map = new HashMap<>();
        

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            
            // 방송이 속한 주: 1일이 일요일이므로 (day-1)/7 계산
            int week = (day - 1) / 7;
            
            // 이름에 해당하는 데이터가 없다면 초기화 (길이 totalWeeks)
            if (!map.containsKey(name)) {
                WeekInfo[] weeks = new WeekInfo[totalWeeks];
                for (int j = 0; j < totalWeeks; j++) {
                    weeks[j] = new WeekInfo();
                }
                map.put(name, weeks);
            }
            
            // 시간 계산: "hh:mm" 형식을 분으로 변환
            int startMinutes = conversionTime(startTime);// split사용. 메서드로 빼자.
            int endMinutes = conversionTime(endTime);
            int diff = endMinutes - startMinutes;
            
            // 해당 주의 방송 횟수와 총 방송 시간 
            WeekInfo wi = map.get(name)[week];
            wi.count++;
            wi.duration += diff;
        }
        
        // 조건을 만족하는(모든 주마다 5회 이상, 총 60시간 이상) 유튜버를 선택
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            WeekInfo[] weeks = map.get(name);
            boolean qualifies = true;
            
            for (int i = 0; i < totalWeeks; i++) {
                if (weeks[i].count < 5 || weeks[i].duration < 60 * 60) { // 60시간 = 3600분
                    qualifies = false;
                    break;
                }
            }
            if (qualifies) {
                result.add(name);
            }
        }
        
        // 결과 출력: 사전 순으로 출력, 없으면 -1 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (String name : result) {
                System.out.println(name);
            }
        }
        
    }
    
    // "hh:mm" 문자열을 받아 분 단위로 변환하는 메소드
    private static int conversionTime(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}
