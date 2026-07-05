import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b) {
        
        int answer_A = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int answer_B = Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        
        if(answer_A > answer_B) {
            return answer_A;
        } else {
            return answer_B;
        }
    }
}