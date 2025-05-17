import java.io.*;
import java.util.*;

class Solution {
    public int[] next;
    public int N;
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> q= new ArrayDeque<>();
        
        N=A.length;
        Arrays.sort(B);
        for(int i=0;i<N;i++){
            q.add(B[i]);
        }
        
        for(int i=0;i<N;i++){
            pq.add(A[i]);
        }
        
        int target;
        while(!pq.isEmpty()){
            target=pq.poll();
            if(q.peekLast()>target){
                q.pollLast();
                answer++;
            }else{
                q.pollFirst();
            }
        }
        return answer;
    }
    
}