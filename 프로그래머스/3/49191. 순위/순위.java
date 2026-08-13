class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 1~n번호의 선수
        // 각자의 실력이 주어진다. 높은 사람이 무조건 승리
        // 순위가 확정이다 -> 모든 사람과의 간선이 연결되어 있다?
        
        boolean[][] rank=new boolean[n+1][n+1];// result를 마이그레이션
        for(int[] r:results){
            rank[r[0]][r[1]]=true; //r[0]이 r[1]를 이긴다.
        }
        
        boolean[][] v=new boolean[n+1][n+1];//상호관계가 명확한가
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(rank[i][k]&&rank[k][j]) rank[i][j]=true;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                if(rank[i][j]||rank[j][i]) v[i][j]=true;
            }
        }
        
        for(int i=1;i<=n;i++){
            int score=0;
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                if(v[i][j]) score++;
            }
            if(score==n-1) answer++;
        }
        
        return answer;
    }
}