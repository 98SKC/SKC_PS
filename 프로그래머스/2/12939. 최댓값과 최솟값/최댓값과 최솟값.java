import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        // 문자열 s에 공백으로 구분된 숫자들이 저장.
        String[] str=s.split(" ");
        int len=str.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sub;
        
        for(int i=0;i<len;i++){
            sub=Integer.parseInt(str[i]);
            min=Math.min(min, sub);
            max=Math.max(max, sub);
            
        }
        answer=min+" "+max;
        return answer;
    }
}