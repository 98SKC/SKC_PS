import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        int len=arr.length;
        
        for(int i=0;i<len;i++){
            int sub=arr[i];
            for(int j=0;j<sub;j++){
                list.add(sub);
            }
        }
        
        int[] answer = list.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
        
        
        
        return answer;
    }
}