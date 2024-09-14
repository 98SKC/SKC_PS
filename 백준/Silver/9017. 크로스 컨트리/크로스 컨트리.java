import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken()); // T개의 테스트 케이스
        int[] answer = new int[T]; // 한번에 출력하기 위한 answer 배열
        for (int i = 0; i < T; i++) { // T번의 반복
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] ranks = new int[N]; // N등까지 존재함
            Map<Integer, Integer> countMap = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                countMap.put(data, countMap.getOrDefault(data, 0) + 1); // 해당팀의 인원이 6명되는지 체크
                ranks[j] = data; // 각 등수의 팀
                max = Math.max(max, data); // 가장 큰 번호의 팀
            }

            int[] fifthPlayer = new int[max + 1]; // 해당 팀의 5번째 선수
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int score = 1;

            for (int rank : ranks) {
                if (countMap.get(rank) == 6) { // 팀원이 6명 모두 통과한 팀만
                    tmpMap.put(rank, tmpMap.getOrDefault(rank, 0) + 1);

                    if (tmpMap.get(rank) <= 4) { // 해당팀의 4등까지만 점수를 기록함
                        scoreMap.put(rank, scoreMap.getOrDefault(rank, 0) + score);
                    }

                    if (tmpMap.get(rank) == 5) { // 해당 팀의 5번째 선수의 점수
                        fifthPlayer[rank] = score;
                    }

                    score++;

                }
            }
            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            for (Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);
                if (tmp < result) { // 점수가 가장 낮은팀이 우승
                    result = tmp;
                    fifthScore = fifthPlayer[key];
                    answer[i] = key;
                } else if (tmp == result) { // 점수가 동점일 경우 5번째 선수의 점수가 낮을 경우 우승
                    if (fifthScore > fifthPlayer[key]) {
                        answer[i] = key;
                    }
                }
            }
        }
        for (int i : answer) {
            System.out.println(i); // 출력
        }
    }
}