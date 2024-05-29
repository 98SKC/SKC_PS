import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        // 노드의 출입 횟수를 저장할 Map 생성
        Map<Integer, int[]> nodeCnt = new HashMap<>();
        // 정답을 저장할 배열 초기화
        int[] answer = {0, 0, 0, 0};

        // 각 엣지에 대해 반복
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            // 노드 a와 b가 Map에 없으면 추가
            if (!nodeCnt.containsKey(a)) {
                nodeCnt.put(a, new int[]{0, 0});
            }
            if (!nodeCnt.containsKey(b)) {
                nodeCnt.put(b, new int[]{0, 0});
            }

            // a 노드의 나가는 엣지 개수 증가
            nodeCnt.get(a)[0] += 1;
            // b 노드의 들어오는 엣지 개수 증가
            nodeCnt.get(b)[1] += 1;
        }

        // 각 노드에 대해 반복
        int[] cnts;
        for (int key : nodeCnt.keySet()) {
            cnts = nodeCnt.get(key);

            // 나가는 엣지가 2개 이상이고 들어오는 엣지가 0개인 노드 찾기
            // 추가된 정점은 그래프의 각 임의의 정점 하나에 뻗는 간선만 존재함. -> 들어오는 엣지가 없음
            // 또한 모양 그래프를 살펴보면, 막대 그래프를 제외하고는 모든 정점이 나가고 들어오고가 있음. 막대도 나가는게 두선은 아님.
            if (cnts[0] >= 2 && cnts[1] == 0) {
                answer[0] = key;
            // 나가는 엣지가 0개이고 들어오는 엣지가 1개 이상인 노드 찾기-> 막대그래프의 마지막 노드
            } else if (cnts[0] == 0 && cnts[1] > 0) {
                answer[2]++;
            // 나가는 엣지와 들어오는 엣지가 각각 2개 이상인 노드 찾기-> 도넛 그래프의 연결고리
            } else if (cnts[0] >= 2 && cnts[1] >= 2) {
                answer[3]++;
            }
        }

        // 도넛 그래프의 개수 계산->시작점의 나가는 간선 개수에서 막대형과 8자형 그래프의 개수를 뺌
        //시작점, 새로 만든 정점은 각 모양그래프로 모두 뻗어나간 상태.
        answer[1] = nodeCnt.get(answer[0])[0] - answer[2] - answer[3];

        // 결과 반환
        return answer;
    }
}
