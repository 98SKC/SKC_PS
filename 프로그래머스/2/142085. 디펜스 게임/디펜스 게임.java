import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int len=enemy.length;
        int max=0;
        int kill=0;
            
            
        for(int i=0;i<len;i++){
            kill+=enemy[i]; //지금까지 해치운 적의 수
            max+=enemy[i]; //무적으로 막을 수 있는 적의 수
            pq.add(enemy[i]);
            if(pq.size()>k){
                max-=pq.poll();
            }
            
            if(n<kill-max) break;
            
            answer=i+1;
            
        }
        
        return answer;
    }
}