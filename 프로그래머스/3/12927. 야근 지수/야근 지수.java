import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        //배열 원소에서 N을 잘 뿜빠이해서 만든 결과를
        //제곱해서 더했을 때 최소값이 되는 경우를 반환해라
        
        //어떤 경우가 최소일까
        //dp로 해야하지 않을까
        //4 3 2   3 3 3
        // 수들이 분산이 적어야
        //구현만 하겠다-> 우선순위큐
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        
        int sub=0;
        
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        for(int i=0;i<n;i++){
            sub=pq.poll();
            if(sub==0) break;
            pq.add(sub-1);
        }
        
        while(!pq.isEmpty()){
            sub=pq.poll();
            answer+=sub*sub;
        }
        
        return answer;
    }
}