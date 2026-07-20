import java.io.*;
import java.util.*;


class Solution {
    
    public int[] parent;
    public int[] depth;
    public int total;
    
    public int solution(int n, int a, int b) {
        
        int answer = 0;

        //이거 이름이 분명 공통 조상 뭐시깽이였는데
        
        buildTree(n);
        answer=lca(a,b);

        return answer;
        
    }
    
    
    public void buildTree(int N) {

        parent = new int[2 * N + 1];
        depth = new int[2 * N + 1];

        List<Integer> cur = new ArrayList<>();

        // 리프 노드(1~N)
        for (int i = 1; i <= N; i++) {
            cur.add(i);
            depth[i] = 0;
        }

        int next = N + 1;

        while (cur.size() > 1) {

            List<Integer> nextLevel = new ArrayList<>();

            for (int i = 0; i < cur.size(); i += 2) {

                int left = cur.get(i);
                int right = cur.get(i + 1);

                int p = next++;

                parent[left] = p;
                parent[right] = p;

                depth[p] = depth[left] + 1;

                nextLevel.add(p);
            }

            cur = nextLevel;
        }
    }
    
    
    public int lca(int a, int b) {


        while (depth[b] < depth[a]) {
            a = parent[a];
        }

        // 함께 올라간다.
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        // 최소 공통 조상의 depth 반환
        return depth[a];
    }

}