
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] order = new int[100001];

        int sub;
        int cnt = 0;
        while (true) {
            sub = Integer.parseInt(st.nextToken());
            if (sub == 0) {
                break;
            }
            order[cnt++] = sub;
        }
        // 계산할 것 없이 그냥 바로 표에 저장
        // 이동 비용 표 (0: 중앙, 1: 상, 2: 좌, 3: 하, 4: 우)
        int[][] cost = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
        };
        
        // score[left foot][right foot][턴]
        int[][][] score = new int[5][5][cnt];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(score[i][j], Integer.MAX_VALUE);
            }
        }
        // 0턴: 초기 중앙에서 첫 동작으로 이동
        score[0][order[0]][0] = cost[0][order[0]];
        score[order[0]][0][0] = cost[order[0]][0];
        
        
        int target;
        for (int i = 1; i < cnt; i++) {
            target = order[i];
            
            // 왼발을 움직이는 경우 (오른발이 target에 있으면 안 됨)
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (a == b || b == target) continue;
                    if (score[a][b][i - 1] == Integer.MAX_VALUE) continue;
                   
                    
                    // a에서 target으로 이동하는 비용: cost[a][target]
                    score[target][b][i] = Math.min(score[target][b][i], score[a][b][i - 1] + cost[a][target]);
                }
            }
            
            // 오른발을 움직이는 경우 (왼발이 target에 있으면 안 됨)
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (a == b || a == target) continue;
                    if (score[a][b][i - 1] == Integer.MAX_VALUE) continue;
                   
                    
                    // b에서 target으로 이동하는 비용: cost[b][target]
                    score[a][target][i] = Math.min(score[a][target][i], score[a][b][i - 1] + cost[b][target]);
                }
            }
        }
        
        
        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                answer = Math.min(answer, score[a][b][cnt - 1]);
            }
        }
        
        System.out.println(answer);
    }
}
