import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
      
        Arrays.sort(routes, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]); // 끝 지점을 기준으로 오름차순 정렬
            }
        });
        int answer = 0;
        int camera = Integer.MIN_VALUE;

        //차량 진출 시점에 카메라를 설치. 다음 카메라의 진입 시점이 카메라 지점보다
        //뒤라면 카메라를 그 차량의 진출 시점에 또 설치
        for (int[] route : routes) {
            if (route[0] > camera) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
