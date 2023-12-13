import java.io.*;
import java.util.*;

public class Main {
    public static Stack<Character> stack;

    public static Stack<Character> stack2;

    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        stack =new Stack<>();


        String str="aaa";
        while(true){
            //두번째 문제점. 반복마다 스택을 초기화를 하지 않음.

            str=br.readLine();
            if(str.equals(".")) break;


            if(checkStack(str)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            stack.clear();;

        }


    }
    public static boolean checkStack(String str){

        // 지금 코드의 문제점은 괄호의 짝만 고려하고 순서를 고려하지 않음에 있다.
        // [(]) 의 경우 괄호의 짝은 맞지만, 잘못된 경우이다.
        char[] arr = str.toCharArray();
        for(char c: arr){
                if(c=='('||c=='['){
                    stack.push(c);
                }else if(c==')'){
                    if(!stack.isEmpty()&&stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(c==']'){
                    if(!stack.isEmpty()&&stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}
