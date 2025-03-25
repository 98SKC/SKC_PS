
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        boolean uplight = true;
        
        Stack<String> stack = new Stack<>();
      
        // 열리고 열리면 곱하고, 닫히고 열리면 더한다. 
        for (int i = 0; i < str.length(); i++) {
            
            if (!uplight) {
                System.out.println(0);
                return;
            }
            
            char current = str.charAt(i);
            
            if (current == '(') {
                stack.push("(");
            } else if (current == '[') {
                stack.push("[");
            } else if (current == ')') {
                
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    // 바로 짝을 이루면
                    stack.pop();
                    stack.push("2");
                } else { // 숫자가 들어가 있음
                    // 만약 스택이 비었거나, top이 '['면 잘못된 괄호
                    if (stack.isEmpty() || stack.peek().equals("[")) {
                        uplight = false;
                        continue;
                    }
                    
                    int sub = Integer.parseInt(stack.pop());
                    
                    // 스택이 비어있지 않으면서, top이 괄호가 아닐 경우 계속 더한다.
                    while (!stack.isEmpty() && (!stack.peek().equals("(") && !stack.peek().equals("["))) {
                        sub += Integer.parseInt(stack.pop());
                    }
                    
                    sub *= 2;
                    
                    // 닫는 괄호에 맞는 여는 괄호가 있어야 함
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        uplight = false;
                        continue;
                    }
                    stack.pop();  
                    stack.push(String.valueOf(sub));
                }
                
            } else if (current == ']') {
                
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    // 바로 짝을 이루면
                    stack.pop();
                    stack.push("3");
                } else { // 숫자가 들어가 있음
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        uplight = false;
                        continue;
                    }
                    int sub = Integer.parseInt(stack.pop());
                    
                    while (!stack.isEmpty() && (!stack.peek().equals("(") && !stack.peek().equals("["))) {
                        sub += Integer.parseInt(stack.pop());
                    }
                    
                    sub *= 3;
                    
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        uplight = false;
                        continue;
                    }
                    stack.pop();
                    stack.push(String.valueOf(sub));
                }
            }

            // System.out.println("스택: " + stack.toString());
        }
        
        if (!uplight) {
            System.out.println(0);
            return;
        }
        
        int answer = 0;
        
        // 남은 스택의 값이 올바른 숫자들인지 확인
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(") || top.equals("[")) {
                answer = 0;
                break;
            }
            answer += Integer.parseInt(top);
        }
        System.out.println(answer);
    }
}
