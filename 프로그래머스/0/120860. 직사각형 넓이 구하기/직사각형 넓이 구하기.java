import java.lang.Math;

class Solution {
    public int solution(int[][] dots) {
        // x와 y의 최댓값, 최솟값을 구하기 위해 초기값 설정
        int minX = dots[0][0];
        int maxX = dots[0][0];
        int minY = dots[0][1];
        int maxY = dots[0][1];
        
        // 4개의 점을 순회하며 최댓값과 최솟값을 갱신
        for (int i = 1; i < dots.length; i++) {
            minX = Math.min(minX, dots[i][0]);
            maxX = Math.max(maxX, dots[i][0]);
            minY = Math.min(minY, dots[i][1]);
            maxY = Math.max(maxY, dots[i][1]);
        }
        
        // (가로 길이 = maxX - minX) * (세로 길이 = maxY - minY)
        return (maxX - minX) * (maxY - minY);
    }
}
