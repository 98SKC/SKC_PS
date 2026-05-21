import java.io.*;
import java.util.*;


class Solution {

    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack();

        int len=s.length();
        stack.push(s.charAt(0));

        for(int i=1;i<len;i++){

            if(!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }

        }

        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}