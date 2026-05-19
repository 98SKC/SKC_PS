import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        int[] answer;
        int len=numlist.length;
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<len;i++){
            if(numlist[i]%n==0) list.add(numlist[i]);
        }
        answer=new int[list.size()];
        int point=0;
        for(Integer next:list){
            answer[point++]=next;
        }
        
        return answer;
    

    }
}