import java.io.*;
import java.util.*;


class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        int len=my_string.length();
        for(int j=0;j<len;j++){
            for(int i=0;i<n;i++){
                sb.append(my_string.charAt(j));
            }
        }
        
        answer=sb.toString();
        return answer;
    }
}