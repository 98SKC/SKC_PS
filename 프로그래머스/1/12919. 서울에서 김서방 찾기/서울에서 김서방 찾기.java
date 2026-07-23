import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        int len=seoul.length;
        for(int i=0;i<len;i++){
            if(seoul[i].equals("Kim")){
                answer="김서방은 "+i+"에 있다";
                break;
            }
        }
        
        
        return answer;
    }
}