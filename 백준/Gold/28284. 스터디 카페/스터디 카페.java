import java.util.*;
import java.io.*;

public class Main {

    static class Event implements Comparable<Event> {
        long time; // 이벤트 발생 시간
        int change; // 좌석 점유 변화 (1은 시작, -1은 종료)

        Event(long time, int change) {
            this.time = time;
            this.change = change;
        }

        @Override
        public int compareTo(Event o) {
            return Long.compare(this.time, o.time); // 시간 순으로 정렬
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cost);

        long[] preMin = new long[N + 1];
        long[] preMax = new long[N + 1];

        preMin[1] = cost[0];
        preMax[1] = cost[N - 1];

        for (int i = 2; i <= N; i++) {
            preMin[i] = preMin[i - 1] + cost[i - 1];
            preMax[i] = preMax[i - 1] + cost[N - i];
        }

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken()) + 1;
            events.add(new Event(start, 1));
            events.add(new Event(end, -1));
        }

        Collections.sort(events);

        long min = 0;
        long max = 0;
        int seat = 0; // 현재 좌석 점유 수
        long lastTime = events.get(0).time; // 마지막 이벤트 시간

        for (Event event : events) {
            if (event.time != lastTime) {
                long period = event.time - lastTime; // 이벤트 간의 기간 계산
                if (seat > 0) {
                    max += period * preMax[seat]; // 최대 수익 계산
                    min += period * preMin[seat]; // 최소 수익 계산
                }
                lastTime = event.time; // 마지막 이벤트 시간 업데이트
            }
            seat += event.change; // 현재 좌석 점유 수 업데이트
        }

        System.out.println(min + " " + max);
    }
}